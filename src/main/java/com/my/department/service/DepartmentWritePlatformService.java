package com.my.department.service;

public interface DepartmentWritePlatformService {

    Long create(final Long collegeId, final String apiRequestJsonData);

    Long update(Long id, String apiRequestJsonData);

    Long delete(Long id);
}
