package com.hand.study.app.service.impl;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.app.service.InvoiceHeader37799Service;
import com.hand.study.domain.entity.InvoiceHeader37799;
import com.hand.study.domain.entity.InvoiceLine37799;
import com.hand.study.domain.repository.InvoiceHeader37799Repository;
import com.hand.study.domain.repository.InvoiceLine37799Repository;
import com.hand.study.infra.mapper.InvoiceLine37799Mapper;
import com.hand.study.infra.util.HeaderAndLineStatus;
import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.oauth.DetailsHelper;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.boot.message.MessageClient;
import org.hzero.boot.message.entity.Receiver;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * 单据表(InvoiceHeader37799)应用服务
 *
 * @author gx
 * @since 2022-07-11 10:44:25
 */
@Service
public class InvoiceHeader37799ServiceImpl implements InvoiceHeader37799Service {
    @Autowired
    private InvoiceHeader37799Repository invoiceHeader37799Repository;

    @Autowired
    private InvoiceLine37799Repository invoiceLine37799Repository;

    @Autowired
    private InvoiceLine37799Mapper invoiceLine37799Mapper;

    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    @Override
    public Page<InvoiceHeader37799> selectList(PageRequest pageRequest, InvoiceHeader37799 invoiceHeader37799) {
        return PageHelper.doPageAndSort(pageRequest, () -> invoiceHeader37799Repository.selectList(invoiceHeader37799));
    }

    @Autowired
    private MessageClient messageClient;

