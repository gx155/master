package com.hand.study.domain.entity;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 核算主体表(AccountingEntity)实体类
 *
 * @author gx
 * @since 2022-07-11 12:24:04
 */

@ApiModel("核算主体表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "gld_accounting_entity")
public class AccountingEntity extends AuditDomain {
    private static final long serialVersionUID = 409284245925412676L;

    public static final String FIELD_ACC_ENTITY_ID = "accEntityId";
    public static final String FIELD_ACC_ENTITY_CODE = "accEntityCode";
    public static final String FIELD_ACC_ENTITY_NAME = "accEntityName";
    public static final String FIELD_FUNCTIONAL_CURRENCY_CODE = "functionalCurrencyCode";
    public static final String FIELD_PAY_CURRENCY_CODE = "payCurrencyCode";
    public static final String FIELD_COMPANY_TYPE = "companyType";
    public static final String FIELD_START_DATE_ACTIVE = "startDateActive";
    public static final String FIELD_END_DATE_ACTIVE = "endDateActive";
    public static final String FIELD_DEFAULT_SET_OF_BOOKS_ID = "defaultSetOfBooksId";
    public static final String FIELD_DEFAULT_TIMEZONE_ID = "defaultTimezoneId";
    public static final String FIELD_DEFAULT_LANGUAGE = "defaultLanguage";
    public static final String FIELD_DEFAULT_COUNTRY_CODE = "defaultCountryCode";
    public static final String FIELD_TAXPAYER_TYPE = "taxpayerType";
    public static final String FIELD_TAXPAYER_NUMBER = "taxpayerNumber";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_BANK_ACCOUNT = "bankAccount";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_DISTRICT_CODE = "districtCode";
    public static final String FIELD_COMPANY_NATURE_CODE = "companyNatureCode";
    public static final String FIELD_FACTORY_CODE = "factoryCode";

    @Id
    @GeneratedValue
    private Long accEntityId;

    @ApiModelProperty(value = "核算主体代码", required = true)
    @NotBlank
    private String accEntityCode;

    @ApiModelProperty(value = "核算主体名称", required = true)
    @NotBlank
    private String accEntityName;

    @ApiModelProperty(value = "本位币")
    private String functionalCurrencyCode;

    @ApiModelProperty(value = "支付币种", required = true)
    @NotBlank
    private String payCurrencyCode;

    @ApiModelProperty(value = "公司类型", required = true)
    @NotBlank
    private String companyType;

    @ApiModelProperty(value = "有效日期从", required = true)
    @NotNull
    private Date startDateActive;

    @ApiModelProperty(value = "有效日期至")
    private Date endDateActive;

    @ApiModelProperty(value = "默认账套")
    private Long defaultSetOfBooksId;

    @ApiModelProperty(value = "默认时区")
    private Long defaultTimezoneId;

    @ApiModelProperty(value = "默认语言")
    private String defaultLanguage;

    @ApiModelProperty(value = "默认国家")
    private String defaultCountryCode;

    @ApiModelProperty(value = "纳税人类型")
    private String taxpayerType;

    @ApiModelProperty(value = "纳税人识别号")
    private String taxpayerNumber;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "开户行及账号")
    private String bankAccount;

    @ApiModelProperty(value = "租户id", required = true)
    @NotNull
    private Long tenantId;

    private String districtCode;

    private String companyNatureCode;

    private String factoryCode;


    public Long getAccEntityId() {
        return accEntityId;
    }

    public void setAccEntityId(Long accEntityId) {
        this.accEntityId = accEntityId;
    }

    public String getAccEntityCode() {
        return accEntityCode;
    }

    public void setAccEntityCode(String accEntityCode) {
        this.accEntityCode = accEntityCode;
    }

    public String getAccEntityName() {
        return accEntityName;
    }

    public void setAccEntityName(String accEntityName) {
        this.accEntityName = accEntityName;
    }

    public String getFunctionalCurrencyCode() {
        return functionalCurrencyCode;
    }

    public void setFunctionalCurrencyCode(String functionalCurrencyCode) {
        this.functionalCurrencyCode = functionalCurrencyCode;
    }

    public String getPayCurrencyCode() {
        return payCurrencyCode;
    }

    public void setPayCurrencyCode(String payCurrencyCode) {
        this.payCurrencyCode = payCurrencyCode;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public void setStartDateActive(Date startDateActive) {
        this.startDateActive = startDateActive;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    public void setEndDateActive(Date endDateActive) {
        this.endDateActive = endDateActive;
    }

    public Long getDefaultSetOfBooksId() {
        return defaultSetOfBooksId;
    }

    public void setDefaultSetOfBooksId(Long defaultSetOfBooksId) {
        this.defaultSetOfBooksId = defaultSetOfBooksId;
    }

    public Long getDefaultTimezoneId() {
        return defaultTimezoneId;
    }

    public void setDefaultTimezoneId(Long defaultTimezoneId) {
        this.defaultTimezoneId = defaultTimezoneId;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getDefaultCountryCode() {
        return defaultCountryCode;
    }

    public void setDefaultCountryCode(String defaultCountryCode) {
        this.defaultCountryCode = defaultCountryCode;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getCompanyNatureCode() {
        return companyNatureCode;
    }

    public void setCompanyNatureCode(String companyNatureCode) {
        this.companyNatureCode = companyNatureCode;
    }

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

}

