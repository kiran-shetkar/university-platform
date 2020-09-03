package com.my.employee.temprory.service;

import com.my.common.dbconnection.OracleDBConnection;
import com.my.department.data.DepartmentData;
import com.my.employee.data.EmployeeData;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemporaryEmployeeReadPlatformServiceImpl implements TemporaryEmployeeReadPlatformService {

    @Override
    public EmployeeData retrieveOne(Long departmentId, Long id) {
        EmployeeData temporaryEmployeeData = null;
        try {
            final StringBuilder sb = sqlBuilderForEmployee().append("WHERE e.department_id = ? AND e.id = ? ");
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sb.toString());
            pstmt.setLong(1, departmentId);
            pstmt.setLong(2, id);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final String firstName = rs.getString("first_name");
                final String lastName = rs.getString("last_name");
                final Long mobileNo = rs.getLong("mobile_no");
                final Long salary = rs.getLong("salary");
                final String dob = rs.getString("dob");

                final Long collegeId = null;
                final String departmentName = rs.getString("departmentName");
                final DepartmentData departmentData = DepartmentData.initData(departmentId, collegeId, departmentName);

                temporaryEmployeeData = EmployeeData.initData(id, firstName, lastName, mobileNo, salary, dob, departmentData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temporaryEmployeeData;
    }

    private StringBuilder sqlBuilderForEmployee() {
        final StringBuilder sb = new StringBuilder(100);
        sb.append("SELECT e.*, d.name as departmentName ");
        sb.append("FROM  k_temporary_employee e  ");
        sb.append("JOIN k_department d ON d.id = e.department_id ");
        return sb;
    }


    @Override
    public List<EmployeeData> retrieveAll(final Long departmentId) {
        final List<EmployeeData> temporaryEmployeeDatas = new ArrayList<>();
        try {
            final StringBuilder sb = sqlBuilderForEmployee().append("WHERE d.id = ?");
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sb.toString());
            pstmt.setLong(1, departmentId);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Long id = rs.getLong("id");
                final String firstName = rs.getString("first_name");
                final String lastName = rs.getString("last_name");
                final Long mobileNo = rs.getLong("mobile_no");
                final Long salary = rs.getLong("salary");
                final String dob = rs.getString("dob");

                final Long collegeId = null;
                final String departmentName = rs.getString("departmentName");
                final DepartmentData departmentData = DepartmentData.initData(departmentId, collegeId, departmentName);

                temporaryEmployeeDatas.add(EmployeeData.initData(id, firstName, lastName, mobileNo, salary, dob, departmentData));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temporaryEmployeeDatas;
    }
}
