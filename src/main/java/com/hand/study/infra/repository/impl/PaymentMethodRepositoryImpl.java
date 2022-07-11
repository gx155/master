package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.PaymentMethod;
import com.hand.study.domain.repository.PaymentMethodRepository;
import com.hand.study.infra.mapper.PaymentMethodMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PaymentMethod)资源库
 *
 * @author gx
 * @since 2022-07-11 12:25:05
 */
@Component
public class PaymentMethodRepositoryImpl extends BaseRepositoryImpl<PaymentMethod> implements PaymentMethodRepository {
    @Resource
    private PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethod> selectList(PaymentMethod paymentMethod) {
        return paymentMethodMapper.selectList(paymentMethod);
    }

    @Override
    public PaymentMethod selectByPrimary(Long paymentMethodId) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentMethodId(paymentMethodId);
        List<PaymentMethod> paymentMethods = paymentMethodMapper.selectList(paymentMethod);
        if (paymentMethods.size() == 0) {
            return null;
        }
        return paymentMethods.get(0);
    }

}

