package com.my.college.data;

public class CollegeData {
    private Long id;
    private Long universityId;
    private String name;
    private String establishmentDate;

    public Long getId() {
        return id;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    private CollegeData(Long id, Long universityId, String name, String establishmentDate) {
        this.id = id;
        this.universityId = universityId;
        this.name = name;
        this.establishmentDate = establishmentDate;
    }

    public static CollegeData initData(Long id, Long universityId, String name, String establishmentDate) {
        return new CollegeData(id, universityId, name, establishmentDate);
    }
}
