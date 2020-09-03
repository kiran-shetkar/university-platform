package com.my.department.service;

import com.my.college.data.CollegeData;
import com.my.department.data.DepartmentData;

import java.util.List;

public interface DepartmentReadPlatformService {


    DepartmentData retrieveOne(Long id);

    List<DepartmentData> retrieveAll();
}
