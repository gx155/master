package com.hand.study.infra.repository.impl;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.EntryInformationDTO;
import com.hand.study.domain.entity.PaymentHeader37799Vo;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentLine37799Repository;
import com.hand.study.infra.mapper.PaymentLine37799Mapper;
import org.hamcrest.internal.ArrayIterator;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.boot.platform.lov.adapter.LovAdapter;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.mybatis.domian.Condition;
import org.hzero.mybatis.util.Sqls;
import org.opensaml.xml.signature.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;
import com.hand.study.infra.mapper.PaymentHeader37799Mapper;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 单据表(PaymentHeader37799)资源库
 *
 * @author gx
 * @since 2022-07-05 12:42:33
 */
@Component
public class PaymentHeader37799RepositoryImpl extends BaseRepositoryImpl<PaymentHeader37799> implements PaymentHeader37799Repository {
    @Resource
    private PaymentHeader37799Mapper paymentHeader37799Mapper;
    @Autowired
    private PaymentHeader37799Repository paymentHeader37799Repository;
    @Resource
    private PaymentLine37799Mapper paymentLine37799Mapper;
    @Autowired
    private PaymentLine37799Repository paymentLine37799Repository;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;
    @Autowired
    private LovAdapter lovAdapter;

    @Override
    public List<PaymentHeader37799> selectList(PaymentHeader37799 paymentHeader37799) {
        return paymentHeader37799Mapper.selectList(paymentHeader37799);
    }

    @Override
    public PaymentHeader37799 selectByPrimary(Long headerId) {
        PaymentHeader37799 paymentHeader37799 = new PaymentHeader37799();
        paymentHeader37799.setHeaderId(headerId);
        List<PaymentHeader37799> paymentHeader37799s = paymentHeader37799Mapper.selectList(paymentHeader37799);
        if (paymentHeader37799s.size() == 0) {
            return null;
        }
        return paymentHeader37799s.get(0);
    }

    @Override
    public List<PaymentHeader37799Vo> selectDataByPaymentTransaction(AggregateQueryDTO aggregateQueryDTO) {
        //aggregateQueryDTO.setMoPayReqType(paymentHeader37799Mapper.selectMoPayReqTypeById(aggregateQueryDTO.getMoPayReqTypeId()));
        List<PaymentHeader37799Vo> paymentHeader37799Vos = paymentHeader37799Mapper.selectDataByPayment(aggregateQueryDTO);
        //paymentHeader37799Vos = dataMatch(paymentHeader37799Vos);
        if (aggregateQueryDTO.getAmountFrom() != null || aggregateQueryDTO.getAmountTo() != null) {
            for (PaymentHeader37799Vo vo : paymentHeader37799Vos
            ) {
                //-1,0,1
                if (vo.getAmountCount().compareTo(aggregateQueryDTO.getAmountFrom()) != 1 && vo.getAmountCount().compareTo(aggregateQueryDTO.getAmountTo()) != -1) {
                    paymentHeader37799Vos.remove(vo);
                }
            }
        }
        paymentHeader37799Vos.stream().forEach(paymentHeader37799Vo -> {
            paymentHeader37799Vo.setApplicant(null);
            paymentHeader37799Vo.setUnitAccountingEntity(paymentHeader37799Mapper.selectUnitName(paymentHeader37799Vo.getUnitId()) + "/" + paymentHeader37799Vo.getAccountingEntity());
            paymentHeader37799Vo.setPaymentStatus(lovAdapter.queryLovMeaning("HZERO.37799.PAYMENT.STATUS",0L,paymentHeader37799Vo.getPaymentStatus()));
        });

        return paymentHeader37799Vos;
    }

    @Override
    public void insertDate(EntryInformationDTO entryInformationDTO) {
        Map<String,String> employee37799 = new HashMap<>(16);
        employee37799.put("employee37799", String.valueOf(entryInformationDTO.getPaymentHeader37799().getEmployeeId()));
        //编码生成
        String code = codeRuleBuilder.generateCode("HZERO.37799.PAYMANET.NUMBER",employee37799);

        PaymentHeader37799 paymentHeader37799 = entryInformationDTO.getPaymentHeader37799();
        paymentHeader37799.setPaymentNumber(code);
        paymentHeader37799.setPaymentStatus("NEW");
        paymentHeader37799Mapper.insert(paymentHeader37799);

        //主要用于获取headerId
        PaymentHeader37799 paymentHeader37799s = paymentHeader37799Repository.selectByCondition(Condition.builder(PaymentHeader37799.class)
                .andWhere(Sqls.custom().andEqualTo(PaymentHeader37799.FIELD_PAYMENT_NUMBER, paymentHeader37799.getPaymentNumber())).build()).get(0);

        List<PaymentLine37799> paymentLine37799s = entryInformationDTO.getPaymentLine37799();
        paymentLine37799s.forEach(paymentLine37799 -> paymentLine37799.setHeaderId(paymentHeader37799s.getHeaderId()));
        paymentLine37799Repository.batchInsertSelective(paymentLine37799s);

    }

