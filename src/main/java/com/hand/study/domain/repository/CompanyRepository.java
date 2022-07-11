package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.Company;

import java.util.List;

/**
 * 管理公司(Company)资源库
 *
 * @author gx
 * @since 2022-07-11 12:29:15
 */
public interface CompanyRepository extends BaseRepository<Company> {
    /**
     * 查询
     *
     * @param company 查询条件
     * @return 返回值
     */
    List<Company> selectList(Company company);

    /**
     * 根据主键查询（可关联表）
     *
     * @param companyId 主键
     * @return 返回值
     */
    Company selectByPrimary(Long companyId);
}
