package com.my.university.service;

import com.my.common.dbconnection.OracleDBConnection;
import com.my.university.dao.UniversityDao;
import com.my.university.data.UniversityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityReadPlatformServiceImpl implements UniversityReadPlatformService {

    private final UniversityDao dao;

    @Autowired
    public UniversityReadPlatformServiceImpl(UniversityDao dao) {
        this.dao = dao;
    }

    @Override
    public UniversityData retrieveOne(Long id) {
        return this.dao.retriveOne(id);

    }

    @Override
    public List<UniversityData> retrieveAll() {
        return this.dao.retriveAll();

    }
}