    @Override
    public EntryInformationDTO selectAllByHeaderId(Long headerId) {
        List<PaymentHeader37799> paymentHeader37799s = paymentHeader37799Repository.selectByCondition(Condition.builder(PaymentHeader37799.class).andWhere(Sqls.custom().andEqualTo(PaymentHeader37799.FIELD_HEADER_ID,headerId)).build());
        //状态翻译
        paymentHeader37799s.forEach(paymentHeader37799 -> paymentHeader37799.setPaymentStatus(lovAdapter.queryLovMeaning("HZERO.37799.PAYMENT.STATUS",0L,paymentHeader37799.getPaymentStatus())));

        PaymentHeader37799 paymentHeader37799=paymentHeader37799s.get(0);
        PaymentLine37799 paymentLine = new PaymentLine37799();
        paymentLine.setHeaderId(headerId);
        List<PaymentLine37799> paymentLine37799 = paymentLine37799Mapper.select(paymentLine);


        EntryInformationDTO entryInformationDTO = new EntryInformationDTO();
        entryInformationDTO.setPaymentHeader37799(paymentHeader37799);
        entryInformationDTO.setPaymentLine37799(paymentLine37799);

        return entryInformationDTO;
    }

    @Override
    public void updateEntryInformation(EntryInformationDTO entryInformationDTO) {
        PaymentHeader37799 paymentHeader37799 = entryInformationDTO.getPaymentHeader37799();
        PaymentHeader37799 oldPaymentHeader37799 = paymentHeader37799Mapper.select(new PaymentHeader37799(){
            @Override
            public Long getHeaderId() {
                return super.getHeaderId();
            }
        }).get(0);

        paymentHeader37799.setPaymentNumber(oldPaymentHeader37799.getPaymentNumber());

        PaymentHeader37799 newPaymentHeader37799 = paymentHeader37799Mapper.select(new PaymentHeader37799(){
            @Override
            public Long getHeaderId() {
                return super.getHeaderId();
            }
        }).get(0);

        if (oldPaymentHeader37799.getObjectVersionNumber().equals(newPaymentHeader37799.getObjectVersionNumber())){
            paymentHeader37799Mapper.insert(paymentHeader37799);
        }

        

    }

    @Override
    public PaymentHeader37799 selectByHeaderId(Long headerId) {
        //PaymentHeader37799 paymentHeader37799 = paymentHeader37799Mapper.selectByHeaderId(headerId);
        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Repository.selectByCondition(
                Condition.builder(PaymentHeader37799.class)
                        .andWhere(Sqls.custom().andEqualTo(PaymentHeader37799.FIELD_HEADER_ID, headerId)).build()).get(0);
        return paymentHeader37799;
    }

    @Override
    public List<EntryInformationDTO> selectAllInfo() {
        PaymentHeader37799 paymentHeader37799 = paymentHeader37799Mapper.selectAll().get(0);
        List<PaymentLine37799> line37799s = paymentLine37799Repository.selectByCondition(
                Condition.builder(PaymentLine37799.class).andWhere(Sqls.custom().andEqualTo(PaymentLine37799.FIELD_HEADER_ID,paymentHeader37799.getHeaderId())).build()
        );

        EntryInformationDTO entryInformationDTO = new EntryInformationDTO();
        entryInformationDTO.setPaymentHeader37799(paymentHeader37799);
        entryInformationDTO.setPaymentLine37799(line37799s);
        return Collections.singletonList(entryInformationDTO);
    }

    public List<PaymentHeader37799Vo> dataMatch(List<PaymentHeader37799Vo> list){
        for (PaymentHeader37799Vo vo:list) {
            BigDecimal amountCount = new BigDecimal(0);
            for (PaymentHeader37799Vo v:list) {
                if (vo.getPaymentNumber() == v.getPaymentNumber()){
                    amountCount.add(v.getAmount());
                }
            }
            vo.setAmountCount(amountCount);
        }
        /*
        * 按照编号进行去重
        * */
        list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(()-> new TreeSet<>(Comparator.comparing(PaymentHeader37799Vo::getPaymentNumber))),
                ArrayIterator::new));
        return list;
    }
}

