package com.my.employee.service;

import com.my.employee.data.AllEmployeeData;
import com.my.employee.data.EmployeeData;

public interface EmployeeReadPlatformService {

    EmployeeData retrieveOne(Long id);

    AllEmployeeData retrieveAll(Long departmentId);
}
