package com.my.employee.temprory.service;

import com.my.common.JsonUtils;
import com.my.common.dbconnection.OracleDBConnection;
import com.my.employee.data.EmployeeRequestData;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class TemporaryEmployeeWritePlatformServiceImpl implements TemporaryEmployeeWritePlatformService {

    @Override
    public Long create(Long departmentId, final String apiRequestJsonData) {
        try {
            final EmployeeRequestData temporaryEmployeeRequestData = JsonUtils.fromJson(apiRequestJsonData, EmployeeRequestData.class);
            final String sql = "INSERT INTO k_temporary_employee(department_id, first_name, last_name, mobile_no, salary, dob) VALUES(?,?,?,?,?,TO_DATE(?,'dd-MM-YYYY'))";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);

            setCommonData(departmentId, temporaryEmployeeRequestData, pstmt);

            final int row = pstmt.executeUpdate();

            return OracleDBConnection.generatedKey(" k_temporary_employee");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long update(final Long departmentId, final Long id, final String apiRequestJsonData) {
        try {
            final EmployeeRequestData temporaryEmployeeRequestData = JsonUtils.fromJson(apiRequestJsonData, EmployeeRequestData.class);
            final String sql = "UPDATE  k_temporary_employee e SET e.department_id = ?, e.first_name = ?, e.last_name = ?, e.mobile_no = ?, e.salary = ?, e.dob = TO_DATE(?,'dd-MM-YYYY') WHERE id = ? AND department_id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);

            setCommonData(departmentId, temporaryEmployeeRequestData, pstmt);

            pstmt.setLong(7, id);
            pstmt.setLong(8, departmentId);

            final int row = pstmt.executeUpdate();

            return OracleDBConnection.generatedKey("k_temporary_employee");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setCommonData(final Long departmentId, final EmployeeRequestData temporaryEmployeeRequestData, final PreparedStatement pstmt) throws SQLException {
        pstmt.setLong(1, departmentId);
        pstmt.setString(2, temporaryEmployeeRequestData.getFirstName());
        pstmt.setString(3, temporaryEmployeeRequestData.getLastName());
        pstmt.setLong(4, temporaryEmployeeRequestData.getMobileNo());
        pstmt.setLong(5, temporaryEmployeeRequestData.getSalary());
        pstmt.setString(6, temporaryEmployeeRequestData.getDob());
    }

    @Override
    public Long delete(Long departmentId, final Long id) {
        try {
            final String sql = "DELETE k_temporary_employee WHERE id = ? AND department_id = ? ";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.setLong(2, departmentId);
            final int row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
