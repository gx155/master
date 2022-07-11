package com.hand.study.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hand.study.domain.entity.Employee;
import com.hand.study.domain.repository.EmployeeRepository;
import com.hand.study.infra.mapper.EmployeeMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工基础定义(Employee)资源库
 *
 * @author gx
 * @since 2022-07-11 12:23:10
 */
@Component
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements EmployeeRepository {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectList(Employee employee) {
        return employeeMapper.selectList(employee);
    }

    @Override
    public Employee selectByPrimary(Long employeeId) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        List<Employee> employees = employeeMapper.selectList(employee);
        if (employees.size() == 0) {
            return null;
        }
        return employees.get(0);
    }

}

