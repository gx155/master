package com.hand.study.domain.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 调拨单行表(TransferLine)实体类
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:34
 */

@ApiModel("调拨单行表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hfm_transfer_line")
public class TransferLine extends AuditDomain {
    private static final long serialVersionUID = -49812304415938074L;

    public static final String FIELD_TRANSFER_LINE_ID = "transferLineId";
    public static final String FIELD_TRANSFER_HEADER_ID = "transferHeaderId";
    public static final String FIELD_LINE_NUMBER = "lineNumber";
    public static final String FIELD_TRANSFER_ACC_ENTITY_ID = "transferAccEntityId";
    public static final String FIELD_TRANSFER_BANK_ACCOUNT_NUM = "transferBankAccountNum";
    public static final String FIELD_TRANSFER_BANK_ACCOUNT_NAME = "transferBankAccountName";
    public static final String FIELD_TRANSFER_BANK_ACCOUNT_CODE = "transferBankAccountCode";
    public static final String FIELD_TRANSFER_MONEY = "transferMoney";
    public static final String FIELD_ACTUAL_TRANSFER_MONEY = "actualTransferMoney";
    public static final String FIELD_TRANSFER_CASH_PLAN_ITEM_ID = "transferCashPlanItemId";
    public static final String FIELD_TRANSFER_CASH_FLOW_TERM_ID = "transferCashFlowTermId";
    public static final String FIELD_RETREAT_ACC_ENTITY_ID = "retreatAccEntityId";
    public static final String FIELD_RETREAT_BANK_ACCOUNT_CODE = "retreatBankAccountCode";
    public static final String FIELD_RETREAT_MONEY = "retreatMoney";
    public static final String FIELD_ACTUAL_RETREAT_MONEY = "actualRetreatMoney";
    public static final String FIELD_RETREAT_CASH_PLAN_ITEM_ID = "retreatCashPlanItemId";
    public static final String FIELD_RETREAT_CASH_FLOW_TERM_ID = "retreatCashFlowTermId";
    public static final String FIELD_PAYMENT_METHOD_ID = "paymentMethodId";
    public static final String FIELD_PAYMENT_DATE = "paymentDate";
    public static final String FIELD_PAYMENT_STATUS = "paymentStatus";
    public static final String FIELD_PLAN_TRANSFER_DATE = "planTransferDate";
    public static final String FIELD_CLOSE_STATUS = "closeStatus";
    public static final String FIELD_DESCRIPTION = "description";

    @ApiModelProperty("调拨单行ID")
    @Id
    @GeneratedValue
    private Long transferLineId;

    @ApiModelProperty(value = "调拨单头ID", required = true)
    @NotNull
    private Long transferHeaderId;

    @ApiModelProperty(value = "行号", required = true)
    @NotNull
    private Integer lineNumber;

    @ApiModelProperty(value = "转出方核算主体ID", required = true)
    @NotNull
    private Long transferAccEntityId;

    @ApiModelProperty(value = "转出方账号", required = true)
    @NotBlank
    private String transferBankAccountNum;

    @ApiModelProperty(value = "转出方银行户名")
    private String transferBankAccountName;

    @ApiModelProperty(value = "转出方银行代码")
    private String transferBankAccountCode;

    @ApiModelProperty(value = "转出方金额", required = true)
    @NotNull
    private BigDecimal transferMoney;

    @ApiModelProperty(value = "实际转出方金额")
    private BigDecimal actualTransferMoney;

    @ApiModelProperty(value = "转出方资金计划项ID", required = true)
    @NotNull
    private Long transferCashPlanItemId;

    @ApiModelProperty(value = "转出方现金流量项ID", required = true)
    @NotNull
    private Long transferCashFlowTermId;

    @ApiModelProperty(value = "转入方核算主体ID", required = true)
    @NotNull
    private Long retreatAccEntityId;

    @ApiModelProperty(value = "转入方银行代码")
    private String retreatBankAccountCode;

    @ApiModelProperty(value = "转入方金额", required = true)
    @NotNull
    private BigDecimal retreatMoney;

    @ApiModelProperty(value = "实际转入方金额")
    private BigDecimal actualRetreatMoney;

    @ApiModelProperty(value = "转入方资金计划项ID", required = true)
    @NotNull
    private Long retreatCashPlanItemId;

    @ApiModelProperty(value = "转入方现金流量项ID", required = true)
    @NotNull
    private Long retreatCashFlowTermId;

