package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.MoInvoiceType;

import java.util.List;

/**
 * 应付发票类型(MoInvoiceType)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:24:34
 */
public interface MoInvoiceTypeService {

    /**
     * 查询数据
     *
     * @param pageRequest    分页参数
     * @param moInvoiceTypes 查询条件
     * @return 返回值
     */
    Page<MoInvoiceType> selectList(PageRequest pageRequest, MoInvoiceType moInvoiceTypes);

    /**
     * 保存数据
     *
     * @param moInvoiceTypes 数据
     */
    void saveData(List<MoInvoiceType> moInvoiceTypes);

}

