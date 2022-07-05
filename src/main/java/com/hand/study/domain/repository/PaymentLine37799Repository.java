package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.PaymentLine37799;

import java.util.List;

/**
 * 单据行表(PaymentLine37799)资源库
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */
public interface PaymentLine37799Repository extends BaseRepository<PaymentLine37799> {
    /**
     * 查询
     *
     * @param paymentLine37799 查询条件
     * @return 返回值
     */
    List<PaymentLine37799> selectList(PaymentLine37799 paymentLine37799);

    /**
     * 根据主键查询（可关联表）
     *
     * @param lineId 主键
     * @return 返回值
     */
    PaymentLine37799 selectByPrimary(Long lineId);
}
