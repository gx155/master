package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.PaymentMethod;

import java.util.List;

/**
 * (PaymentMethod)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:25:05
 */
public interface PaymentMethodService {

    /**
     * 查询数据
     *
     * @param pageRequest    分页参数
     * @param paymentMethods 查询条件
     * @return 返回值
     */
    Page<PaymentMethod> selectList(PageRequest pageRequest, PaymentMethod paymentMethods);

    /**
     * 保存数据
     *
     * @param paymentMethods 数据
     */
    void saveData(List<PaymentMethod> paymentMethods);

}

