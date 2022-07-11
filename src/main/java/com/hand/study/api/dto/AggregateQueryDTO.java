package com.hand.study.api.dto;

import com.google.gson.annotations.Since;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 订单汇总查询API
 * @date: 2022/7/5 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AggregateQueryDTO {
    //"附言"
    private String description;

    //金额
    private BigDecimal amountFrom;
    private BigDecimal amountTo;

    //"编号"
    private String requisitionNumber;

    //"单据类型id"
    private Long moPayReqTypeId;

    //单据类型
    private String moPayReqType;

    //"申请人"
    private String employeeId;

    //"币种"
    private String currencyCode;

    //创建日期
    private Date createdDateFrom;
    private Date createdDateTo;




}
