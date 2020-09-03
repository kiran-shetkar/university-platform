package com.my.department.dao;

import com.my.common.dbconnection.OracleDBConnection;
import com.my.department.data.DepartmentData;
import com.my.department.data.DepartmentRequestData;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public Long create(Long collegeId, DepartmentRequestData departmentRequestData) {
        try {
            final String sql = "INSERT INTO k_department(college_id, name) VALUES(?, ?)";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, collegeId);
            pstmt.setString(2, departmentRequestData.getName());
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_department");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Long update(Long id, DepartmentRequestData departmentRequestData) {
        try {
            final String sql = "UPDATE k_department d SET d.college_id = ?, d.name = ? WHERE d.id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, departmentRequestData.getCollegeId());
            pstmt.setString(2, departmentRequestData.getName());
            pstmt.setLong(3, id);
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_department");
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
    }

    @Override
    public Long delete(Long id) {
        try {
            final String sql = "DELETE k_department WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            int row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public DepartmentData retriveOne(Long id) {

        DepartmentData departmentData = null;
        try {
            final String sql = "SELECT * FROM k_department WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                final Long collegeId = res.getLong("college_id");
                final String name = res.getString("name");
                departmentData = DepartmentData.initData(id, collegeId, name);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentData;
    }

    @Override
    public List<DepartmentData> retrieveAll() {
        final List<DepartmentData> departmentDatas = new ArrayList<>();
        try {
            final String sql = "SELECT * FROM k_department";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Long id = rs.getLong("id");
                final Long collegeId = rs.getLong("college_id");
                final String name = rs.getString("name");
                departmentDatas.add(DepartmentData.initData(id, collegeId, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return departmentDatas;
    }
}
