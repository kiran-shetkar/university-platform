package com.my.department.dao;

import com.my.department.data.DepartmentData;
import com.my.department.data.DepartmentRequestData;

import java.util.List;

public interface DepartmentDao {
    
    Long create(Long collegeId, DepartmentRequestData departmentRequestData);

    Long update(Long id, DepartmentRequestData departmentRequestData);

    Long delete(Long id);

    DepartmentData retriveOne(Long id);

    List<DepartmentData> retrieveAll();
}
