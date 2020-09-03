package com.my.department.service;

import com.my.common.JsonUtils;
import com.my.department.dao.DepartmentDao;
import com.my.department.data.DepartmentRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentWritePlatformServiceImpl implements DepartmentWritePlatformService {

    private final DepartmentDao dao;

    @Autowired
    public DepartmentWritePlatformServiceImpl(DepartmentDao dao) {
        this.dao = dao;
    }

    @Override
    public Long create(Long collegeId, String apiRequestJsonData) {
        final DepartmentRequestData departmentRequestData = JsonUtils.fromJson(apiRequestJsonData, DepartmentRequestData.class);
        return this.dao.create(collegeId, departmentRequestData);
    }

    @Override
    public Long update(Long id, String apiRequestJsonData) {
        final DepartmentRequestData departmentRequestData = JsonUtils.fromJson(apiRequestJsonData, DepartmentRequestData.class);
        return this.dao.update(id, departmentRequestData);
    }

    @Override
    public Long delete(Long id) {
        return this.dao.delete(id);

    }
}
