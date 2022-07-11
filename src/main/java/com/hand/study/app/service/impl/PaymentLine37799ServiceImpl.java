package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.PaymentLine37799Service;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.PaymentLine37799;
import com.hand.study.domain.repository.PaymentLine37799Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 单据行表(PaymentLine37799)应用服务
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */
@Service
public class PaymentLine37799ServiceImpl implements PaymentLine37799Service {
    @Autowired
    private PaymentLine37799Repository paymentLine37799Repository;

    @Override
    public Page<PaymentLine37799> selectList(PageRequest pageRequest, Long headerId) {
        PaymentLine37799 paymentLine37799 = new PaymentLine37799();
        paymentLine37799.setHeaderId(headerId);
        return PageHelper.doPageAndSort(pageRequest, () -> paymentLine37799Repository.selectList(paymentLine37799));
    }

    @Override
    public void saveData(List<PaymentLine37799> paymentLine37799s) {
        List<PaymentLine37799> insertList = paymentLine37799s.stream().filter(line -> line.getLineId() == null).collect(Collectors.toList());
        List<PaymentLine37799> updateList = paymentLine37799s.stream().filter(line -> line.getLineId() != null).collect(Collectors.toList());
        paymentLine37799Repository.batchInsertSelective(insertList);
        paymentLine37799Repository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

