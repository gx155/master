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
 * 应付发票类型(MoInvoiceType)实体类
 *
 * @author gx
 * @since 2022-07-11 12:24:33
 */

@ApiModel("应付发票类型")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "acp_mo_invoice_type")
public class MoInvoiceType extends AuditDomain {
    private static final long serialVersionUID = -28275446993178422L;

    public static final String FIELD_MO_INVOICE_TYPE_ID = "moInvoiceTypeId";
    public static final String FIELD_MAG_ORG_ID = "magOrgId";
    public static final String FIELD_MO_INVOICE_TYPE_CODE = "moInvoiceTypeCode";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_CURRENCY_CODE = "currencyCode";
    public static final String FIELD_INVOICE_TYPE = "invoiceType";
    public static final String FIELD_PAGE_TEMPLATE = "pageTemplate";
    public static final String FIELD_SOURCE_TYPE = "sourceType";
    public static final String FIELD_JE_ACC_TEMPLATE = "jeAccTemplate";
    public static final String FIELD_REPORT_NAME = "reportName";
    public static final String FIELD_PAYEE_CATEGORY = "payeeCategory";
    public static final String FIELD_PAYMENT_METHOD_ID = "paymentMethodId";
    public static final String FIELD_DIFFERENCE_FLAG = "differenceFlag";
    public static final String FIELD_DIFFERENCE_CODE = "differenceCode";
    public static final String FIELD_POSITIVE_DIFFERENCE = "positiveDifference";
    public static final String FIELD_NEGATIVE_DIFFERENCE = "negativeDifference";
    public static final String FIELD_INVOICE_GROUP_FLAG = "invoiceGroupFlag";
    public static final String FIELD_INVESTMENT_PLAN_CONTROL = "investmentPlanControl";
    public static final String FIELD_AUTO_APPROVE_FLAG = "autoApproveFlag";
    public static final String FIELD_AUTO_AUDIT_FLAG = "autoAuditFlag";
    public static final String FIELD_ADJUSTMENT_FLAG = "adjustmentFlag";
    public static final String FIELD_PAYMENT_FLAG = "paymentFlag";
    public static final String FIELD_FROZEN_FLAG = "frozenFlag";
    public static final String FIELD_RESERVE_BUDGET = "reserveBudget";
    public static final String FIELD_BUDGET_CONTROL_ENABLED = "budgetControlEnabled";
    public static final String FIELD_ICON = "icon";
    public static final String FIELD_CAPTION_HDS_ID = "captionHdsId";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    public static final String FIELD_BUSINESS_CATEGORY = "businessCategory";
    public static final String FIELD_TEMPORARY_MODEL = "temporaryModel";
    public static final String FIELD_REVERSE_PLAN = "reversePlan";
    public static final String FIELD_TEMPORARY_TAX = "temporaryTax";
    public static final String FIELD_REQUEST_ID = "requestId";
    public static final String FIELD_PROGRAM_ID = "programId";
    public static final String FIELD_LAST_UPDATE_LOGIN = "lastUpdateLogin";
    public static final String FIELD_DOC_SCAN_FLAG = "docScanFlag";
    public static final String FIELD_TENANT_ID = "tenantId";

    @Id
    @GeneratedValue
    private Long moInvoiceTypeId;

    @ApiModelProperty(value = "管理组织ID", required = true)
    @NotNull
    private Long magOrgId;

