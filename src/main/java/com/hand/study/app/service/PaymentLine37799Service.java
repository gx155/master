package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.PaymentLine37799;

import java.util.List;

/**
 * 单据行表(PaymentLine37799)应用服务
 *
 * @author gx
 * @since 2022-07-05 12:44:02
 */
public interface PaymentLine37799Service {

    /**
     * 查询数据
     *
     * @param pageRequest       分页参数
     * @param paymentLine37799s 查询条件
     * @return 返回值
     */
    Page<PaymentLine37799> selectList(PageRequest pageRequest, PaymentLine37799 paymentLine37799s);

    /**
     * 保存数据
     *
     * @param paymentLine37799s 数据
     */
    void saveData(List<PaymentLine37799> paymentLine37799s);

}

