package com.my.employee.service;

public interface EmployeeWritePlatformService {

    Long create(Long departmentId, String apiRequestJsonData);

    Long update(Long departmentId, Long id, String apiRequestJsonData);

    Long delete(Long departmentId, Long id);
}
