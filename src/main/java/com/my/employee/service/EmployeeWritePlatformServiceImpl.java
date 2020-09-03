package com.my.employee.service;

import com.my.common.JsonUtils;
import com.my.common.dbconnection.OracleDBConnection;
import com.my.employee.dao.EmployeeDao;
import com.my.employee.data.EmployeeRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class EmployeeWritePlatformServiceImpl implements EmployeeWritePlatformService {

    private final EmployeeDao dao;

    @Autowired
    public EmployeeWritePlatformServiceImpl(final EmployeeDao dao) {
        this.dao = dao;
    }


    @Override
    public Long create(final Long departmentId, final String apiRequestJsonData) {
        final EmployeeRequestData employeeRequestData = JsonUtils.fromJson(apiRequestJsonData, EmployeeRequestData.class);
        return this.dao.create(departmentId, employeeRequestData);
    }

    @Override
    public Long update(final Long departmentId, final Long id, final String apiRequestJsonData) {
        final EmployeeRequestData employeeRequestData = JsonUtils.fromJson(apiRequestJsonData, EmployeeRequestData.class);
        return this.dao.update(departmentId, id, employeeRequestData);
    }


    @Override
    public Long delete(final Long departmentId, final Long id) {
        return this.dao.delete(departmentId, id);
    }
}
