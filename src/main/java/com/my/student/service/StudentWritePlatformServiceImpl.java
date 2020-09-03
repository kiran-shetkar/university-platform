package com.my.student.service;

import com.my.common.JsonUtils;
import com.my.student.dao.StudentDao;
import com.my.student.data.StudentRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentWritePlatformServiceImpl implements StudentWritePlatformService {

    private final StudentDao dao;

    @Autowired
    public StudentWritePlatformServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Long create(Long departmentId, String apiRequestJsonData) {
        final StudentRequestData studentRequestData = JsonUtils.fromJson(apiRequestJsonData, StudentRequestData.class);
        return this.dao.create(departmentId, studentRequestData);
    }

    @Override
    public Long update(Long id, String apiRequestJsonData) {
        final StudentRequestData studentRequestData = JsonUtils.fromJson(apiRequestJsonData, StudentRequestData.class);
        return this.dao.update(id, studentRequestData);
    }

    @Override
    public Long delete(Long id) {
        return this.dao.delete(id);
    }
}
