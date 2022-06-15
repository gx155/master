package com.hand.study.domain.entity;

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
 * 调拨头信息表(TransferHeader)实体类
 *
 * @author jiayue.huang@hand-china.com
 * @since 2022-06-15 16:36:33
 */

@ApiModel("调拨头信息表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hfm_transfer_header")
public class TransferHeader extends AuditDomain {
    private static final long serialVersionUID = 841610844334640834L;

    public static final String FIELD_TRANSFER_HEADER_ID = "transferHeaderId";
    public static final String FIELD_TRANSFER_NUMBER = "transferNumber";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_UNIT_ID = "unitId";
    public static final String FIELD_POSITION_ID = "positionId";
    public static final String FIELD_EMPLOYEE_ID = "employeeId";
    public static final String FIELD_ACC_ENTITY_ID = "accEntityId";
    public static final String FIELD_TRANSFER_APPLY_DATE = "transferApplyDate";
    public static final String FIELD_BANK_TREASURER_REQ_TYPE_ID = "bankTreasurerReqTypeId";
    public static final String FIELD_TRANSFER_CURRENCY_CODE = "transferCurrencyCode";
    public static final String FIELD_PAYMENT_METHOD_ID = "paymentMethodId";
    public static final String FIELD_TRANSFER_STATUS = "transferStatus";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_TRANSFER_CLOSE_DATE = "transferCloseDate";

    @ApiModelProperty("调拨单头ID")
    @Id
    @GeneratedValue
    private Long transferHeaderId;

    @ApiModelProperty(value = "单据编号", required = true)
    @NotBlank
    private String transferNumber;

    @ApiModelProperty(value = "管理公司ID", required = true)
    @NotNull
    private Long companyId;

    @ApiModelProperty(value = "部门ID", required = true)
    @NotNull
    private Long unitId;

    @ApiModelProperty(value = "岗位ID", required = true)
    @NotNull
    private Long positionId;

    @ApiModelProperty(value = "员工ID", required = true)
    @NotNull
    private Long employeeId;

    @ApiModelProperty(value = "核算主体ID", required = true)
    @NotNull
    private Long accEntityId;

    @ApiModelProperty(value = "申请日期", required = true)
    @NotNull
    private Date transferApplyDate;

    @ApiModelProperty(value = "单据类型ID", required = true)
    @NotNull
    private Long bankTreasurerReqTypeId;

    @ApiModelProperty(value = "付款币种", required = true)
    @NotBlank
    private String transferCurrencyCode;

    @ApiModelProperty(value = "付款方式ID")
    private Long paymentMethodId;

    @ApiModelProperty(value = "单据状态", required = true)
    @NotBlank
    private String transferStatus;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "关闭日期")
    private Date transferCloseDate;


    public Long getTransferHeaderId() {
        return transferHeaderId;
    }

    public void setTransferHeaderId(Long transferHeaderId) {
        this.transferHeaderId = transferHeaderId;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getAccEntityId() {
        return accEntityId;
    }

    public void setAccEntityId(Long accEntityId) {
        this.accEntityId = accEntityId;
    }

    public Date getTransferApplyDate() {
        return transferApplyDate;
    }

    public void setTransferApplyDate(Date transferApplyDate) {
        this.transferApplyDate = transferApplyDate;
    }

    public Long getBankTreasurerReqTypeId() {
        return bankTreasurerReqTypeId;
    }

    public void setBankTreasurerReqTypeId(Long bankTreasurerReqTypeId) {
        this.bankTreasurerReqTypeId = bankTreasurerReqTypeId;
    }

    public String getTransferCurrencyCode() {
        return transferCurrencyCode;
    }

    public void setTransferCurrencyCode(String transferCurrencyCode) {
        this.transferCurrencyCode = transferCurrencyCode;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTransferCloseDate() {
        return transferCloseDate;
    }

    public void setTransferCloseDate(Date transferCloseDate) {
        this.transferCloseDate = transferCloseDate;
    }

}

