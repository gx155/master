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
 * 部门(OrgUnit)实体类
 *
 * @author gx
 * @since 2022-07-11 12:22:27
 */

@ApiModel("部门")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "exp_org_unit")
public class OrgUnit extends AuditDomain {
    private static final long serialVersionUID = -15869688486989807L;

    public static final String FIELD_UNIT_ID = "unitId";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_UNIT_CODE = "unitCode";
    public static final String FIELD_UNIT_TYPE_ID = "unitTypeId";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PARENT_UNIT_ID = "parentUnitId";
    public static final String FIELD_CHIEF_POSITION_ID = "chiefPositionId";
    public static final String FIELD_ORG_UNIT_LEVEL_ID = "orgUnitLevelId";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_SOURCE_CODE = "sourceCode";
    public static final String FIELD_SOURCE_HEADER_ID = "sourceHeaderId";
    public static final String FIELD_SOURCE_LINE_ID = "sourceLineId";
    public static final String FIELD_SOURCE_REFERENCE = "sourceReference";

    @Id
    @GeneratedValue
    private Long unitId;

    @ApiModelProperty(value = "公司ID", required = true)
    @NotNull
    private Long companyId;

    @ApiModelProperty(value = "部门代码", required = true)
    @NotBlank
    private String unitCode;

    @ApiModelProperty(value = "部门类型ID")
    private Long unitTypeId;

    @ApiModelProperty(value = "描述", required = true)
    @NotBlank
    private String description;

    @ApiModelProperty(value = "上级部门代码")
    private Long parentUnitId;

    @ApiModelProperty(value = "主岗位ID")
    private Long chiefPositionId;

    @ApiModelProperty(value = "部门级别ID")
    private Long orgUnitLevelId;

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


    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Long getUnitTypeId() {
        return unitTypeId;
    }

    public void setUnitTypeId(Long unitTypeId) {
        this.unitTypeId = unitTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentUnitId() {
        return parentUnitId;
    }

    public void setParentUnitId(Long parentUnitId) {
        this.parentUnitId = parentUnitId;
    }

    public Long getChiefPositionId() {
        return chiefPositionId;
    }

    public void setChiefPositionId(Long chiefPositionId) {
        this.chiefPositionId = chiefPositionId;
    }

    public Long getOrgUnitLevelId() {
        return orgUnitLevelId;
    }

    public void setOrgUnitLevelId(Long orgUnitLevelId) {
        this.orgUnitLevelId = orgUnitLevelId;
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

