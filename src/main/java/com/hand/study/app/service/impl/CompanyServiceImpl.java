package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.CompanyService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.Company;
import com.hand.study.domain.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 管理公司(Company)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:29:15
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> selectList(PageRequest pageRequest, Company company) {
        return PageHelper.doPageAndSort(pageRequest, () -> companyRepository.selectList(company));
    }

    @Override
    public void saveData(List<Company> companys) {
        List<Company> insertList = companys.stream().filter(line -> line.getCompanyId() == null).collect(Collectors.toList());
        List<Company> updateList = companys.stream().filter(line -> line.getCompanyId() != null).collect(Collectors.toList());
        companyRepository.batchInsertSelective(insertList);
        companyRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

