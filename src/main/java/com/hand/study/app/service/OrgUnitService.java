package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.OrgUnit;

import java.util.List;

/**
 * 部门(OrgUnit)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:22:27
 */
public interface OrgUnitService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param orgUnits    查询条件
     * @return 返回值
     */
    Page<OrgUnit> selectList(PageRequest pageRequest, OrgUnit orgUnits);

    /**
     * 保存数据
     *
     * @param orgUnits 数据
     */
    void saveData(List<OrgUnit> orgUnits);

}

