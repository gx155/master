package com.hand.study.app.service.impl;

import com.hand.study.api.dto.ExportSheet;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentLine37799Repository;
import com.hand.study.infra.mapper.PaymentHeader37799Mapper;
import com.hand.study.infra.mapper.PaymentLine37799Mapper;
import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.core.oauth.DetailsHelper;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.PaymentHeader37799Service;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单据表(PaymentHeader37799)应用服务
 *
 * @author gx
 * @since 2022-07-05 12:42:33
 */
@Service
public class PaymentHeader37799ServiceImpl implements PaymentHeader37799Service {
    @Autowired
    private PaymentHeader37799Repository paymentHeader37799Repository;

    @Autowired
    private PaymentHeader37799Mapper paymentHeader37799Mapper;

    @Autowired
    private PaymentLine37799Repository paymentLine37799Repository;

    @Autowired
    private PaymentLine37799Mapper paymentLine37799Mapper;

    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    @Override
    public Page<PaymentHeader37799> selectList(PageRequest pageRequest, PaymentHeader37799 paymentHeader37799) {
        return PageHelper.doPageAndSort(pageRequest, () -> paymentHeader37799Repository.selectList(paymentHeader37799));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveData(PaymentHeader37799 paymentHeader37799) {
        Map<String,String> employee37799 = new HashMap<>(16);
        employee37799.put("employee37799", String.valueOf(paymentHeader37799.getEmployeeId()));
        //编码生成
        String code = codeRuleBuilder.generateCode("HZERO.37799.PAYMANET.NUMBER",employee37799);

        Long headerId = paymentHeader37799.getHeaderId();

        switch (paymentHeader37799.getHeaderId() == null ?1:0){
            case 1:
                //头ID为空进行新增
                paymentHeader37799.setPaymentNumber(code);
                paymentHeader37799.setPaymentStatus("NEW");
                //头新增
                paymentHeader37799Repository.insert(paymentHeader37799);

                headerId = paymentHeader37799Mapper.selectOne(paymentHeader37799).getHeaderId();
                break;
            case 0:
                //头ID不为空进行更新

                paymentHeader37799.setPaymentStatus("NEW");
                System.out.println(paymentHeader37799.getPaymentStatus()+"=============");
                if (!("NEW".equals(paymentHeader37799.getPaymentStatus())  || "REJECTED".equals(paymentHeader37799.getPaymentStatus()))){
                    throw new CommonException("hfins.fm.error.state1.37799");
                }
                if(paymentHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
                    throw new CommonException("hfins.fm.error.common.02.37799");
                }
                //更新前Version
                PaymentHeader37799 oldPaymentHeader = paymentHeader37799Mapper.selectOne(paymentHeader37799);

                paymentHeader37799Mapper.updateByPrimaryKey(paymentHeader37799);
                //头更新
//                if (oldPaymentHeader.getObjectVersionNumber().equals(paymentHeader37799.getObjectVersionNumber())){
//                    paymentHeader37799Mapper.updateByPrimaryKey(paymentHeader37799);
//                }else {
//                    throw new CommonException("hfins.fm.error.common.04.37799");
//                }

                break;
            default:break;
        }


        List<PaymentLine37799> line37799s = paymentHeader37799.getPaymentLine37799List();

        if (line37799s != null) {
            List<PaymentLine37799> insertLine = line37799s.stream().filter(line -> line.getLineId() == null).collect(Collectors.toList());
            List<PaymentLine37799> updateLine = line37799s.stream().filter(line -> line.getLineId() != null).collect(Collectors.toList());

            Long finalHeaderId = headerId;

            line37799s.stream().forEach(paymentLine37799 -> {
                PaymentHeader37799 paymentHeader37799Status = paymentHeader37799Repository.selectByCondition(Condition.builder(PaymentHeader37799.class).andWhere(Sqls.custom().andEqualTo(PaymentHeader37799.FIELD_HEADER_ID, finalHeaderId)).build()).get(0);

                if (!("NEW".equals(paymentHeader37799Status.getPaymentStatus())  || "REJECTED".equals(paymentHeader37799Status.getPaymentStatus()))) {
                    throw new CommonException("hfins.fm.error.state1.37799");
                } else if (paymentHeader37799Status.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())) {
                    throw new CommonException("hfins.fm.error.common.02.37799");
                }
                ;

                if (paymentLine37799.getLineId() == null) {
                    //行增加
                    paymentLine37799Repository.insert(paymentLine37799);
                } else {
                    //获取更新前Version
                    PaymentLine37799 oldLine = paymentLine37799Mapper.selectOne(paymentLine37799);

                    //行更新
                    if (paymentLine37799.getObjectVersionNumber().equals(oldLine.getObjectVersionNumber())) {
                        paymentLine37799Mapper.updateByPrimaryKey(paymentLine37799);
                    } else {
                        throw new CommonException("hfins.fm.error.common.04.37799");
                    }
                }
            });

        }
    }
    //SUBMITED/APPROVED/REJECTED
    @Override
    public void statusUpdateByHeaderId(HeaderIdStatusDTO headerIdStatusDTO) {
        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Repository.selectByHeaderId(headerIdStatusDTO.getHeaderId());

        //校验订单是否存在
        if (ObjectUtils.isEmpty(paymentHeader37799)) {
            throw new CommonException("hfins.fm.error.common.37799");
        }


        switch (paymentHeader37799.getPaymentStatus()){
            case "SUBMITTD":
                if ("NEW".equals(paymentHeader37799.getPaymentStatus()) || "REJECTED".equals(paymentHeader37799.getPaymentStatus()) ){
                    throw new CommonException("hfins.fm.error.state1.37799");
                }else if(paymentHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
                    throw new CommonException("hfins.fm.error.common.02.37799");
                };
                break;
            case "APPROVED":
                if (paymentHeader37799.getPaymentStatus() != "SUBMITED"){
                    throw new CommonException("hfins.fm.error.state2.37799");
                };
                break;
            case "REJECTED":
                if (paymentHeader37799.getPaymentStatus() != "SUBMITED"){
                    throw new CommonException("hfins.fm.error.state2.37799");
                }
            default:
                break;
        }
        paymentHeader37799.setPaymentStatus(headerIdStatusDTO.getStatus());
        paymentHeader37799Repository.updateByPrimaryKey(paymentHeader37799);
    }

