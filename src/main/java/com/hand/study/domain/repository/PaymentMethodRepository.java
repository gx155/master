package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.PaymentMethod;

import java.util.List;

/**
 * (PaymentMethod)资源库
 *
 * @author gx
 * @since 2022-07-11 12:25:05
 */
public interface PaymentMethodRepository extends BaseRepository<PaymentMethod> {
    /**
     * 查询
     *
     * @param paymentMethod 查询条件
     * @return 返回值
     */
    List<PaymentMethod> selectList(PaymentMethod paymentMethod);

    /**
     * 根据主键查询（可关联表）
     *
     * @param paymentMethodId 主键
     * @return 返回值
     */
    PaymentMethod selectByPrimary(Long paymentMethodId);
}
