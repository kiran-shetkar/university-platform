package com.my.department.data;

import com.my.university.data.UniversityData;

public class DepartmentData {

    private Long id;

    private Long collegeId;

    private String name;

    private DepartmentData(Long id, Long collegeId, String name) {
        this.id = id;
        this.collegeId = collegeId;
        this.name = name;
    }

    public static DepartmentData initData(Long id, String name) {
        final Long collegeId = null;
        return new DepartmentData(id, collegeId, name);
    }

    public static DepartmentData initData(Long id, Long collegeId, String name) {
        return new DepartmentData(id, collegeId, name);
    }


    public Long getId() {
        return id;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public String getName() {
        return name;
    }
}
