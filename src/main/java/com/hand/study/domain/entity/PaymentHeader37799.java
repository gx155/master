package com.hand.study.domain.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.MultiLanguage;
import io.choerodon.mybatis.annotation.MultiLanguageField;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Transient;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 单据表(PaymentHeader37799)实体类
 *
 * @author gx
 * @since 2022-07-05 12:42:32
 */

@ApiModel("单据表")
@VersionAudit
@ModifyAudit
@MultiLanguage
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hfm_payment_header_37799")
public class PaymentHeader37799 extends AuditDomain {
    private static final long serialVersionUID = 532700646039302644L;

    public static final String FIELD_HEADER_ID = "headerId";
    public static final String FIELD_PAYMENT_NUMBER = "paymentNumber";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_UNIT_ID = "unitId";
    public static final String FIELD_POSITION_ID = "positionId";
    public static final String FIELD_EMPLOYEE_ID = "employeeId";
    public static final String FIELD_ACCOUNTING_ENTITY = "accountingEntity";
    public static final String FIELD_DATE_OF_APPLICATION = "dateOfApplication";
    public static final String FIELD_PAYMENT_TYPE = "paymentType";
    public static final String FIELD_CURRENCY = "currency";
    public static final String FIELD_APPROVAL_DATE = "approvalDate";
    public static final String FIELD_PAYMENT_STATUS = "paymentStatus";
    public static final String FIELD_PAYMENT_TRANSACTION = "paymentTransaction";
    public static final String FIELD_TENANT_ID = "tenantId";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long headerId;

    @ApiModelProperty(value = "付款单号", required = true)
    @NotBlank
    private String paymentNumber;

    @ApiModelProperty(value = "公司")
    private Long companyId;

    @ApiModelProperty(value = "部门")
    private Long unitId;

    @ApiModelProperty(value = "岗位")
    private Long positionId;

    @ApiModelProperty(value = "员工")
    private Long employeeId;

    @ApiModelProperty(value = "核算主体")
    private String accountingEntity;

    @ApiModelProperty(value = "申请日期")
    private Date dateOfApplication;

    @ApiModelProperty(value = "付款申请单类型")
    private String paymentType;

    @ApiModelProperty(value = "币种")
    private String currency;

    @ApiModelProperty(value = "审批日期")
    private Date approvalDate;

    @ApiModelProperty(value = "单据状态")
    private String paymentStatus;

    @MultiLanguageField
    @ApiModelProperty(value = "交易附言(多语言)")
    private String paymentTransaction;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

    @Transient
    private BigDecimal amountCount;


    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
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

    public String getAccountingEntity() {
        return accountingEntity;
    }

    public void setAccountingEntity(String accountingEntity) {
        this.accountingEntity = accountingEntity;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(String paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}

