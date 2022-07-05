package com.hand.study.infra.mapper;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.domain.entity.PaymentHeader37799Vo;
import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.PaymentHeader37799;

import java.util.List;

/**
 * 单据表(PaymentHeader37799)应用服务
 *
 * @author gx
 * @since 2022-07-05 12:42:33
 */
public interface PaymentHeader37799Mapper extends BaseMapper<PaymentHeader37799> {
    /**
     * 基础查询
     *
     * @param paymentHeader37799 查询条件
     * @return 返回值
     */
    List<PaymentHeader37799> selectList(PaymentHeader37799 paymentHeader37799);

    List<PaymentHeader37799Vo> selectDataByPaymentTransaction(AggregateQueryDTO aggregateQueryDTO);

    String selectUnitName(Long unitId);

    String selectMoPayReqTypeById(Long moPayReqTypeId);
}

