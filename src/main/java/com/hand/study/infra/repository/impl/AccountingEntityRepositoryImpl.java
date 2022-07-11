package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.AccountingEntity;
import com.hand.study.domain.repository.AccountingEntityRepository;
import com.hand.study.infra.mapper.AccountingEntityMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 核算主体表(AccountingEntity)资源库
 *
 * @author gx
 * @since 2022-07-11 12:24:04
 */
@Component
public class AccountingEntityRepositoryImpl extends BaseRepositoryImpl<AccountingEntity> implements AccountingEntityRepository {
    @Resource
    private AccountingEntityMapper accountingEntityMapper;

    @Override
    public List<AccountingEntity> selectList(AccountingEntity accountingEntity) {
        return accountingEntityMapper.selectList(accountingEntity);
    }

    @Override
    public AccountingEntity selectByPrimary(Long accEntityId) {
        AccountingEntity accountingEntity = new AccountingEntity();
        accountingEntity.setAccEntityId(accEntityId);
        List<AccountingEntity> accountingEntitys = accountingEntityMapper.selectList(accountingEntity);
        if (accountingEntitys.size() == 0) {
            return null;
        }
        return accountingEntitys.get(0);
    }

}

