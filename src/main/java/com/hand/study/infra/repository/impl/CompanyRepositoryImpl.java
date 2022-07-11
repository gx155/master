package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.Company;
import com.hand.study.domain.repository.CompanyRepository;
import com.hand.study.infra.mapper.CompanyMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理公司(Company)资源库
 *
 * @author gx
 * @since 2022-07-11 12:29:15
 */
@Component
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public List<Company> selectList(Company company) {
        return companyMapper.selectList(company);
    }

    @Override
    public Company selectByPrimary(Long companyId) {
        Company company = new Company();
        company.setCompanyId(companyId);
        List<Company> companys = companyMapper.selectList(company);
        if (companys.size() == 0) {
            return null;
        }
        return companys.get(0);
    }

}

