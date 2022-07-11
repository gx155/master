package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.AccountingEntityService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.AccountingEntity;
import com.hand.study.domain.repository.AccountingEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 核算主体表(AccountingEntity)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:24:04
 */
@Service
public class AccountingEntityServiceImpl implements AccountingEntityService {
    @Autowired
    private AccountingEntityRepository accountingEntityRepository;

    @Override
    public Page<AccountingEntity> selectList(PageRequest pageRequest, AccountingEntity accountingEntity) {
        return PageHelper.doPageAndSort(pageRequest, () -> accountingEntityRepository.selectList(accountingEntity));
    }

    @Override
    public void saveData(List<AccountingEntity> accountingEntitys) {
        List<AccountingEntity> insertList = accountingEntitys.stream().filter(line -> line.getAccEntityId() == null).collect(Collectors.toList());
        List<AccountingEntity> updateList = accountingEntitys.stream().filter(line -> line.getAccEntityId() != null).collect(Collectors.toList());
        accountingEntityRepository.batchInsertSelective(insertList);
        accountingEntityRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

