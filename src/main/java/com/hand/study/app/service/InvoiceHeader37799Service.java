package com.hand.study.app.service;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.InvoiceHeader37799;

import java.util.List;

/**
 * 单据表(InvoiceHeader37799)应用服务
 *
 * @author gx
 * @since 2022-07-11 10:44:25
 */
public interface InvoiceHeader37799Service {

    /**
     * 查询数据
     *
     * @param pageRequest         分页参数
     * @param invoiceHeader37799s 查询条件
     * @return 返回值
     */
    Page<InvoiceHeader37799> selectList(PageRequest pageRequest, InvoiceHeader37799 invoiceHeader37799s);

    /**
     * 发票单保存/更新 API
     *
     * @param invoiceHeader37799 数据
     */
    void saveData(InvoiceHeader37799 invoiceHeader37799);

    /**
     * 订单汇总查询API
     * @param pageRequest
     * @param aggregateQueryDTO
     * @return
     */
    Page<InvoiceHeader37799> selectInfoList(PageRequest pageRequest, AggregateQueryDTO aggregateQueryDTO);

    /**
     * 发票单状态API
     * @param headerIdStatusDTO
     */
    void statusUpdateByHeaderId(HeaderIdStatusDTO headerIdStatusDTO);
}

