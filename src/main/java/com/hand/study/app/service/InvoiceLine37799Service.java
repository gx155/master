package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.InvoiceLine37799;

import java.util.List;

/**
 * 单据行表(InvoiceLine37799)应用服务
 *
 * @author gx
 * @since 2022-07-11 10:45:01
 */
public interface InvoiceLine37799Service {

    /**
     * 查询数据
     *
     * @param pageRequest       分页参数
     * @param lineId 查询条件
     * @return 返回值
     */
    Page<InvoiceLine37799> selectList(PageRequest pageRequest, Long lineId);

    /**
     * 保存数据
     *
     * @param invoiceLine37799s 数据
     */
    void saveData(List<InvoiceLine37799> invoiceLine37799s);

}

