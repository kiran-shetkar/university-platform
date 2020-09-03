package com.my.university.data;

public class UniversityData {
    private Long id;
    private String name;
    private String establishmentDate;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    private UniversityData(Long id, String name, String establishmentDate) {
        this.id = id;
        this.name = name;
        this.establishmentDate = establishmentDate;
    }

    public static UniversityData initData(Long id, String name, String establishmentDate) {
        return new UniversityData(id, name, establishmentDate);
    }
}
