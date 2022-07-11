package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.MoInvoiceType;

import java.util.List;

/**
 * 应付发票类型(MoInvoiceType)资源库
 *
 * @author gx
 * @since 2022-07-11 12:24:33
 */
public interface MoInvoiceTypeRepository extends BaseRepository<MoInvoiceType> {
    /**
     * 查询
     *
     * @param moInvoiceType 查询条件
     * @return 返回值
     */
    List<MoInvoiceType> selectList(MoInvoiceType moInvoiceType);

    /**
     * 根据主键查询（可关联表）
     *
     * @param moInvoiceTypeId 主键
     * @return 返回值
     */
    MoInvoiceType selectByPrimary(Long moInvoiceTypeId);
}
