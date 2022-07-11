package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.MoInvoiceType;

import java.util.List;

/**
 * 应付发票类型(MoInvoiceType)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:24:33
 */
public interface MoInvoiceTypeMapper extends BaseMapper<MoInvoiceType> {
    /**
     * 基础查询
     *
     * @param moInvoiceType 查询条件
     * @return 返回值
     */
    List<MoInvoiceType> selectList(MoInvoiceType moInvoiceType);
}

