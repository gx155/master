package com.hand.study.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hand.study.domain.entity.Employee;

import java.util.List;

/**
 * 员工基础定义(Employee)资源库
 *
 * @author gx
 * @since 2022-07-11 12:23:10
 */
public interface EmployeeRepository extends BaseRepository<Employee> {
    /**
     * 查询
     *
     * @param employee 查询条件
     * @return 返回值
     */
    List<Employee> selectList(Employee employee);

    /**
     * 根据主键查询（可关联表）
     *
     * @param employeeId 主键
     * @return 返回值
     */
    Employee selectByPrimary(Long employeeId);
}
