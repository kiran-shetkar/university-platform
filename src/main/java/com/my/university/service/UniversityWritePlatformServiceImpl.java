package com.my.university.service;

import com.my.common.JsonUtils;
import com.my.common.dbconnection.OracleDBConnection;
import com.my.university.dao.UniversityDao;
import com.my.university.data.UniversityRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

@Service
public class UniversityWritePlatformServiceImpl implements UniversityWritePlatformService {

    private final UniversityDao dao;

    @Autowired
    public UniversityWritePlatformServiceImpl(final UniversityDao dao) {
        this.dao = dao;
    }


    @Override
    public Long create(final String apiRequestJsonData) {
        final UniversityRequestData universityRequestData = JsonUtils.fromJson(apiRequestJsonData, UniversityRequestData.class);
        return this.dao.create(universityRequestData);
    }

    @Override
    public Long update(final Long id, final String apiRequestJsonData) {
            final UniversityRequestData universityRequestData = JsonUtils.fromJson(apiRequestJsonData, UniversityRequestData.class);
            return this.dao.update(id, universityRequestData);
    }

    @Override
    public Long delete(final Long id) {
        return this.dao.delete(id);
    }

}
