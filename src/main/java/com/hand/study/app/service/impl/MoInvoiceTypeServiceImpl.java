package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.MoInvoiceTypeService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.MoInvoiceType;
import com.hand.study.domain.repository.MoInvoiceTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 应付发票类型(MoInvoiceType)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:24:34
 */
@Service
public class MoInvoiceTypeServiceImpl implements MoInvoiceTypeService {
    @Autowired
    private MoInvoiceTypeRepository moInvoiceTypeRepository;

    @Override
    public Page<MoInvoiceType> selectList(PageRequest pageRequest, MoInvoiceType moInvoiceType) {
        return PageHelper.doPageAndSort(pageRequest, () -> moInvoiceTypeRepository.selectList(moInvoiceType));
    }

    @Override
    public void saveData(List<MoInvoiceType> moInvoiceTypes) {
        List<MoInvoiceType> insertList = moInvoiceTypes.stream().filter(line -> line.getMoInvoiceTypeId() == null).collect(Collectors.toList());
        List<MoInvoiceType> updateList = moInvoiceTypes.stream().filter(line -> line.getMoInvoiceTypeId() != null).collect(Collectors.toList());
        moInvoiceTypeRepository.batchInsertSelective(insertList);
        moInvoiceTypeRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

