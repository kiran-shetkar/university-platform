package com.my.college.dao;

import com.my.college.dao.CollegeDao;
import com.my.college.data.CollegeData;
import com.my.college.data.CollegeRequestData;
import com.my.common.dbconnection.OracleDBConnection;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CollegeDaoImpl implements CollegeDao {

    @Override
    public Long create(Long universityId, CollegeRequestData collegeRequestData) {
        try {
            final String sql = "INSERT INTO k_college(university_id, name, establishment_date) VALUES(?, ?, TO_DATE(?,'dd-MM-YYYY'))";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, universityId);
            pstmt.setString(2, collegeRequestData.getName());
            pstmt.setString(3, collegeRequestData.getEstablishmentDate());
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_college");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long update(Long id, CollegeRequestData collegeRequestData) {
        try {
            final String sql = "UPDATE k_college c SET  c.name = ?, c.establishment_date = TO_DATE(?,'dd-MM-YYYY') WHERE c.id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setString(1, collegeRequestData.getName());
            pstmt.setString(2, collegeRequestData.getEstablishmentDate());
            pstmt.setLong(3, id);
            int row = pstmt.executeUpdate();
            return OracleDBConnection.generatedKey("k_college");
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
    }

    @Override
    public Long delete(Long id) {
        try {
            final String sql = "DELETE k_college WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            int row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public CollegeData retriveOne(Long id) {
        CollegeData collegeData = null;
        try {
            final String sql = "SELECT * FROM k_college WHERE id = ?";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                final Long universityId = res.getLong("university_id");
                final String name = res.getString("name");
                final String establishmentDate = res.getString("establishment_date");
                collegeData = CollegeData.initData(id, universityId, name, establishmentDate);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return collegeData;
    }

    @Override
    public List<CollegeData> retrieveAll() {
        final List<CollegeData> collegeDatas = new ArrayList<>();
        try {
            final String sql = "SELECT * FROM k_college";
            final PreparedStatement pstmt = OracleDBConnection.getPrepareStatement(sql);
            final ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                final Long id = rs.getLong("id");
                final Long universityId = rs.getLong("university_id");
                final String name = rs.getString("name");
                final String establishmentDate = rs.getString("establishment_date");
                collegeDatas.add(CollegeData.initData(id, universityId, name, establishmentDate));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return collegeDatas;
    }

}
