package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.OrgPosition;

import java.util.List;

/**
 * 员工岗位定义(OrgPosition)资源库
 *
 * @author gx
 * @since 2022-07-11 12:22:45
 */
public interface OrgPositionRepository extends BaseRepository<OrgPosition> {
    /**
     * 查询
     *
     * @param orgPosition 查询条件
     * @return 返回值
     */
    List<OrgPosition> selectList(OrgPosition orgPosition);

    /**
     * 根据主键查询（可关联表）
     *
     * @param positionId 主键
     * @return 返回值
     */
    OrgPosition selectByPrimary(Long positionId);
}
