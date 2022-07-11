package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.InvoiceLine37799Service;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.InvoiceLine37799;
import com.hand.study.domain.repository.InvoiceLine37799Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 单据行表(InvoiceLine37799)应用服务
 *
 * @author gx
 * @since 2022-07-11 10:45:01
 */
@Service
public class InvoiceLine37799ServiceImpl implements InvoiceLine37799Service {
    @Autowired
    private InvoiceLine37799Repository invoiceLine37799Repository;

    @Override
    public Page<InvoiceLine37799> selectList(PageRequest pageRequest, Long lineId) {
        InvoiceLine37799 invoiceLine37799 = new InvoiceLine37799();
        invoiceLine37799.setLineId(lineId);
        return PageHelper.doPageAndSort(pageRequest, () -> invoiceLine37799Repository.selectList(invoiceLine37799));
    }

    @Override
    public void saveData(List<InvoiceLine37799> invoiceLine37799s) {
        List<InvoiceLine37799> insertList = invoiceLine37799s.stream().filter(line -> line.getLineId() == null).collect(Collectors.toList());
        List<InvoiceLine37799> updateList = invoiceLine37799s.stream().filter(line -> line.getLineId() != null).collect(Collectors.toList());
        invoiceLine37799Repository.batchInsertSelective(insertList);
        invoiceLine37799Repository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

