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
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 单据表(InvoiceHeader37799)实体类
 *
 * @author gx
 * @since 2022-07-11 10:44:24
 */
@Data
@ApiModel("单据表")
@VersionAudit
@ModifyAudit
@MultiLanguage
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hfm_invoice_header_37799")
public class InvoiceHeader37799 extends AuditDomain {
    private static final long serialVersionUID = -33826243407039382L;

    public static final String FIELD_HEADER_ID = "headerId";
    public static final String FIELD_INVOICE_NUMBER = "invoiceNumber";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_UNIT_ID = "unitId";
    public static final String FIELD_POSITION_ID = "positionId";
    public static final String FIELD_EMPLOYEE_ID = "employeeId";
    public static final String FIELD_ACC_ENTITY_ID = "accEntityId";
    public static final String FIELD_DATE_OF_APPLICATION = "dateOfApplication";
    public static final String FIELD_INVOICE_TYPE = "invoiceType";
    public static final String FIELD_CURRENCY = "currency";
    public static final String FIELD_APPROVAL_DATE = "approvalDate";
    public static final String FIELD_INVOICE_STATUS = "invoiceStatus";
    public static final String FIELD_INVOICE_TRANSACTION = "invoiceTransaction";
    public static final String FIELD_TENANT_ID = "tenantId";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long headerId;

    @ApiModelProperty(value = "发票单号", required = true)
    @NotBlank
    private String invoiceNumber;

    @ApiModelProperty(value = "公司")
    private Long companyId;

    @ApiModelProperty(value = "部门")
    private Long unitId;

    @ApiModelProperty(value = "岗位")
    private Long positionId;

    @ApiModelProperty(value = "员工")
    private Long employeeId;

    @Transient
    @ApiModelProperty(value = "申请人")
    private String employeeName;

    @ApiModelProperty(value = "核算主体")
    private Long accEntityId;

    @Transient
    @ApiModelProperty(value = "部门/核算主体名称")
    private String unitAccEntityName;

    @ApiModelProperty(value = "申请日期")
    private Date dateOfApplication;

    @ApiModelProperty(value = "发票类型")
    private String invoiceType;

    @ApiModelProperty(value = "币种")
    private String currency;

    @ApiModelProperty(value = "审批日期")
    private Date approvalDate;

    @ApiModelProperty(value = "单据状态")
    private String invoiceStatus;

    @MultiLanguageField
    @ApiModelProperty(value = "交易附言(多语言)")
    private String invoiceTransaction;

    public BigDecimal getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(BigDecimal amountSum) {
        this.amountSum = amountSum;
    }

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;

    @Transient
    private BigDecimal amountSum;

    @Transient
    private List<InvoiceLine37799> invoiceLine37799List;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUnitAccEntityName() {
        return unitAccEntityName;
    }

    public void setUnitAccEntityName(String unitAccEntityName) {
        this.unitAccEntityName = unitAccEntityName;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
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

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoiceTransaction() {
        return invoiceTransaction;
    }

    public void setInvoiceTransaction(String invoiceTransaction) {
        this.invoiceTransaction = invoiceTransaction;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}

