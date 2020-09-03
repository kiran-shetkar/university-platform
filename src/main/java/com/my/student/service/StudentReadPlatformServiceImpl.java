package com.my.student.service;

import com.my.student.dao.StudentDao;
import com.my.student.data.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentReadPlatformServiceImpl implements StudentReadPlatformService {

    private final StudentDao dao;

    @Autowired
    public StudentReadPlatformServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public StudentData retrieveOne(Long id) {
        return this.dao.retrieveOne(id);
    }

    @Override
    public List<StudentData> retrieveAll() {
        return this.dao.retrieveAll();
    }
}
