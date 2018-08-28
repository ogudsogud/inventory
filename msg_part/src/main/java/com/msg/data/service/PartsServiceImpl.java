package com.msg.data.service;

import com.msg.data.model.PartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ogudsogud on 7/7/2018.
 */

@Transactional
@Repository
public class PartsServiceImpl implements PartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<PartsModel> {

        @Override
        public PartsModel mapRow(ResultSet rs, int i) throws SQLException {
            PartsModel partsModel = new PartsModel();
            partsModel.setId_mtr_parts(rs.getInt("id_mtr_parts"));
            partsModel.setId_parts_number(rs.getString("id_parts_number"));
            partsModel.setId_mtr_parts(rs.getInt("id_unit_parts"));
            partsModel.setId_mtr_parts(rs.getInt("id_brand"));
            partsModel.setParts_name(rs.getString("parts_name"));
            partsModel.setSpecification(rs.getString("specification"));
            partsModel.setCreated_by(rs.getString("created_by"));
            partsModel.setCreated_on(rs.getString("created_on"));
            partsModel.setUpdated_by(rs.getString("updated_by"));
            partsModel.setUpdated_on(rs.getString("updated_on"));
            partsModel.setStatus(rs.getInt("status"));
            return partsModel;
        }
    }

    @Override
    public List<PartsModel> getDataParts() {
        String sql = "SELECT " +
                "mparts.id_mtr_parts, " +
                "mparts.id_unit_parts, " +
                "mparts.id_brand, " +
                "mparts.id_parts_number, " +
                "munit.unit_parts_name, " +
                "mparts.parts_name, " +
                "mbrand.brand_name, " +
                "mparts.specification, " +
                "mparts.created_by, " +
                "mparts.created_on, " +
                "mparts.updated_by, " +
                "mparts.updated_on, " +
                "mparts.status " +
                "FROM mtr_parts mparts " +
                "LEFT JOIN mtr_unit_parts munit ON munit.id_unit_parts = mparts.id_unit_parts " +
                "LEFT JOIN mtr_brand mbrand ON mbrand.id_brand = mparts.id_brand " +
                "WHERE mparts.status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsNew(PartsModel partsModel) {

        String sql = "INSERT INTO mtr_parts (" +
                "id_parts_number," +
                "id_unit_parts," +
                "id_brand," +
                "parts_name," +
                "specification," +
                "created_by," +
                "created_on," +
                "updated_by," +
                "updated_on," +
                "status)" +
                "VALUES ( ?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                partsModel.getId_parts_number(),
                partsModel.getId_unit_parts(),
                partsModel.getId_brand(),
                partsModel.getParts_name(),
                partsModel.getSpecification(),
                partsModel.getCreated_by(),
                partsModel.getUpdated_by()
         );
        return false;
    }


//    @Override
//    public boolean isPartsExist(String id_part_number) {
//        String sql = "SELECT count(*) from mtr_parts WHERE id_parts_number = ? AND status = 1";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_part_number);
//        return count == 0;
//    }


    //get by parameter
    @Override
    public PartsModel getByIdPartNumb(String id_parts_number) {
        String sql = "SELECT * FROM mtr_parts WHERE id_parts_number = ? AND status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, id_parts_number);
        return partsModel;
    }

    @Override
    public PartsModel getByPartsName(String parts_name) {
        String sql = "SELECT * FROM mtr_parts WHERE parts_name = ?  AND status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper,parts_name);
        return partsModel;
    }

    @Override
    public PartsModel getBySpek(String specification) {
        String sql = "SELECT * FROM mtr_parts WHERE specification = ? AND status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, specification);
        return partsModel;
    }


    @Override
    public void updatePart(PartsModel partsModel) {
        String sql = "UPDATE mtr_parts SET " +
                "id_unit_parts = ?, " +
                "id_brand = ?, " +
                "parts_name = ?, " +
                "specification = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_parts_number = ? AND status = 1";
        jdbcTemplate.update(sql,
                partsModel.getId_unit_parts(),
                partsModel.getId_brand(),
                partsModel.getParts_name(),
                partsModel.getSpecification(),
                partsModel.getUpdated_by(),
                partsModel.getId_parts_number());
    }

    @Override
    public void deletePartNumber(String id_parts_number) {
        String sql = "UPDATE mtr_parts SET status = 0 where id_parts_number = ? ";
        jdbcTemplate.update(sql, id_parts_number);
    }
}
