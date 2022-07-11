package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.OrgUnit;

import java.util.List;

/**
 * 部门(OrgUnit)资源库
 *
 * @author gx
 * @since 2022-07-11 12:22:27
 */
public interface OrgUnitRepository extends BaseRepository<OrgUnit> {
    /**
     * 查询
     *
     * @param orgUnit 查询条件
     * @return 返回值
     */
    List<OrgUnit> selectList(OrgUnit orgUnit);

    /**
     * 根据主键查询（可关联表）
     *
     * @param unitId 主键
     * @return 返回值
     */
    OrgUnit selectByPrimary(Long unitId);
}
