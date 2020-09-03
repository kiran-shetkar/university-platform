package com.my.college.dao;

import com.my.college.data.CollegeData;
import com.my.college.data.CollegeRequestData;

import java.util.List;

public interface CollegeDao {

    Long create(Long universityId, CollegeRequestData collegeRequestData);

    Long update(Long id, CollegeRequestData collegeRequestData);

    Long delete(Long id);

    CollegeData retriveOne(Long id);

    List<CollegeData> retrieveAll();
}
