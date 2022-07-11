package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.OrgPosition;

import java.util.List;

/**
 * 员工岗位定义(OrgPosition)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:22:45
 */
public interface OrgPositionMapper extends BaseMapper<OrgPosition> {
    /**
     * 基础查询
     *
     * @param orgPosition 查询条件
     * @return 返回值
     */
    List<OrgPosition> selectList(OrgPosition orgPosition);
}

