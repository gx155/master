package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.OrgUnitService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.OrgUnit;
import com.hand.study.domain.repository.OrgUnitRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门(OrgUnit)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:22:27
 */
@Service
public class OrgUnitServiceImpl implements OrgUnitService {
    @Autowired
    private OrgUnitRepository orgUnitRepository;

    @Override
    public Page<OrgUnit> selectList(PageRequest pageRequest, OrgUnit orgUnit) {
        return PageHelper.doPageAndSort(pageRequest, () -> orgUnitRepository.selectList(orgUnit));
    }

    @Override
    public void saveData(List<OrgUnit> orgUnits) {
        List<OrgUnit> insertList = orgUnits.stream().filter(line -> line.getUnitId() == null).collect(Collectors.toList());
        List<OrgUnit> updateList = orgUnits.stream().filter(line -> line.getUnitId() != null).collect(Collectors.toList());
        orgUnitRepository.batchInsertSelective(insertList);
        orgUnitRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

