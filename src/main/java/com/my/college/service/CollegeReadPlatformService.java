package com.my.college.service;

import com.my.college.data.CollegeData;

import java.util.List;

public interface CollegeReadPlatformService {

    CollegeData retrieveOne(Long id);

    List<CollegeData> retrieveAll();

}
