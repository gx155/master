package com.hand.study.domain.repository;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import com.hand.study.domain.entity.InvoiceHeaderLineVo;
import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.InvoiceHeader37799;

import java.util.List;

/**
 * 单据表(InvoiceHeader37799)资源库
 *
 * @author gx
 * @since 2022-07-11 10:44:25
 */
public interface InvoiceHeader37799Repository extends BaseRepository<InvoiceHeader37799>{
    /**
     * 查询
     * @param invoiceHeader37799 查询条件
     * @return 返回值
     */
    List<InvoiceHeader37799>selectList(InvoiceHeader37799 invoiceHeader37799);

    /**
     * 根据主键查询（可关联表）
     * @param headerId 主键
     * @return 返回值
     */
    InvoiceHeader37799 selectByPrimary(Long headerId);

    /**
     * 订单汇总查询API
     * @param aggregateQueryDTO
     * @return
     */
    List<InvoiceHeader37799> selectInfoList(AggregateQueryDTO aggregateQueryDTO);

    /**
     * 发票单删除API
     * @param headerId
     */
    void deleteDataByHeaderId(Long headerId);

    /**
     * 导出数据头行打平
     * @return
     */
    List<InvoiceHeaderLineVo> selectAllDate();
}
