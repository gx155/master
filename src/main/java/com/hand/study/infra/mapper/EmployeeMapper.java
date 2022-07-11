package com.hand.study.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hand.study.domain.entity.Employee;

import java.util.List;

/**
 * 员工基础定义(Employee)应用服务
 *
 * @author gx
 * @since 2022-07-11 12:23:10
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 基础查询
     *
     * @param employee 查询条件
     * @return 返回值
     */
    List<Employee> selectList(Employee employee);
}

