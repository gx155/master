package com.hand.study.app.job;

import com.github.javaparser.utils.Log;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.app.service.PaymentHeader37799Service;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;
import com.hand.study.domain.repository.PaymentLine37799Repository;
import org.apache.commons.collections4.MapUtils;
import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.message.MessageClient;
import org.hzero.boot.message.entity.Receiver;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 任务调度
 * @date: 2022/7/7 11:51
 */
@JobHandler("JobHandler-37799")
public class JobHandler37799 implements IJobHandler {

    @Autowired
    private PaymentHeader37799Repository paymentHeader37799Repository;
    @Autowired
    private PaymentHeader37799Service paymentHeader37799Service;
    @Autowired
    private PaymentLine37799Repository paymentLine37799Repository;
    @Autowired
    private MessageClient messageClient;


    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {

        if (MapUtils.isNotEmpty(map) && map.containsKey("PAY")){
            System.out.println("PAY带参数！");
            //获取单据状态为APPROVE的数据
            List<PaymentHeader37799> approveList = paymentHeader37799Repository.selectByCondition(
                    Condition.builder(PaymentHeader37799.class).andWhere(Sqls.custom().andEqualTo(PaymentHeader37799.FIELD_PAYMENT_STATUS, "APPROVE")).build()
            );
            //获取headerId
            List<Long> collect = approveList.stream().map(PaymentHeader37799::getHeaderId).collect(Collectors.toList());

            //通过headerId获取行信息
            List<PaymentLine37799> paymentLine37799s = paymentLine37799Repository.selectByCondition(
                    Condition.builder(PaymentLine37799.class).andWhere(Sqls.custom().andIn(PaymentLine37799.FIELD_HEADER_ID, collect)).build()
            );

            //修改支付标志，写入支付完成时间
            paymentLine37799s.forEach(paymentLine37799 -> {
                paymentLine37799.setPayFlag("Y");
                paymentLine37799.setPaymentDate(new Date());
            });
            paymentLine37799Repository.batchInsertSelective(paymentLine37799s);
        }
        HeaderIdStatusDTO headerIdStatusDTO = new HeaderIdStatusDTO();


        List<PaymentHeader37799> paymentHeader37799List = paymentHeader37799Repository.selectAll();
        paymentHeader37799List.stream().forEach(paymentHeader37799 -> {
            if(!ObjectUtils.isEmpty(paymentHeader37799)) {
                //写入审批时间
                paymentHeader37799.setApprovalDate(new Date());

                if (paymentHeader37799.getHeaderId() % 2 == 0) {
                    headerIdStatusDTO.setHeaderId(paymentHeader37799.getHeaderId());
                    paymentHeader37799.setPaymentStatus("APPROVE");
                    headerIdStatusDTO.setStatus(paymentHeader37799.getPaymentStatus());

                    //更新
                    paymentHeader37799Service.statusUpdateByHeaderId(headerIdStatusDTO);
                    //消息发送

                    messageSend(paymentHeader37799.getPaymentNumber(), paymentHeader37799.getPaymentStatus());
                } else {
                    headerIdStatusDTO.setHeaderId(paymentHeader37799.getHeaderId());
                    paymentHeader37799.setPaymentStatus("REJECT");
                    headerIdStatusDTO.setStatus(paymentHeader37799.getPaymentStatus());

                    paymentHeader37799Service.statusUpdateByHeaderId(headerIdStatusDTO);
                    messageSend(paymentHeader37799.getPaymentNumber(), paymentHeader37799.getPaymentStatus());
                }
            }
        });

        return ReturnT.SUCCESS;
    }

    private void messageSend(String paymentNumber,String status){

        Receiver receiver = new Receiver().setUserId(2L).setTargetUserTenantId(0L);
        Map<String,String> args = new HashMap<>();
        args.put("paymentNumber",paymentNumber);
        args.put("updateTime",new Date().toString());
        args.put("status",status);
        messageClient.sendWebMessage(0L,"HZERO-MESSAGE-TEMPLATE-37799","zh_CN", Collections.singletonList(receiver),args);
    }

    @Override
    public void onCreate(SchedulerTool tool) {
        IJobHandler.super.onCreate(tool);
    }

    @Override
    public void onException(SchedulerTool tool) {
        IJobHandler.super.onException(tool);
    }

    @Override
    public void onFinish(SchedulerTool tool, ReturnT returnT) {
        IJobHandler.super.onFinish(tool, returnT);
    }
}
