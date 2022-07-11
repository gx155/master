package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.AccountingEntity;

import java.util.List;

/**
 * 核算主体表(AccountingEntity)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:24:04
 */
public interface AccountingEntityMapper extends BaseMapper<AccountingEntity> {
    /**
     * 基础查询
     *
     * @param accountingEntity 查询条件
     * @return 返回值
     */
    List<AccountingEntity> selectList(AccountingEntity accountingEntity);
}

