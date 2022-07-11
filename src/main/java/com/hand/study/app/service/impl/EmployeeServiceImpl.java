package com.hand.study.app.service.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hand.study.app.service.EmployeeService;
import org.springframework.stereotype.Service;
import com.hand.study.domain.entity.Employee;
import com.hand.study.domain.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 员工基础定义(Employee)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:23:10
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> selectList(PageRequest pageRequest, Employee employee) {
        return PageHelper.doPageAndSort(pageRequest, () -> employeeRepository.selectList(employee));
    }

    @Override
    public void saveData(List<Employee> employees) {
        List<Employee> insertList = employees.stream().filter(line -> line.getEmployeeId() == null).collect(Collectors.toList());
        List<Employee> updateList = employees.stream().filter(line -> line.getEmployeeId() != null).collect(Collectors.toList());
        employeeRepository.batchInsertSelective(insertList);
        employeeRepository.batchUpdateByPrimaryKeySelective(updateList);
    }
}

