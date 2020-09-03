package com.my.university.data;

import com.my.common.dbconnection.OracleDBConnection;
import com.my.university.dao.UniversityDao;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityDaoImpl implements UniversityDao {

    @Override
    public Long create(UniversityRequestData universityRequestData) {
        try {
            final String sql = "INSERT INTO k_university(name,establishment_date) VALUES(?,TO_DATE(?,'dd-MM-YYYY'))";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setString(1, universityRequestData.getName());
            pstmt.setString(2, universityRequestData.getEstablishmentDate());
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_university");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Long update(Long id, UniversityRequestData universityRequestData) {
        try {
            final String sql = "UPDATE k_university u SET u.name = ?, u.establishment_date = TO_DATE(?,'dd-MM-YYYY') WHERE u.id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setString(1, universityRequestData.getName());
            pstmt.setString(2, universityRequestData.getEstablishmentDate());
            pstmt.setLong(3, id);
            int row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Long delete(Long id) {
        try {
            final String sql = "DELETE k_university WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            int row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public UniversityData retriveOne(Long id) {
        UniversityData universityData = null;
        try {
            final String sql = "SELECT * FROM k_university WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //Long id = rs.getLong("id");
                final String name = rs.getString("name");
                final String establishmentDate = rs.getString("establishment_date");
                universityData = UniversityData.initData(id, name, establishmentDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return universityData;
    }

    @Override
    public List<UniversityData> retriveAll() {
        final List<UniversityData> universityDatas = new ArrayList<>();
        try {
            final String sql = "SELECT * FROM k_university";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Long id = rs.getLong("id");
                final String name = rs.getString("name");
                final String establishmentDate = rs.getString("establishment_date");
                universityDatas.add(UniversityData.initData(id, name, establishmentDate));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return universityDatas;
    }
}