    @ApiModelProperty(value = "付款方式ID", required = true)
    @NotNull
    private Long paymentMethodId;

    @ApiModelProperty(value = "实际调拨日期（支付日期）")
    private Date paymentDate;

    @ApiModelProperty(value = "调拨状态（支付状态）", required = true)
    @NotBlank
    private String paymentStatus;

    @ApiModelProperty(value = "计划调拨日期", required = true)
    @NotNull
    private Date planTransferDate;

    @ApiModelProperty(value = "关闭状态", required = true)
    @NotBlank
    private String closeStatus;

    @ApiModelProperty(value = "描述")
    private String description;


    public Long getTransferLineId() {
        return transferLineId;
    }

    public void setTransferLineId(Long transferLineId) {
        this.transferLineId = transferLineId;
    }

    public Long getTransferHeaderId() {
        return transferHeaderId;
    }

    public void setTransferHeaderId(Long transferHeaderId) {
        this.transferHeaderId = transferHeaderId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getTransferAccEntityId() {
        return transferAccEntityId;
    }

    public void setTransferAccEntityId(Long transferAccEntityId) {
        this.transferAccEntityId = transferAccEntityId;
    }

    public String getTransferBankAccountNum() {
        return transferBankAccountNum;
    }

    public void setTransferBankAccountNum(String transferBankAccountNum) {
        this.transferBankAccountNum = transferBankAccountNum;
    }

    public String getTransferBankAccountName() {
        return transferBankAccountName;
    }

    public void setTransferBankAccountName(String transferBankAccountName) {
        this.transferBankAccountName = transferBankAccountName;
    }

    public String getTransferBankAccountCode() {
        return transferBankAccountCode;
    }

    public void setTransferBankAccountCode(String transferBankAccountCode) {
        this.transferBankAccountCode = transferBankAccountCode;
    }

    public BigDecimal getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(BigDecimal transferMoney) {
        this.transferMoney = transferMoney;
    }

    public BigDecimal getActualTransferMoney() {
        return actualTransferMoney;
    }

    public void setActualTransferMoney(BigDecimal actualTransferMoney) {
        this.actualTransferMoney = actualTransferMoney;
    }

    public Long getTransferCashPlanItemId() {
        return transferCashPlanItemId;
    }

    public void setTransferCashPlanItemId(Long transferCashPlanItemId) {
        this.transferCashPlanItemId = transferCashPlanItemId;
    }

    public Long getTransferCashFlowTermId() {
        return transferCashFlowTermId;
    }

    public void setTransferCashFlowTermId(Long transferCashFlowTermId) {
        this.transferCashFlowTermId = transferCashFlowTermId;
    }

    public Long getRetreatAccEntityId() {
        return retreatAccEntityId;
    }

    public void setRetreatAccEntityId(Long retreatAccEntityId) {
        this.retreatAccEntityId = retreatAccEntityId;
    }

    public String getRetreatBankAccountCode() {
        return retreatBankAccountCode;
    }

    public void setRetreatBankAccountCode(String retreatBankAccountCode) {
        this.retreatBankAccountCode = retreatBankAccountCode;
    }

    public BigDecimal getRetreatMoney() {
        return retreatMoney;
    }

    public void setRetreatMoney(BigDecimal retreatMoney) {
        this.retreatMoney = retreatMoney;
    }

    public BigDecimal getActualRetreatMoney() {
        return actualRetreatMoney;
    }

    public void setActualRetreatMoney(BigDecimal actualRetreatMoney) {
        this.actualRetreatMoney = actualRetreatMoney;
    }

    public Long getRetreatCashPlanItemId() {
        return retreatCashPlanItemId;
    }

    public void setRetreatCashPlanItemId(Long retreatCashPlanItemId) {
        this.retreatCashPlanItemId = retreatCashPlanItemId;
    }

    public Long getRetreatCashFlowTermId() {
        return retreatCashFlowTermId;
    }

    public void setRetreatCashFlowTermId(Long retreatCashFlowTermId) {
        this.retreatCashFlowTermId = retreatCashFlowTermId;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPlanTransferDate() {
        return planTransferDate;
    }

    public void setPlanTransferDate(Date planTransferDate) {
        this.planTransferDate = planTransferDate;
    }

    public String getCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(String closeStatus) {
        this.closeStatus = closeStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

