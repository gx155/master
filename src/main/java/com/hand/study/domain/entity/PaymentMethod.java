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
 * (PaymentMethod)实体类
 *
 * @author gx
 * @since 2022-07-11 12:25:05
 */

@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "csh_payment_method")
public class PaymentMethod extends AuditDomain {
    private static final long serialVersionUID = 682516879330377680L;

    public static final String FIELD_PAYMENT_METHOD_ID = "paymentMethodId";
    public static final String FIELD_PAYMENT_METHOD_CODE = "paymentMethodCode";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PAY_METHOD_CODE = "payMethodCode";
    public static final String FIELD_PAY_CARRIER_CODE = "payCarrierCode";
    public static final String FIELD_POSTING_FLAG = "postingFlag";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    public static final String FIELD_TENANT_ID = "tenantId";

    @Id
    @GeneratedValue
    private Long paymentMethodId;

    @ApiModelProperty(value = "付款方式代码", required = true)
    @NotBlank
    private String paymentMethodCode;

    @ApiModelProperty(value = "付款方式名称")
    private String description;

    @ApiModelProperty(value = "支付方式（SYSCODE：CSH_PAY_METHOD）", required = true)
    @NotBlank
    private String payMethodCode;

    @ApiModelProperty(value = "支付载体（SYSCODE：CSH_PAY_CARRIER）", required = true)
    @NotBlank
    private String payCarrierCode;

    @ApiModelProperty(value = "直接过账标志", required = true)
    @NotBlank
    private String postingFlag;

    @ApiModelProperty(value = "启用标志", required = true)
    @NotBlank
    private String enabledFlag;

    @ApiModelProperty(value = "租户id", required = true)
    @NotNull
    private Long tenantId;


    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayMethodCode() {
        return payMethodCode;
    }

    public void setPayMethodCode(String payMethodCode) {
        this.payMethodCode = payMethodCode;
    }

    public String getPayCarrierCode() {
        return payCarrierCode;
    }

    public void setPayCarrierCode(String payCarrierCode) {
        this.payCarrierCode = payCarrierCode;
    }

    public String getPostingFlag() {
        return postingFlag;
    }

    public void setPostingFlag(String postingFlag) {
        this.postingFlag = postingFlag;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}

