package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.InvoiceLine37799;

import java.util.List;

/**
 * 单据行表(InvoiceLine37799)应用服务
 *
 * @author gx
 * @since 2022-07-11 10:45:00
 */
public interface InvoiceLine37799Mapper extends BaseMapper<InvoiceLine37799> {
    /**
     * 基础查询
     *
     * @param invoiceLine37799 查询条件
     * @return 返回值
     */
    List<InvoiceLine37799> selectList(InvoiceLine37799 invoiceLine37799);
}

