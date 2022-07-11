package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.PaymentMethod;

import java.util.List;

/**
 * (PaymentMethod)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:25:05
 */
public interface PaymentMethodMapper extends BaseMapper<PaymentMethod> {
    /**
     * 基础查询
     *
     * @param paymentMethod 查询条件
     * @return 返回值
     */
    List<PaymentMethod> selectList(PaymentMethod paymentMethod);
}

