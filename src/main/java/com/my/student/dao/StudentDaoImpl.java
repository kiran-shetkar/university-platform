package com.my.student.dao;

import com.my.common.dbconnection.OracleDBConnection;
import com.my.student.data.StudentData;
import com.my.student.data.StudentRequestData;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public Long create(Long departmentId, StudentRequestData studentRequestData) {
        try {
            final String sql = "INSERT INTO k_student(department_id, first_name, last_name, mobile_no) VALUES(?, ?, ?, ?)";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, departmentId);
            pstmt.setString(2, studentRequestData.getFirstName());
            pstmt.setString(3, studentRequestData.getLastName());
            pstmt.setLong(4, studentRequestData.getMobileNo());
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_student");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long update(Long id, StudentRequestData studentRequestData) {
        try {
            final String sql = "UPDATE k_student s SET s.department_id = ?, s.first_name = ? , s.last_name = ? WHERE s.id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, studentRequestData.getDepartmentId());
            pstmt.setString(2, studentRequestData.getFirstName());
            pstmt.setString(3, studentRequestData.getLastName());
            pstmt.setLong(4, studentRequestData.getMobileNo());
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_student");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }

    @Override
    public Long delete(Long id) {
        try {
            final String sql = "DELETE k_student WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            int row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public StudentData retrieveOne(Long id) {
        StudentData studentData = null;
        try {
            final String sql = "SELECT * FROM k_student WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                final Long departmentId = res.getLong("department_id");
                final String firstName = res.getString("first_name");
                final String lastName = res.getString("last_name");
                final Long mobileNo = res.getLong("mobile_no");
                studentData = StudentData.initData(departmentId, firstName, lastName, mobileNo);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentData;
    }

    @Override
    public List<StudentData> retrieveAll() {
        final List<StudentData> studentDatas = new ArrayList<>();
        try {
            final String sql = "SELECT * FROM k_student";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            final ResultSet rs;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                final Long departmentId = rs.getLong("department_id");
                final String firstName = rs.getString("first_name");
                final String lastName = rs.getString("last_name");
                final Long mobileNo = rs.getLong("mobile_no");
                studentDatas.add(StudentData.initData(departmentId, firstName, lastName, mobileNo));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return studentDatas;
    }

}