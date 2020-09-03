package com.my.employee.temprory.service;

public interface TemporaryEmployeeWritePlatformService {

    Long create(Long departmentId, String apiRequestJsonData);

    Long update(Long departmentId, Long id, String apiRequestJsonData);

    Long delete(Long departmentId, Long id);
}
