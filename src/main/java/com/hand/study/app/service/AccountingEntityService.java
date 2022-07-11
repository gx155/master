package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.AccountingEntity;

import java.util.List;

/**
 * 核算主体表(AccountingEntity)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:24:04
 */
public interface AccountingEntityService {

    /**
     * 查询数据
     *
     * @param pageRequest       分页参数
     * @param accountingEntitys 查询条件
     * @return 返回值
     */
    Page<AccountingEntity> selectList(PageRequest pageRequest, AccountingEntity accountingEntitys);

    /**
     * 保存数据
     *
     * @param accountingEntitys 数据
     */
    void saveData(List<AccountingEntity> accountingEntitys);

}

