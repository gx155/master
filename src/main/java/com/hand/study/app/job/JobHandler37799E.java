package com.hand.study.app.job;

import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.app.service.InvoiceHeader37799Service;
import com.hand.study.domain.entity.InvoiceHeader37799;
import com.hand.study.domain.entity.InvoiceLine37799;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.InvoiceHeader37799Repository;
import com.hand.study.domain.repository.InvoiceLine37799Repository;
import com.hand.study.infra.util.HeaderAndLineStatus;
import org.apache.commons.collections4.MapUtils;
import org.hzero.boot.message.MessageClient;
import org.hzero.boot.message.entity.Receiver;
import org.hzero.boot.scheduler.infra.annotation.JobHandler;
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
@JobHandler("JobHandlerE-37799")
public class JobHandler37799E implements IJobHandler {

    @Autowired
    private InvoiceHeader37799Repository invoiceHeader37799Repository;
    @Autowired
    private InvoiceHeader37799Service invoiceHeader37799Service;
    @Autowired
    private InvoiceLine37799Repository invoiceLine37799Repository;
    @Autowired
    private MessageClient messageClient;


    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {



        if (MapUtils.isNotEmpty(map) && map.containsKey("IVO")){

            List<InvoiceHeader37799> invoiceHeader37799s = invoiceHeader37799Repository.selectByCondition(
                    Condition.builder(InvoiceHeader37799.class).andWhere(Sqls.custom().andEqualTo(InvoiceHeader37799.FIELD_INVOICE_STATUS,HeaderAndLineStatus.FIELD_COMPLETE)).build()
            );
            List<Long> headerIds = new ArrayList<>();
            invoiceHeader37799s.forEach(invoiceHeader37799 -> headerIds.add(invoiceHeader37799.getHeaderId()));

            List<InvoiceLine37799> invoiceLine37799s1 = invoiceLine37799Repository.selectByCondition(Condition.builder(InvoiceLine37799.class).andWhere(Sqls.custom().andIn(InvoiceLine37799.FIELD_HEADER_ID, headerIds)).build());

            invoiceLine37799s1.forEach(invoiceLine37799 -> {
                invoiceLine37799.setInvoiceDate(new Date());

            });
            System.out.println("PAY带参数！");
            //获取单据状态为APPROVE的数据
            List<InvoiceHeader37799> approveList = invoiceHeader37799Repository.selectByCondition(
                    Condition.builder(InvoiceHeader37799.class).andWhere(Sqls.custom().andEqualTo(InvoiceHeader37799.FIELD_INVOICE_STATUS, HeaderAndLineStatus.FIELD_APPROVE)).build()
            );
            approveList.forEach(invoiceHeader37799 -> invoiceHeader37799.setInvoiceStatus(HeaderAndLineStatus.FIELD_COMPLETE));

            invoiceHeader37799Repository.batchUpdateByPrimaryKeySelective(approveList);
            //获取headerId
            List<Long> collect = approveList.stream().map(InvoiceHeader37799::getHeaderId).collect(Collectors.toList());

            //通过headerId获取行信息
            List<InvoiceLine37799> invoiceLine37799s = invoiceLine37799Repository.selectByCondition(
                    Condition.builder(InvoiceLine37799.class).andWhere(Sqls.custom().andIn(InvoiceLine37799.FIELD_HEADER_ID, collect)).build()
            );


            //修改支付标志，写入支付完成时间
            invoiceLine37799s.forEach(invoiceLine37799 -> {
                invoiceLine37799.setPayFlag("Y");
                invoiceLine37799.setInvoiceDate(new Date());
            });
            invoiceLine37799Repository.batchInsertSelective(invoiceLine37799s);
        }
        HeaderIdStatusDTO headerIdStatusDTO = new HeaderIdStatusDTO();


        List<InvoiceHeader37799> InvoiceHeader37799List = invoiceHeader37799Repository.selectAll();
        InvoiceHeader37799List.stream().forEach(invoiceHeader37799 -> {
            if(!ObjectUtils.isEmpty(invoiceHeader37799)) {
                //写入审批时间
                invoiceHeader37799.setApprovalDate(new Date());

                if (invoiceHeader37799.getHeaderId() % 2 == 0) {
                    headerIdStatusDTO.setHeaderId(invoiceHeader37799.getHeaderId());
                    invoiceHeader37799.setInvoiceStatus(HeaderAndLineStatus.FIELD_APPROVE);
                    headerIdStatusDTO.setStatus(invoiceHeader37799.getInvoiceStatus());

                    //更新
                    invoiceHeader37799Service.statusUpdateByHeaderId(headerIdStatusDTO);
                    //消息发送

                    messageSend(invoiceHeader37799.getInvoiceNumber(), invoiceHeader37799.getInvoiceStatus());
                } else {
                    headerIdStatusDTO.setHeaderId(invoiceHeader37799.getHeaderId());
                    invoiceHeader37799.setInvoiceStatus(HeaderAndLineStatus.FIELD_REJECT);
                    headerIdStatusDTO.setStatus(invoiceHeader37799.getInvoiceStatus());

                    invoiceHeader37799Service.statusUpdateByHeaderId(headerIdStatusDTO);
                    messageSend(invoiceHeader37799.getInvoiceNumber(), invoiceHeader37799.getInvoiceStatus());
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
