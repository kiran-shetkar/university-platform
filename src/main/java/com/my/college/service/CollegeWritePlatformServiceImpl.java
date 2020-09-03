package com.my.college.service;

import com.my.college.dao.CollegeDao;
import com.my.college.data.CollegeRequestData;
import com.my.common.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeWritePlatformServiceImpl implements CollegeWritePlatformService {

    private final CollegeDao dao;

    @Autowired
    public CollegeWritePlatformServiceImpl(CollegeDao dao) {
        this.dao = dao;
    }

    @Override
    public Long create(final Long universityId, final String apiRequestJsonData) {
        final CollegeRequestData collegeRequestData = JsonUtils.fromJson(apiRequestJsonData, CollegeRequestData.class);
        return this.dao.create(universityId, collegeRequestData);
    }

    @Override
    public Long update(Long id, String apiRequestJsonData) {
        final CollegeRequestData collegeRequestData = JsonUtils.fromJson(apiRequestJsonData, CollegeRequestData.class);
        return this.dao.update(id, collegeRequestData);
    }

    @Override
    public Long delete(Long id) {
        return this.dao.delete(id);

    }
}
