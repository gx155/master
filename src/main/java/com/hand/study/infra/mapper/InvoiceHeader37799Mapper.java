package com.hand.study.infra.mapper;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.domain.entity.InvoiceHeaderLineVo;
import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.InvoiceHeader37799;

import java.util.List;

/**
 * 单据表(InvoiceHeader37799)应用服务
 *
 * @author gx
 * @since 2022-07-11 10:44:24
 */
public interface InvoiceHeader37799Mapper extends BaseMapper<InvoiceHeader37799> {
    /**
     * 基础查询
     *
     * @param invoiceHeader37799 查询条件
     * @return 返回值
     */
    List<InvoiceHeader37799> selectList(InvoiceHeader37799 invoiceHeader37799);

    /**
     * 订单汇总查询API
     * @param aggregateQueryDTO
     * @return
     */
    List<InvoiceHeader37799> selectAllList(AggregateQueryDTO aggregateQueryDTO);

    /**
     * 头行打平导出
     * @return
     */
    List<InvoiceHeaderLineVo> selectAllDate();
}

