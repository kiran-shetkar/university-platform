package com.my.college.service;

import com.my.college.dao.CollegeDao;
import com.my.college.data.CollegeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeReadPlatformServiceImpl implements CollegeReadPlatformService {

    private final CollegeDao dao;

    @Autowired
    public CollegeReadPlatformServiceImpl(CollegeDao dao) {
        this.dao = dao;
    }

    @Override
    public CollegeData retrieveOne(final Long id) {
        return this.dao.retriveOne(id);
    }

    @Override
    public List<CollegeData> retrieveAll() {
        return this.dao.retrieveAll();
    }
}
