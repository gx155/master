package com.hand.study.domain.repository;

import com.hand.study.api.dto.AggregateQueryDTO;
import com.hand.study.api.dto.EntryInformationDTO;
import com.hand.study.domain.entity.PaymentHeader37799Vo;
import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.PaymentHeader37799;

import java.util.List;

/**
 * 单据表(PaymentHeader37799)资源库
 *
 * @author gx
 * @since 2022-07-05 12:42:33
 */
public interface PaymentHeader37799Repository extends BaseRepository<PaymentHeader37799> {
    /**
     * 查询
     *
     * @param paymentHeader37799 查询条件
     * @return 返回值
     */
    List<PaymentHeader37799> selectList(PaymentHeader37799 paymentHeader37799);

    /**
     * 根据主键查询（可关联表）
     *
     * @param headerId 主键
     * @return 返回值
     */
    PaymentHeader37799 selectByPrimary(Long headerId);

    List<PaymentHeader37799Vo> selectDataByPaymentTransaction(AggregateQueryDTO aggregateQueryDTO);

    void insertDate(EntryInformationDTO entryInformationDTO);

    EntryInformationDTO selectByPaymentNumber(Long paymentNumber);

    void updateEntryInformation(EntryInformationDTO entryInformationDTO);

}
