package com.my.college.service;

public interface CollegeWritePlatformService {

    Long create(Long universityId, String apiRequestJsonData);

    Long update(Long id, String apiRequestJsonData);

    Long delete(Long id);
}
