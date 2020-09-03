package com.my.university.service;

import com.my.university.data.UniversityData;

import java.util.List;

public interface UniversityReadPlatformService {

    UniversityData retrieveOne(Long id);

    List<UniversityData> retrieveAll();
}
