package com.my.employee.service;

import com.my.employee.dao.EmployeeDao;
import com.my.employee.data.AllEmployeeData;
import com.my.employee.data.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReadPlatformServiceImpl implements EmployeeReadPlatformService {

    private final EmployeeDao dao;

    @Autowired
    public EmployeeReadPlatformServiceImpl(final EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public EmployeeData retrieveOne(Long id) {
        return this.dao.retrieveOne(id);
    }

    @Override
    public AllEmployeeData retrieveAll(final Long departmentId) {
        return this.dao.retrieveAll(departmentId);
    }
}
