package com.my.university.service;

public interface UniversityWritePlatformService {

    Long create(String apiRequestJsonData);

    Long update(Long id, String apiRequestJsonData);

    Long delete(Long id);
}