    @Override
    public void saveData(InvoiceHeader37799 invoiceHeader37799) {
        Map<String,String> employee37799 = new HashMap<>(16);
        employee37799.put("employee37799", String.valueOf(invoiceHeader37799.getEmployeeId()));
        //编码生成
        String code = codeRuleBuilder.generateCode("HZERO.37799.INVOICE.NUMBER",employee37799);

        Long headerId = invoiceHeader37799.getHeaderId();

        if (headerId == null){
            invoiceHeader37799.setInvoiceNumber(code);
            invoiceHeader37799.setInvoiceStatus(HeaderAndLineStatus.FIELD_NEW);
            invoiceHeader37799Repository.insert(invoiceHeader37799);
            messageSend("HZERO-MESSAGE-UPDATE-37799",invoiceHeader37799.getInvoiceNumber(),invoiceHeader37799.getInvoiceStatus());
        }else {
            InvoiceHeader37799 oldData = invoiceHeader37799Repository.selectByCondition(
                    Condition.builder(InvoiceHeader37799.class).andWhere(Sqls.custom().andEqualTo(InvoiceHeader37799.FIELD_HEADER_ID, headerId)).build()
            ).get(0);
            if ((HeaderAndLineStatus.FIELD_NEW.equals(oldData.getInvoiceStatus()) || HeaderAndLineStatus.FIELD_REJECT.equals(oldData.getInvoiceStatus())) && DetailsHelper.getUserDetails().getUserId().equals(oldData.getEmployeeId())){
                InvoiceHeader37799 newData = new InvoiceHeader37799();
                newData.setInvoiceNumber(oldData.getInvoiceNumber());
                newData.setCompanyId(invoiceHeader37799.getCompanyId());
                newData.setUnitId(invoiceHeader37799.getUnitId());
                newData.setPositionId(invoiceHeader37799.getPositionId());
                newData.setEmployeeId(invoiceHeader37799.getEmployeeId());
                newData.setAccEntityId(invoiceHeader37799.getAccEntityId());
                newData.setDateOfApplication(oldData.getDateOfApplication());
                newData.setInvoiceType(invoiceHeader37799.getInvoiceType());
                newData.setCurrency(invoiceHeader37799.getCurrency().isEmpty() ?oldData.getCurrency():invoiceHeader37799.getCurrency());
                newData.setInvoiceTransaction(invoiceHeader37799.getInvoiceTransaction().isEmpty() ?oldData.getInvoiceTransaction():invoiceHeader37799.getInvoiceTransaction());
                invoiceHeader37799Repository.updateByPrimaryKey(newData);
            }
        }

        List<InvoiceLine37799> invoiceLine37799List = invoiceHeader37799.getInvoiceLine37799List();

        if (invoiceLine37799List != null) {
            Long finalHeaderId = headerId;
            InvoiceHeader37799 header37799 = invoiceHeader37799Repository.selectByCondition(
                    Condition.builder(InvoiceHeader37799.class).andWhere(Sqls.custom().andEqualTo(InvoiceHeader37799.FIELD_HEADER_ID, headerId)).build()
            ).get(0);
            //新增或更新

            invoiceLine37799List.stream().forEach(invoiceLine37799 -> {

                if (HeaderAndLineStatus.FIELD_NEW.equals(header37799.getInvoiceStatus()) || HeaderAndLineStatus.FIELD_REJECT.equals(header37799.getInvoiceStatus())) {
                    throw new CommonException("hfins.fm.error.state1.37799");
                } else if (header37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())) {
                    throw new CommonException("hfins.fm.error.common.02.37799");
                }


                if (invoiceLine37799.getLineId() == null) {
                    //行增加
                    invoiceLine37799Repository.insert(invoiceLine37799);
                } else {
                    //获取更新前Version
                    InvoiceLine37799 oldLine = invoiceLine37799Mapper.selectOne(invoiceLine37799);

                    //行更新
                    if (invoiceLine37799.getObjectVersionNumber().equals(oldLine.getObjectVersionNumber())) {
                        invoiceLine37799Mapper.updateByPrimaryKey(invoiceLine37799);
                    } else {
                        throw new CommonException("hfins.fm.error.common.04.37799");
                    }
                }
            });

        }

    }

    @Override
    public Page<InvoiceHeader37799> selectInfoList(PageRequest pageRequest, AggregateQueryDTO aggregateQueryDTO) {
        PageHelper.doPageAndSort(pageRequest,() -> invoiceHeader37799Repository.selectInfoList(aggregateQueryDTO));
        return null;
    }

    @Override
    public void statusUpdateByHeaderId(HeaderIdStatusDTO headerIdStatusDTO) {
        InvoiceHeader37799 invoiceHeader37799 = invoiceHeader37799Repository.selectByCondition(Condition.builder(InvoiceHeader37799.class).andWhere(Sqls.custom().andEqualTo(InvoiceHeader37799.FIELD_HEADER_ID, headerIdStatusDTO.getHeaderId())).build()).get(0);
        //校验订单是否存在
        if(ObjectUtils.isEmpty(invoiceHeader37799)){
            throw new CommonException("hfins.fm.error.common.37799");
        }

        switch (invoiceHeader37799.getInvoiceStatus()){
            case HeaderAndLineStatus.FIELD_SUBMIT:
                if (HeaderAndLineStatus.FIELD_NEW.equals(invoiceHeader37799.getInvoiceStatus()) || HeaderAndLineStatus.FIELD_REJECT.equals(invoiceHeader37799.getInvoiceStatus()) ){
                throw new CommonException("hfins.fm.error.state1.37799");
            }else if(invoiceHeader37799.getEmployeeId().equals(DetailsHelper.getUserDetails().getUserId())){
                throw new CommonException("hfins.fm.error.common.02.37799");
            };
                break;
            case HeaderAndLineStatus.FIELD_APPROVE:
                if (invoiceHeader37799.getInvoiceStatus() != HeaderAndLineStatus.FIELD_SUBMIT){
                    throw new CommonException("hfins.fm.error.state2.37799");
                };
                break;
            case HeaderAndLineStatus.FIELD_REJECT:
                if (invoiceHeader37799.getInvoiceStatus() != HeaderAndLineStatus.FIELD_SUBMIT){
                    throw new CommonException("hfins.fm.error.state2.37799");
                };
                break;
            default:break;
        }
        invoiceHeader37799.setInvoiceStatus(headerIdStatusDTO.getStatus());
        invoiceHeader37799Repository.updateByPrimaryKey(invoiceHeader37799);
        messageSend("HZERO-MESSAGE-TEMPLATE-37799",invoiceHeader37799.getInvoiceNumber(),invoiceHeader37799.getInvoiceStatus());

    }

    private void messageSend(String code,String paymentNumber,String status){

        Receiver receiver = new Receiver().setUserId(2L).setTargetUserTenantId(0L);
        Map<String,String> args = new HashMap<>();
        args.put("paymentNumber",paymentNumber);
        args.put("updateTime",new Date().toString());
        args.put("status",status);
        messageClient.sendWebMessage(0L,code,"zh_CN", Collections.singletonList(receiver),args);
    }
}

