package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.InvoiceLine37799;

import java.util.List;

/**
 * 单据行表(InvoiceLine37799)资源库
 *
 * @author gx
 * @since 2022-07-11 10:45:00
 */
public interface InvoiceLine37799Repository extends BaseRepository<InvoiceLine37799> {
    /**
     * 查询
     *
     * @param invoiceLine37799 查询条件
     * @return 返回值
     */
    List<InvoiceLine37799> selectList(InvoiceLine37799 invoiceLine37799);

    /**
     * 根据主键查询（可关联表）
     *
     * @param lineId 主键
     * @return 返回值
     */
    InvoiceLine37799 selectByPrimary(Long lineId);

    /**
     * 发票单行删除API
     * @param lineId
     */
    void deleteByLineId(Long lineId);
}
