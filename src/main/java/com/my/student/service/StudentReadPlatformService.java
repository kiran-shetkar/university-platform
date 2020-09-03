package com.my.student.service;

import com.my.student.data.StudentData;

import java.util.List;

public interface StudentReadPlatformService {

    public StudentData retrieveOne(Long id);

    List<StudentData> retrieveAll();
}
