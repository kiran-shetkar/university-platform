package com.my.department.service;

import com.my.department.dao.DepartmentDao;
import com.my.department.data.DepartmentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentReadPlatformServiceImpl implements DepartmentReadPlatformService {

    private final DepartmentDao dao;

    @Autowired
    public DepartmentReadPlatformServiceImpl(DepartmentDao dao) {
        this.dao = dao;
    }

    @Override
    public DepartmentData retrieveOne(Long id) {
        return this.dao.retriveOne(id);
    }

    @Override
    public List<DepartmentData> retrieveAll() {
        return this.dao.retrieveAll();
    }
}