    @Override
    public void deleteSlipByHeaderId(Long headerId) {
        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Repository.selectByPrimary(headerId);

        //校验订单是否存在
        if (ObjectUtils.isEmpty(paymentHeader37799)) {
            throw new CommonException("hfins.fm.error.common.37799");
        }
        if (!("NEW".equals(paymentHeader37799.getPaymentStatus()) || "REJECTED".equals(paymentHeader37799.getPaymentStatus())) ){
            throw new CommonException("hfins.fm.error.state1.37799");
        }
        if(paymentHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
            throw new CommonException("hfins.fm.error.common.02.37799");
        };

        PaymentLine37799 paymentLine37799 = new PaymentLine37799();
        paymentLine37799.setHeaderId(headerId);
        List<PaymentLine37799> paymentLine37799s = paymentLine37799Repository.selectByCondition(Condition.builder(PaymentLine37799.class).andWhere(Sqls.custom().andEqualTo(PaymentLine37799.FIELD_HEADER_ID,headerId)).build());

        paymentLine37799Repository.batchDeleteByPrimaryKey(paymentLine37799s);
        paymentHeader37799Repository.delete(paymentHeader37799);
    }

    @Override
    public List<ExportSheet> selectRTFData() {
        List<ExportSheet> list = new ArrayList<>();
        list.add(paymentLine37799Mapper.selectRTFData());
        System.out.println(list.toString());
        return list;
    }
}

