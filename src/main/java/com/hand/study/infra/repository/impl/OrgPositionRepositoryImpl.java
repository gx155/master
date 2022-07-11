package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.OrgPosition;
import com.hand.study.domain.repository.OrgPositionRepository;
import com.hand.study.infra.mapper.OrgPositionMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工岗位定义(OrgPosition)资源库
 *
 * @author gx
 * @since 2022-07-11 12:22:45
 */
@Component
public class OrgPositionRepositoryImpl extends BaseRepositoryImpl<OrgPosition> implements OrgPositionRepository {
    @Resource
    private OrgPositionMapper orgPositionMapper;

    @Override
    public List<OrgPosition> selectList(OrgPosition orgPosition) {
        return orgPositionMapper.selectList(orgPosition);
    }

    @Override
    public OrgPosition selectByPrimary(Long positionId) {
        OrgPosition orgPosition = new OrgPosition();
        orgPosition.setPositionId(positionId);
        List<OrgPosition> orgPositions = orgPositionMapper.selectList(orgPosition);
        if (orgPositions.size() == 0) {
            return null;
        }
        return orgPositions.get(0);
    }

}

