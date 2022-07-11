package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.Company;

import java.util.List;

/**
 * 管理公司(Company)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:29:15
 */
public interface CompanyService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param companys    查询条件
     * @return 返回值
     */
    Page<Company> selectList(PageRequest pageRequest, Company companys);

    /**
     * 保存数据
     *
     * @param companys 数据
     */
    void saveData(List<Company> companys);

}

