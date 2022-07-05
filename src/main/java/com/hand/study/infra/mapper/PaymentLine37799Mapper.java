package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.PaymentLine37799;

import java.util.List;

/**
 * 单据行表(PaymentLine37799)应用服务
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */
public interface PaymentLine37799Mapper extends BaseMapper<PaymentLine37799> {
    /**
     * 基础查询
     *
     * @param paymentLine37799 查询条件
     * @return 返回值
     */
    List<PaymentLine37799> selectList(PaymentLine37799 paymentLine37799);
}

