package com.my.employee.dao;

import com.my.employee.data.AllEmployeeData;
import com.my.employee.data.EmployeeData;
import com.my.employee.data.EmployeeRequestData;

import java.util.List;

public interface EmployeeDao {

    Long create(Long departmentId, EmployeeRequestData employeeRequestData);

    Long update(Long departmentId, Long id, EmployeeRequestData employeeRequestData);

    Long delete(Long departmentId, Long id);

    EmployeeData retrieveOne(Long id);

    AllEmployeeData retrieveAll(Long departmentId);
}
