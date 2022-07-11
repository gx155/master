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
 * 员工岗位定义(OrgPosition)实体类
 *
 * @author gx
 * @since 2022-07-11 12:22:45
 */

@ApiModel("员工岗位定义")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "exp_org_position")
public class OrgPosition extends AuditDomain {
    private static final long serialVersionUID = -30900792297095808L;

    public static final String FIELD_POSITION_ID = "positionId";
    public static final String FIELD_UNIT_ID = "unitId";
    public static final String FIELD_POSITION_CODE = "positionCode";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PARENT_POSITION_ID = "parentPositionId";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_EMPLOYEE_JOB_ID = "employeeJobId";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_SOURCE_CODE = "sourceCode";
    public static final String FIELD_SOURCE_HEADER_ID = "sourceHeaderId";
    public static final String FIELD_SOURCE_LINE_ID = "sourceLineId";
    public static final String FIELD_SOURCE_REFERENCE = "sourceReference";

    @Id
    @GeneratedValue
    private Long positionId;

    @ApiModelProperty(value = "部门ID")
    private Long unitId;

    @ApiModelProperty(value = "岗位")
    private String positionCode;

    @ApiModelProperty(value = "描述ID")
    private String description;

    @ApiModelProperty(value = "上级岗位ID")
    private Long parentPositionId;

    @ApiModelProperty(value = "公司ID")
    private Long companyId;

    @ApiModelProperty(value = "员工职务ID")
    private Long employeeJobId;

    @ApiModelProperty(value = "启用标志", required = true)
    @NotBlank
    private String enabledFlag;

    @ApiModelProperty(value = "租户id", required = true)
    @NotNull
    private Long tenantId;

    private String sourceCode;

    private Long sourceHeaderId;

    private Long sourceLineId;

    private String sourceReference;


    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentPositionId() {
        return parentPositionId;
    }

    public void setParentPositionId(Long parentPositionId) {
        this.parentPositionId = parentPositionId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getEmployeeJobId() {
        return employeeJobId;
    }

    public void setEmployeeJobId(Long employeeJobId) {
        this.employeeJobId = employeeJobId;
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

