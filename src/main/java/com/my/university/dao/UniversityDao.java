package com.my.university.dao;

import com.my.university.data.UniversityData;
import com.my.university.data.UniversityRequestData;

import java.util.List;

public interface UniversityDao {

    Long create(UniversityRequestData universityRequestData);

    Long update(Long id, UniversityRequestData universityRequestData);

    Long delete(Long id);

    UniversityData retriveOne(Long id);

    List<UniversityData> retriveAll();
}
