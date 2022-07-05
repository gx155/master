package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.PaymentHeader37799Service;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.PaymentHeader37799;
import com.hand.study.domain.repository.PaymentHeader37799Repository;

import java.util.List;
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

    @Override
    public Page<PaymentHeader37799> selectList(PageRequest pageRequest, PaymentHeader37799 paymentHeader37799) {
        return PageHelper.doPageAndSort(pageRequest, () -> paymentHeader37799Repository.selectList(paymentHeader37799));
    }

    @Override
    public void saveData(List<PaymentHeader37799> paymentHeader37799s) {
        List<PaymentHeader37799> insertList = paymentHeader37799s.stream().filter(line -> line.getHeaderId() == null).collect(Collectors.toList());
        List<PaymentHeader37799> updateList = paymentHeader37799s.stream().filter(line -> line.getHeaderId() != null).collect(Collectors.toList());
        paymentHeader37799Repository.batchInsertSelective(insertList);
        paymentHeader37799Repository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

