package com.my.employee.temprory.service;

import com.my.employee.data.EmployeeData;

import java.util.List;

public interface TemporaryEmployeeReadPlatformService {

    EmployeeData retrieveOne(Long departmentId, Long id);

    List<EmployeeData> retrieveAll(Long departmentId);
}
