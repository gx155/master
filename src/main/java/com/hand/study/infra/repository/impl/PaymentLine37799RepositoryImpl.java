package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentLine37799Repository;
import com.hand.study.infra.mapper.PaymentLine37799Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单据行表(PaymentLine37799)资源库
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */
@Component
public class PaymentLine37799RepositoryImpl extends BaseRepositoryImpl<PaymentLine37799> implements PaymentLine37799Repository {
    @Resource
    private PaymentLine37799Mapper paymentLine37799Mapper;

    @Override
    public List<PaymentLine37799> selectList(PaymentLine37799 paymentLine37799) {
        return paymentLine37799Mapper.selectList(paymentLine37799);
    }

    @Override
    public PaymentLine37799 selectByPrimary(Long lineId) {
        PaymentLine37799 paymentLine37799 = new PaymentLine37799();
        paymentLine37799.setLineId(lineId);
        List<PaymentLine37799> paymentLine37799s = paymentLine37799Mapper.selectList(paymentLine37799);
        if (paymentLine37799s.size() == 0) {
            return null;
        }
        return paymentLine37799s.get(0);
    }

}

