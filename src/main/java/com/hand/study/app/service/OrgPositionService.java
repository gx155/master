package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.OrgPosition;

import java.util.List;

/**
 * 员工岗位定义(OrgPosition)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:22:45
 */
public interface OrgPositionService {

    /**
     * 查询数据
     *
     * @param pageRequest  分页参数
     * @param orgPositions 查询条件
     * @return 返回值
     */
    Page<OrgPosition> selectList(PageRequest pageRequest, OrgPosition orgPositions);

    /**
     * 保存数据
     *
     * @param orgPositions 数据
     */
    void saveData(List<OrgPosition> orgPositions);

}

