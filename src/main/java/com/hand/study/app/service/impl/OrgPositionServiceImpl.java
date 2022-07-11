package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.OrgPositionService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.OrgPosition;
import com.hand.study.domain.repository.OrgPositionRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 员工岗位定义(OrgPosition)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:22:45
 */
@Service
public class OrgPositionServiceImpl implements OrgPositionService {
    @Autowired
    private OrgPositionRepository orgPositionRepository;

    @Override
    public Page<OrgPosition> selectList(PageRequest pageRequest, OrgPosition orgPosition) {
        return PageHelper.doPageAndSort(pageRequest, () -> orgPositionRepository.selectList(orgPosition));
    }

    @Override
    public void saveData(List<OrgPosition> orgPositions) {
        List<OrgPosition> insertList = orgPositions.stream().filter(line -> line.getPositionId() == null).collect(Collectors.toList());
        List<OrgPosition> updateList = orgPositions.stream().filter(line -> line.getPositionId() != null).collect(Collectors.toList());
        orgPositionRepository.batchInsertSelective(insertList);
        orgPositionRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

