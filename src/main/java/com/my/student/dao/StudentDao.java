package com.my.student.dao;

import com.my.student.data.StudentData;
import com.my.student.data.StudentRequestData;

import java.util.List;

public interface StudentDao {

    Long create(Long departmentId, StudentRequestData studentRequestData);

    Long update(Long id, StudentRequestData studentRequestData);

    Long delete(Long id);

    StudentData retrieveOne(Long id);

    List<StudentData> retrieveAll();
}
