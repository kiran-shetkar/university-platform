package com.my.student.service;

public interface StudentWritePlatformService {
    Long create(Long departmentId, String apiRequestJsonData);

    Long update(Long id, String apiRequestJsonData);

    Long delete(Long id);
}
