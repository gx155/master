package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.OrgUnit;

import java.util.List;

/**
 * 部门(OrgUnit)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:22:27
 */
public interface OrgUnitMapper extends BaseMapper<OrgUnit> {
    /**
     * 基础查询
     *
     * @param orgUnit 查询条件
     * @return 返回值
     */
    List<OrgUnit> selectList(OrgUnit orgUnit);
}

