package com.msg.data.service;

import com.msg.data.model.SubPartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ogudsogud on 9/17/2018.
 */

@Repository
@Transactional
public class SubPartsServiceImpl implements SubPartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class SubPartsRowMapp implements RowMapper<SubPartsModel> {

        @Override
        public SubPartsModel mapRow(ResultSet rs, int i) throws SQLException {
            SubPartsModel subPartsModel = new SubPartsModel();
            subPartsModel.setId_mtr_sub_parts(rs.getInt("id_mtr_sub_parts"));
            subPartsModel.setId_parts_number(rs.getString("id_parts_number"));
            subPartsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            subPartsModel.setSub_parts_name(rs.getString("sub_parts_name"));
            subPartsModel.setBrand_name(rs.getString("brand_name"));
            subPartsModel.setSpecification(rs.getString("specification"));
            subPartsModel.setCreated_by(rs.getString("created_by"));
            subPartsModel.setCreated_on(rs.getString("created_on"));
            subPartsModel.setUpdated_by(rs.getString("updated_by"));
            subPartsModel.setUpdated_on(rs.getString("updated_on"));
            subPartsModel.setStatus(rs.getInt("status"));
            return subPartsModel;
        }
    }

    @Override
    public List<SubPartsModel> getDataParts() {
        String sql = "SELECT " +
                "mparts.id_mtr_sub_parts, " +
                "mparts.id_parts_number, " +
                "munit.unit_parts_name, " +
                "mparts.sub_parts_name, " +
                "mbrand.brand_name, " +
                "mparts.specification, " +
                "mparts.created_by, " +
                "mparts.created_on, " +
                "mparts.updated_by, " +
                "mparts.updated_on, " +
                "mparts.status " +
                "FROM mtr_sub_parts mparts " +
                "LEFT JOIN mtr_unit_parts munit ON munit.id_unit_parts = mparts.id_unit_parts " +
                "LEFT JOIN mtr_brand mbrand ON mbrand.id_brand = mparts.id_brand " +
                "WHERE mparts.status = 1";
        RowMapper<SubPartsModel> rowMapper = new SubPartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsNew(SubPartsModel subPartsModel) {

        String sql = "INSERT INTO mtr_sub_parts (" +
                "id_parts_number," +
                "id_unit_parts," +
                "id_brand," +
                "sub_parts_name," +
                "specification," +
                "created_by," +
                "created_on," +
                "updated_by," +
                "updated_on," +
                "status)" +
                "VALUES ( ?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                subPartsModel.getId_parts_number(),
                subPartsModel.getId_unit_parts(),
                subPartsModel.getId_brand(),
                subPartsModel.getSub_parts_name(),
                subPartsModel.getSpecification(),
                subPartsModel.getCreated_by(),
                subPartsModel.getUpdated_by()
        );
        return false;
    }


    //get by parameter
//    @Override
//    public List<PartsModel> getParam(String id_parts_number, String sub_parts_name, String spek) {
//        String sql = "SELECT * FROM mtr_sub_parts WHERE id_parts_number LIKE '"+id_parts_number+"' OR " +
//                "sub_parts_name LIKE '"+sub_parts_name+"' OR " +
//                "specification LIKE '"+spek+"' AND status = 1";
//        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
//        return this.jdbcTemplate.query(sql,rowMapper);
//    }

//    @Override
//    public List<PartsModel> getByIdPartNumb(String id_parts_number) {
//        String sql = "SELECT * FROM mtr_sub_parts WHERE id_parts_number LIKE '"+id_parts_number+"' AND status = 1";
//        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
//        return this.jdbcTemplate.query(sql,rowMapper);
//    }
//
//
//    @Override
//    public List<PartsModel> getBySpek(String specification) {
//        String sql = "SELECT * FROM mtr_sub_parts WHERE specification LIKE '"+specification+"' AND status = 1";
//        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
//        return this.jdbcTemplate.query(sql,rowMapper);
//    }
//
//    @Override
//    public List<PartsModel> getPartsName(String partsname) {
//        String sql = "SELECT * FROM mtr_sub_parts WHERE parts_name LIKE '"+partsname+"' AND status = 1";
//        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
//        return this.jdbcTemplate.query(sql,rowMapper);
//    }


    @Override
    public void updatePart(SubPartsModel subPartsModel) {
        String sql = "UPDATE mtr_sub_parts SET " +
                "id_unit_parts = ?, " +
                "id_brand = ?, " +
                "sub_parts_name = ?, " +
                "specification = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_mtr_sub_parts = ? AND status = 1";
        jdbcTemplate.update(sql,
                subPartsModel.getId_unit_parts(),
                subPartsModel.getId_brand(),
                subPartsModel.getSub_parts_name(),
                subPartsModel.getSpecification(),
                subPartsModel.getUpdated_by(),
                subPartsModel.getId_mtr_sub_parts());
    }

    @Override
    public void deletePartNumber(int id_mtr_sub_parts) {
        String sql = "UPDATE mtr_sub_parts SET status = 0 where id_mtr_sub_parts = ?";
        jdbcTemplate.update(sql, id_mtr_sub_parts);
    }

}