    @ApiModelProperty(value = "应付发票类型代码", required = true)
    @NotBlank
    private String moInvoiceTypeCode;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "币种")
    private String currencyCode;

    @ApiModelProperty(value = "发票类型（SYSCODE：INVOICE_TYPE）", required = true)
    @NotBlank
    private String invoiceType;

    @ApiModelProperty(value = "页面模板（SYSCODE：ACP_MO_INV_TYPE_PAGE_TEMPLATE）")
    private String pageTemplate;

    @ApiModelProperty(value = "来源类型（SYSCODE：ACP_MO_INV_TYPE_SOURCE_TYPE）", required = true)
    @NotBlank
    private String sourceType;

    @ApiModelProperty(value = "凭证模板（SYSCODE：ACP_MO_INV_TYPE_JE_ACC_TEMPLATE）", required = true)
    @NotBlank
    private String jeAccTemplate;

    @ApiModelProperty(value = "报表名称")
    private String reportName;

    @ApiModelProperty(value = "付款对象")
    private String payeeCategory;

    @ApiModelProperty(value = "付款方式", required = true)
    @NotNull
    private Long paymentMethodId;

    @ApiModelProperty(value = "允许开票差异")
    private String differenceFlag;

    @ApiModelProperty(value = "差异类型（SYSCODE：ACR_MO_INV_TYPE_DIFFERENCE）")
    private String differenceCode;

    @ApiModelProperty(value = "正向差异")
    private BigDecimal positiveDifference;

    @ApiModelProperty(value = "负向差异")
    private BigDecimal negativeDifference;

    @ApiModelProperty(value = "分组行管理", required = true)
    @NotBlank
    private String invoiceGroupFlag;

    @ApiModelProperty(value = "需求控制", required = true)
    @NotBlank
    private String investmentPlanControl;

    @ApiModelProperty(value = "自审批", required = true)
    @NotBlank
    private String autoApproveFlag;

    @ApiModelProperty(value = "自审核", required = true)
    @NotBlank
    private String autoAuditFlag;

    @ApiModelProperty(value = "调整", required = true)
    @NotBlank
    private String adjustmentFlag;

    @ApiModelProperty(value = "需要支付", required = true)
    @NotBlank
    private String paymentFlag;

    @ApiModelProperty(value = "冻结", required = true)
    @NotBlank
    private String frozenFlag;

    @ApiModelProperty(value = "预算占用", required = true)
    @NotBlank
    private String reserveBudget;

    @ApiModelProperty(value = "预算控制", required = true)
    @NotBlank
    private String budgetControlEnabled;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "填单说明")
    private Long captionHdsId;

    @ApiModelProperty(value = "启用", required = true)
    @NotBlank
    private String enabledFlag;

    @ApiModelProperty(value = "业务分类（SYSCODE：ACP_MO_INV_TYPE_BUSS_CATEGORY）")
    private String businessCategory;

    @ApiModelProperty(value = "暂估模型（SYSCODE：ACP_MO_INV_TYPE_TEMP_MODEL）")
    private String temporaryModel;

    @ApiModelProperty(value = "冲销计划")
    private String reversePlan;

    @ApiModelProperty(value = "暂估税")
    private String temporaryTax;

    private Long requestId;

    private Long programId;

    private Long lastUpdateLogin;

    @ApiModelProperty(value = "影像扫描标志")
    private String docScanFlag;

    @ApiModelProperty(value = "租户id", required = true)
    @NotNull
    private Long tenantId;


    public Long getMoInvoiceTypeId() {
        return moInvoiceTypeId;
    }

    public void setMoInvoiceTypeId(Long moInvoiceTypeId) {
        this.moInvoiceTypeId = moInvoiceTypeId;
    }

    public Long getMagOrgId() {
        return magOrgId;
    }

    public void setMagOrgId(Long magOrgId) {
        this.magOrgId = magOrgId;
    }

    public String getMoInvoiceTypeCode() {
        return moInvoiceTypeCode;
    }

    public void setMoInvoiceTypeCode(String moInvoiceTypeCode) {
        this.moInvoiceTypeCode = moInvoiceTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getPageTemplate() {
        return pageTemplate;
    }

    public void setPageTemplate(String pageTemplate) {
        this.pageTemplate = pageTemplate;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getJeAccTemplate() {
        return jeAccTemplate;
    }

    public void setJeAccTemplate(String jeAccTemplate) {
        this.jeAccTemplate = jeAccTemplate;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getPayeeCategory() {
        return payeeCategory;
    }

    public void setPayeeCategory(String payeeCategory) {
        this.payeeCategory = payeeCategory;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getDifferenceFlag() {
        return differenceFlag;
    }

    public void setDifferenceFlag(String differenceFlag) {
        this.differenceFlag = differenceFlag;
    }

    public String getDifferenceCode() {
        return differenceCode;
    }

    public void setDifferenceCode(String differenceCode) {
        this.differenceCode = differenceCode;
    }

    public BigDecimal getPositiveDifference() {
        return positiveDifference;
    }

    public void setPositiveDifference(BigDecimal positiveDifference) {
        this.positiveDifference = positiveDifference;
    }

    public BigDecimal getNegativeDifference() {
        return negativeDifference;
    }

    public void setNegativeDifference(BigDecimal negativeDifference) {
        this.negativeDifference = negativeDifference;
    }

    public String getInvoiceGroupFlag() {
        return invoiceGroupFlag;
    }

    public void setInvoiceGroupFlag(String invoiceGroupFlag) {
        this.invoiceGroupFlag = invoiceGroupFlag;
    }

    public String getInvestmentPlanControl() {
        return investmentPlanControl;
    }

    public void setInvestmentPlanControl(String investmentPlanControl) {
        this.investmentPlanControl = investmentPlanControl;
    }

    public String getAutoApproveFlag() {
        return autoApproveFlag;
    }

    public void setAutoApproveFlag(String autoApproveFlag) {
        this.autoApproveFlag = autoApproveFlag;
    }

    public String getAutoAuditFlag() {
        return autoAuditFlag;
    }

    public void setAutoAuditFlag(String autoAuditFlag) {
        this.autoAuditFlag = autoAuditFlag;
    }

    public String getAdjustmentFlag() {
        return adjustmentFlag;
    }

    public void setAdjustmentFlag(String adjustmentFlag) {
        this.adjustmentFlag = adjustmentFlag;
    }

    public String getPaymentFlag() {
        return paymentFlag;
    }

    public void setPaymentFlag(String paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public String getReserveBudget() {
        return reserveBudget;
    }

    public void setReserveBudget(String reserveBudget) {
        this.reserveBudget = reserveBudget;
    }

    public String getBudgetControlEnabled() {
        return budgetControlEnabled;
    }

    public void setBudgetControlEnabled(String budgetControlEnabled) {
        this.budgetControlEnabled = budgetControlEnabled;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCaptionHdsId() {
        return captionHdsId;
    }

    public void setCaptionHdsId(Long captionHdsId) {
        this.captionHdsId = captionHdsId;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getTemporaryModel() {
        return temporaryModel;
    }

    public void setTemporaryModel(String temporaryModel) {
        this.temporaryModel = temporaryModel;
    }

    public String getReversePlan() {
        return reversePlan;
    }

    public void setReversePlan(String reversePlan) {
        this.reversePlan = reversePlan;
    }

    public String getTemporaryTax() {
        return temporaryTax;
    }

    public void setTemporaryTax(String temporaryTax) {
        this.temporaryTax = temporaryTax;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public String getDocScanFlag() {
        return docScanFlag;
    }

    public void setDocScanFlag(String docScanFlag) {
        this.docScanFlag = docScanFlag;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}

