package com.hand.study.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hand.study.domain.entity.Employee;

import java.util.List;

/**
 * 员工基础定义(Employee)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:23:10
 */
public interface EmployeeService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param employees   查询条件
     * @return 返回值
     */
    Page<Employee> selectList(PageRequest pageRequest, Employee employees);

    /**
     * 保存数据
     *
     * @param employees 数据
     */
    void saveData(List<Employee> employees);

}

