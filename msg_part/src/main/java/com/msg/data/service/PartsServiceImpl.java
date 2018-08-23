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
            partsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            partsModel.setParts_name(rs.getString("parts_name"));
            partsModel.setBrand_name(rs.getString("brand_name"));
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
        String sql = "SELECT * FROM mtr_parts WHERE status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

//    //get data nama unit
//    @Override
//    public List<UnitPartsModel> getUnitName() {
//        class PartsRowMapp implements RowMapper<UnitPartsModel> {
//
//            @Override
//            public UnitPartsModel mapRow(ResultSet rs, int i) throws SQLException {
//                UnitPartsModel unitPartsModel = new UnitPartsModel();
//                unitPartsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
//
//                return unitPartsModel;
//            }
//        }
//
//        String sql = "SELECT unit_parts_name FROM mtr_stock_unit_parts WHERE status = 1";
//        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
//        return this.jdbcTemplate.query(sql,rowMapper);
//    }


    @Override
    public boolean insertPartsNew(PartsModel partsModel) {

        String sql = "INSERT INTO mtr_parts (" +
                "                id_parts_number," +
                "                unit_parts_name," +
                "                parts_name," +
                "                brand_name," +
                "                specification," +
                "                created_by," +
                "                created_on," +
                "                updated_by," +
                "                updated_on," +
                "                status)" +
                "                VALUES ( ?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                partsModel.getId_parts_number(),
                partsModel.getUnit_parts_name(),
                partsModel.getParts_name(),
                partsModel.getBrand_name(),
                partsModel.getSpecification(),
                partsModel.getCreated_by(),
                partsModel.getUpdated_by()
         );
        return false;
    }


    @Override
    public boolean isPartsExist(String id_part_number) {
        String sql = "SELECT count(*) from mtr_parts WHERE id_parts_number = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_part_number);
        return count == 0;
    }

    @Override
    public PartsModel getByUnitName(String unit_parts_name) {
        String sql = "SELECT * FROM mtr_parts WHERE unit_parts_name = ? AND status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, unit_parts_name);
        return partsModel;
    }


    @Override
    public PartsModel getByIdPartNumb(String id_parts_number) {
        String sql = "SELECT * FROM mtr_parts WHERE id_parts_number = ? AND status = 1";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, id_parts_number);
        return partsModel;
    }


    @Override
    public PartsModel getByIdPart(String id_mtr_parts) {
        String sql = "SELECT * FROM mtr_parts WHERE id_mtr_parts = ?";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, id_mtr_parts);
        return partsModel;
    }

    @Override
    public void updatePart(PartsModel partsModel) {
        String sql = "UPDATE mtr_parts SET " +
                "unit_parts_name = ?, " +
                "parts_name = ?, " +
                "brand_name = ?, " +
                "specification = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_parts_number = ? AND status = 1";
        jdbcTemplate.update(sql,
                partsModel.getUnit_parts_name(),
                partsModel.getParts_name(),
                partsModel.getBrand_name(),
                partsModel.getSpecification(),
                partsModel.getUpdated_by(),
                partsModel.getId_parts_number());
    }

    @Override
    public void deletePartNumber(String id_part_number) {
        String sql = "UPDATE mtr_parts SET status = 0 where id_parts_number = ? ";
        jdbcTemplate.update(sql, id_part_number);
    }
}
