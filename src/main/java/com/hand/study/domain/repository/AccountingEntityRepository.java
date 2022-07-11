package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.AccountingEntity;

import java.util.List;

/**
 * 核算主体表(AccountingEntity)资源库
 *
 * @author gx
 * @since 2022-07-11 12:24:04
 */
public interface AccountingEntityRepository extends BaseRepository<AccountingEntity> {
    /**
     * 查询
     *
     * @param accountingEntity 查询条件
     * @return 返回值
     */
    List<AccountingEntity> selectList(AccountingEntity accountingEntity);

    /**
     * 根据主键查询（可关联表）
     *
     * @param accEntityId 主键
     * @return 返回值
     */
    AccountingEntity selectByPrimary(Long accEntityId);
}
