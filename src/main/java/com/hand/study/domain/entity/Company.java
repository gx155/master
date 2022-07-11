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
 * 管理公司(Company)实体类
 *
 * @author gx
 * @since 2022-07-11 12:29:14
 */

@ApiModel("管理公司")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "fnd_company")
public class Company extends AuditDomain{
    private static final long serialVersionUID=-70450673006620200L;

    public static final String FIELD_COMPANY_ID="companyId";
    public static final String FIELD_COMPANY_CODE="companyCode";
    public static final String FIELD_COMPANY_SHORT_NAME="companyShortName";
    public static final String FIELD_COMPANY_FULL_NAME="companyFullName";
    public static final String FIELD_MAG_ORG_ID="magOrgId";
    public static final String FIELD_ADDRESS="address";
    public static final String FIELD_COMPANY_LEVEL_ID="companyLevelId";
    public static final String FIELD_PARENT_COMPANY_ID="parentCompanyId";
    public static final String FIELD_SYSTEM_TIMEZONE_ID="systemTimezoneId";
    public static final String FIELD_LANGUAGE="language";
    public static final String FIELD_MANAGING_CURRENCY="managingCurrency";
    public static final String FIELD_CHIEF_POSITION_ID="chiefPositionId";
    public static final String FIELD_START_DATE_ACTIVE="startDateActive";
    public static final String FIELD_END_DATE_ACTIVE="endDateActive";
    public static final String FIELD_COMPANY_INFO_URL="companyInfoUrl";
    public static final String FIELD_TENANT_ID="tenantId";

    @Id
    @GeneratedValue
    private Long companyId;

    @ApiModelProperty(value = "公司代码", required = true)
    @NotBlank
    private String companyCode;

    @ApiModelProperty(value = "公司简称", required = true)
    @NotBlank
    private String companyShortName;

    @ApiModelProperty(value = "公司全称")
    private String companyFullName;

    @ApiModelProperty(value = "管理组织ID", required = true)
    @NotNull
    private Long magOrgId;

    @ApiModelProperty(value = "公司地址")
    private String address;

    @ApiModelProperty(value = "公司级别ID")
    private Long companyLevelId;

    @ApiModelProperty(value = "父公司ID")
    private Long parentCompanyId;

    @ApiModelProperty(value = "系统时区ID")
    private Long systemTimezoneId;

    @ApiModelProperty(value = "默认语言")
    private String language;

    @ApiModelProperty(value = "管理币种")
    private String managingCurrency;

    @ApiModelProperty(value = "公司主岗位")
    private Long chiefPositionId;

    @ApiModelProperty(value = "启用日期", required = true)
    @NotNull
    private Date startDateActive;

    @ApiModelProperty(value = "失效日期")
    private Date endDateActive;

    @ApiModelProperty(value = "公司信息网址URL")
    private String companyInfoUrl;

    @ApiModelProperty(value = "租户id", required = true)
    @NotNull
    private Long tenantId;



    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public Long getMagOrgId() {
        return magOrgId;
    }

    public void setMagOrgId(Long magOrgId) {
        this.magOrgId = magOrgId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCompanyLevelId() {
        return companyLevelId;
    }

    public void setCompanyLevelId(Long companyLevelId) {
        this.companyLevelId = companyLevelId;
    }

    public Long getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Long parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    public Long getSystemTimezoneId() {
        return systemTimezoneId;
    }

    public void setSystemTimezoneId(Long systemTimezoneId) {
        this.systemTimezoneId = systemTimezoneId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getManagingCurrency() {
        return managingCurrency;
    }

    public void setManagingCurrency(String managingCurrency) {
        this.managingCurrency = managingCurrency;
    }

    public Long getChiefPositionId() {
        return chiefPositionId;
    }

    public void setChiefPositionId(Long chiefPositionId) {
        this.chiefPositionId = chiefPositionId;
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

    public String getCompanyInfoUrl() {
        return companyInfoUrl;
    }

    public void setCompanyInfoUrl(String companyInfoUrl) {
        this.companyInfoUrl = companyInfoUrl;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

}

