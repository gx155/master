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
 * 员工基础定义(Employee)实体类
 *
 * @author gx
 * @since 2022-07-11 12:23:09
 */

@ApiModel("员工基础定义")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "exp_employee")
public class Employee extends AuditDomain {
    private static final long serialVersionUID = -54295491300167601L;

    public static final String FIELD_EMPLOYEE_ID = "employeeId";
    public static final String FIELD_EMPLOYEE_CODE = "employeeCode";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_MOBIL = "mobil";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_BANK_OF_DEPOSIT = "bankOfDeposit";
    public static final String FIELD_BANK_ACCOUNT = "bankAccount";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    public static final String FIELD_EMPLOYEE_TYPE_ID = "employeeTypeId";
    public static final String FIELD_ID_TYPE = "idType";
    public static final String FIELD_ID_CODE = "idCode";
    public static final String FIELD_NOTES = "notes";
    public static final String FIELD_NATIONAL_IDENTIFIER = "nationalIdentifier";
    public static final String FIELD_HMAP_SYNC_FLAG = "hmapSyncFlag";
    public static final String FIELD_HMAP_SYNC_DATE = "hmapSyncDate";
    public static final String FIELD_PLACE_ID = "placeId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_SOURCE_CODE = "sourceCode";
    public static final String FIELD_SOURCE_HEADER_ID = "sourceHeaderId";
    public static final String FIELD_SOURCE_LINE_ID = "sourceLineId";
    public static final String FIELD_SOURCE_REFERENCE = "sourceReference";

    @Id
    @GeneratedValue
    private Long employeeId;

    @ApiModelProperty(value = "员工代码", required = true)
    @NotBlank
    private String employeeCode;

    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank
    private String name;

    @ApiModelProperty(value = "E-mail")
    private String email;

    @ApiModelProperty(value = "移动电话")
    private String mobil;

    @ApiModelProperty(value = "固定电话")
    private String phone;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "银行帐户")
    private String bankAccount;

    @ApiModelProperty(value = "启用标志", required = true)
    @NotBlank
    private String enabledFlag;

    @ApiModelProperty(value = "员工类型ID")
    private Long employeeTypeId;

    @ApiModelProperty(value = "证件类型")
    private String idType;

    @ApiModelProperty(value = "证件编码")
    private String idCode;

    @ApiModelProperty(value = "备注")
    private String notes;

    @ApiModelProperty(value = "证件编号")
    private String nationalIdentifier;

    @ApiModelProperty(value = "HMAP同步标志，Y/N")
    private String hmapSyncFlag;

    @ApiModelProperty(value = "HMAP同步日期")
    private Date hmapSyncDate;

    @ApiModelProperty(value = "费用政策地点id")
    private Long placeId;

    @ApiModelProperty(value = "租户id", required = true)
    @NotNull
    private Long tenantId;

    private String sourceCode;

    private Long sourceHeaderId;

    private Long sourceLineId;

    private String sourceReference;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNationalIdentifier() {
        return nationalIdentifier;
    }

    public void setNationalIdentifier(String nationalIdentifier) {
        this.nationalIdentifier = nationalIdentifier;
    }

    public String getHmapSyncFlag() {
        return hmapSyncFlag;
    }

    public void setHmapSyncFlag(String hmapSyncFlag) {
        this.hmapSyncFlag = hmapSyncFlag;
    }

    public Date getHmapSyncDate() {
        return hmapSyncDate;
    }

    public void setHmapSyncDate(Date hmapSyncDate) {
        this.hmapSyncDate = hmapSyncDate;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getSourceHeaderId() {
        return sourceHeaderId;
    }

    public void setSourceHeaderId(Long sourceHeaderId) {
        this.sourceHeaderId = sourceHeaderId;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public String getSourceReference() {
        return sourceReference;
    }

    public void setSourceReference(String sourceReference) {
        this.sourceReference = sourceReference;
    }

}

