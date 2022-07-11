package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.PaymentMethodService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.PaymentMethod;
import com.hand.study.domain.repository.PaymentMethodRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (PaymentMethod)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:25:05
 */
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public Page<PaymentMethod> selectList(PageRequest pageRequest, PaymentMethod paymentMethod) {
        return PageHelper.doPageAndSort(pageRequest, () -> paymentMethodRepository.selectList(paymentMethod));
    }

    @Override
    public void saveData(List<PaymentMethod> paymentMethods) {
        List<PaymentMethod> insertList = paymentMethods.stream().filter(line -> line.getPaymentMethodId() == null).collect(Collectors.toList());
        List<PaymentMethod> updateList = paymentMethods.stream().filter(line -> line.getPaymentMethodId() != null).collect(Collectors.toList());
        paymentMethodRepository.batchInsertSelective(insertList);
        paymentMethodRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

