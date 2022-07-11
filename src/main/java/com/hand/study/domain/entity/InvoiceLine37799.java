package com.hand.study.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 单据行表(InvoiceLine37799)实体类
 *
 * @author gx
 * @since 2022-07-11 10:45:00
 */

@ApiModel("单据行表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hfm_invoice_line_37799")
public class InvoiceLine37799 extends AuditDomain {
    private static final long serialVersionUID = -27293449656698259L;

    public static final String FIELD_LINE_ID = "lineId";
    public static final String FIELD_HEADER_ID = "headerId";
    public static final String FIELD_LINE_NUMBER = "lineNumber";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PAY_FLAG = "payFlag";
    public static final String FIELD_INVOICE_METHOD = "invoiceMethod";
    public static final String FIELD_AMOUNT = "amount";
    public static final String FIELD_INVOICE_DATE = "invoiceDate";
    public static final String FIELD_TENANT_ID = "tenantId";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long lineId;

    @ApiModelProperty(value = "头id")
    private Long headerId;

    @ApiModelProperty(value = "行号")
    private String lineNumber;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否支付标志")
    private String payFlag;

    @ApiModelProperty(value = "付款方式")
    private String invoiceMethod;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @Transient
    @ApiModelProperty(value = "总额")
    private BigDecimal amountSum;

    @ApiModelProperty(value = "支付完成日期")
    private Date invoiceDate;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;


    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag;
    }

    public String getInvoiceMethod() {
        return invoiceMethod;
    }

    public void setInvoiceMethod(String invoiceMethod) {
        this.invoiceMethod = invoiceMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}

