package com.hand.study.app.service;

import com.hand.study.api.dto.ExportSheet;
import com.hand.study.api.dto.HeaderIdStatusDTO;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.PaymentHeader37799;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 单据表(PaymentHeader37799)应用服务
 *
 * @author gx
 * @since 2022-07-05 12:42:33
 */
public interface PaymentHeader37799Service {

    /**
     * 查询数据
     *
     * @param pageRequest         分页参数
     * @param paymentHeader37799s 查询条件
     * @return 返回值
     */
    Page<PaymentHeader37799> selectList(PageRequest pageRequest, PaymentHeader37799 paymentHeader37799s);

    /**
     * 保存数据
     *
     * @param paymentHeader37799 数据
     */
    void saveData(PaymentHeader37799 paymentHeader37799);

    void statusUpdateByHeaderId(HeaderIdStatusDTO headerIdStatusDTO);

    void deleteSlipByHeaderId(@Param("headerId") Long headerId);

    List<ExportSheet> selectRTFData();
}

