package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.Company;

import java.util.List;

/**
 * 管理公司(Company)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:29:15
 */
public interface CompanyMapper extends BaseMapper<Company> {
    /**
     * 基础查询
     *
     * @param company 查询条件
     * @return 返回值
     */
    List<Company> selectList(Company company);
}

