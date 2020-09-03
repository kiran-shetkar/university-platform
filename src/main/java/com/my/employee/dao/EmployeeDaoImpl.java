package com.my.employee.dao;

import com.my.common.dbconnection.OracleDBConnection;
import com.my.department.data.DepartmentData;
import com.my.employee.data.AllEmployeeData;
import com.my.employee.data.EmployeeData;
import com.my.employee.data.EmployeeRequestData;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Long create(Long departmentId, EmployeeRequestData employeeRequestData) {
        try {
            final String sql = "INSERT INTO k_employee(department_id, first_name, last_name, mobile_no, salary, dob) VALUES(?,?,?,?,?,TO_DATE(?,'dd-MM-YYYY'))";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            setCommonData(departmentId, employeeRequestData, pstmt);
            int i = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey(" k_employee");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long update(Long departmentId, Long id, EmployeeRequestData employeeRequestData) {
        try {

            final String sql = "UPDATE  k_employee e SET e.department_id = ?, e.first_name = ?, e.last_name = ?, e.mobile_no = ?, e.salary = ?, e.dob = TO_DATE(?,'dd-MM-YYYY') WHERE id = ? AND department_id = ?";
            PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);

            setCommonData(departmentId, employeeRequestData, pstmt);

            pstmt.setLong(7, id);
            pstmt.setLong(8, departmentId);

            int i = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_employee");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void setCommonData(final Long departmentId, final EmployeeRequestData employeeRequestData, final PreparedStatement pstmt) throws SQLException {
        pstmt.setLong(1, departmentId);
        pstmt.setString(2, employeeRequestData.getFirstName());
        pstmt.setString(3, employeeRequestData.getLastName());
        pstmt.setLong(4, employeeRequestData.getMobileNo());
        pstmt.setLong(5, employeeRequestData.getSalary());
        pstmt.setString(6, employeeRequestData.getDob());
    }


    @Override
    public Long delete(Long departmentId, Long id) {
        try {
            final String sql = "DELETE  k_employee WHERE id = ? AND department_id = ? ";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.setLong(2, departmentId);
            int row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public EmployeeData retrieveOne(final Long id) {
        EmployeeData employeeData = null;
        try {
            final StringBuilder sb = sqlBuilderForPermanentEmployee().append("WHERE e.id = ? ");
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sb.toString());
            pstmt.setLong(1, id);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final String firstName = rs.getString("first_name");
                final String lastName = rs.getString("last_name");
                final Long mobileNo = rs.getLong("mobile_no");
                final Long salary = rs.getLong("salary");
                final String dob = rs.getString("dob");

                final Long departmentId = rs.getLong("department_id");
                final String departmentName = rs.getString("departmentName");
                final DepartmentData departmentData = DepartmentData.initData(departmentId, departmentName);

                employeeData = EmployeeData.initData(id, firstName, lastName, mobileNo, salary, dob, departmentData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeData;
    }

    @Override
    public AllEmployeeData retrieveAll(final Long departmentId) {
        final List<EmployeeData> permanentEmployees = new ArrayList<>();
        final List<EmployeeData> temporaryEmployees = new ArrayList<>();
        try {
            final StringBuilder sb = sqlBuilderForPermanentAndTemporaryEmployee();
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sb.toString());
            pstmt.setLong(1, departmentId);
            pstmt.setLong(2, departmentId);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Long id = rs.getLong("id");
                final String firstName = rs.getString("first_name");
                final String lastName = rs.getString("last_name");
                final Long mobileNo = rs.getLong("mobile_no");
                final Long salary = rs.getLong("salary");
                final String dob = rs.getString("dob");
                final String employeementType = rs.getString("employeementType");

                final String departmentName = rs.getString("departmentName");
                final DepartmentData departmentData = DepartmentData.initData(departmentId, departmentName);

                final EmployeeData employeeData = EmployeeData.initData(id, firstName, lastName, mobileNo, salary, dob, departmentData);

                if (employeementType.equals("P")) {
                    permanentEmployees.add(employeeData);
                } else {
                    temporaryEmployees.add(employeeData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AllEmployeeData.initData(permanentEmployees, temporaryEmployees);
    }


    private StringBuilder sqlBuilderForPermanentEmployee() {
        final StringBuilder sb = new StringBuilder(100);
        sb.append("SELECT e.*, d.name as departmentName ");
        sb.append("FROM  k_employee e  ");
        sb.append("JOIN k_department d ON d.id = e.department_id ");
        return sb;
    }

    private StringBuilder sqlBuilderForPermanentAndTemporaryEmployee() {
        final StringBuilder sb = new StringBuilder(100);
        sb.append("SELECT ");
        sb.append("ke.id,ke.first_name ,ke.LAST_NAME,ke.MOBILE_NO ,ke.SALARY,ke.DOB,'P' AS employeementType,kd.name as departmentName ");
        sb.append("FROM k_employee ke  ");
        sb.append("JOIN k_department kd ON kd.id = ke.department_id ");
        sb.append("WHERE kd.id = ? ");
        sb.append("UNION ALL ");
        sb.append("SELECT ");
        sb.append("kte.id,kte.first_name ,kte.LAST_NAME,kte.MOBILE_NO ,kte.SALARY,kte.DOB,'T' AS employeementType,ktd.name as departmentName ");
        sb.append("FROM K_TEMPORARY_EMPLOYEE kte   ");
        sb.append("JOIN K_DEPARTMENT ktd ON ktd.ID = kte.DEPARTMENT_ID  ");
        sb.append("WHERE ktd.id = ? ");
        return sb;
    }

}
