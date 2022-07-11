package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.OrgUnit;
import com.hand.study.domain.repository.OrgUnitRepository;
import com.hand.study.infra.mapper.OrgUnitMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门(OrgUnit)资源库
 *
 * @author gx
 * @since 2022-07-11 12:22:27
 */
@Component
public class OrgUnitRepositoryImpl extends BaseRepositoryImpl<OrgUnit> implements OrgUnitRepository {
    @Resource
    private OrgUnitMapper orgUnitMapper;

    @Override
    public List<OrgUnit> selectList(OrgUnit orgUnit) {
        return orgUnitMapper.selectList(orgUnit);
    }

    @Override
    public OrgUnit selectByPrimary(Long unitId) {
        OrgUnit orgUnit = new OrgUnit();
        orgUnit.setUnitId(unitId);
        List<OrgUnit> orgUnits = orgUnitMapper.selectList(orgUnit);
        if (orgUnits.size() == 0) {
            return null;
        }
        return orgUnits.get(0);
    }

}

