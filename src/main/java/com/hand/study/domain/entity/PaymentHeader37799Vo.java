package com.hand.study.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: XIN.GONG@HAND-CHINA.COM
 * @description 返回数据
 * @date: 2022/7/5 13:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHeader37799Vo {
    @ApiModelProperty(value = "付款单号", required = true)
    private String paymentNumber;

    @ApiModelProperty(value = "付款申请单类型")
    private String paymentType;

    @ApiModelProperty(value = "申请人")
    private String applicant;

    @ApiModelProperty(value = "部门")
    private Long unitId;

    @ApiModelProperty(value = "核算主体")
    private String accountingEntity;

    @ApiModelProperty(value = "部门/核算主体")
    private String unitAccountingEntity;

    @ApiModelProperty(value = "申请日期")
    private Date dateOfApplication;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "行金额汇总")
    private BigDecimal amountCount;

    @ApiModelProperty(value = "单据状态")
    private String paymentStatus;
}
