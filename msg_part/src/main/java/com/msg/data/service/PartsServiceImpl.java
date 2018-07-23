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
            partsModel.setId_part_number(rs.getString("id_part_number"));
            partsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            partsModel.setPart_name(rs.getString("part_name"));
            partsModel.setBrand_name(rs.getString("brand_name"));
            partsModel.setSpecification(rs.getString("specification"));
            partsModel.setBad_part(rs.getString("bad_part"));
            partsModel.setCreated_by(rs.getString("created_by"));
            partsModel.setCreated_on(rs.getString("created_on"));
            partsModel.setUpdated_by(rs.getString("updated_by"));
            partsModel.setUpdated_on(rs.getString("updated_on"));
            partsModel.setStatus(rs.getInt("status"));

            return partsModel;
        }
    }

    //untuk menampilkan data parts
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
                "                id_part_number," +
                "                unit_parts_name," +
                "                part_name," +
                "                brand_name," +
                "                specification," +
                "                bad_part," +
//                "                quantity_unit," +
                "                created_by," +
                "                created_on," +
                "                updated_by," +
                "                updated_on," +
                "                status)" +
                "                VALUES ( ?,?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                partsModel.getId_part_number(),
                partsModel.getUnit_parts_name(),
                partsModel.getPart_name(),
                partsModel.getBrand_name(),
                partsModel.getSpecification(),
                partsModel.getBad_part(),
                partsModel.getCreated_by(),
//                stockPartsModel.getCreated_on(),
                partsModel.getUpdated_by()
//                stockPartsModel.getUpdated_on(),
//                stockPartsModel.getStatus()
 );

        return false;
    }


    @Override
    public boolean isPartsExist(String id_part_number) {
        String sql = "SELECT count(*) from mtr_parts WHERE id_part_number = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_part_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PartsModel getByUnitName(String unit_parts_name) {
        String sql = "SELECT * FROM mtr_parts WHERE unit_parts_name = ?";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, unit_parts_name);
        return partsModel;
    }


    @Override
    public PartsModel getByIdPartNumb(String id_part_number) {
        String sql = "SELECT * FROM mtr_parts WHERE id_part_number = ?";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, id_part_number);
        return partsModel;
    }



    @Override
    public void updatePart(PartsModel partsModel) {
        String sql = "UPDATE mtr_parts SET " +
                "id_part_number = ? , " +
                "unit_parts_name = ?, " +
                "part_name = ?, " +
                "brand_name = ?, " +
                "specification = ?, " +
                "bad_part = ?, " +
//                "created_by = ?, " +
//                "created_on = now(), " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_mtr_parts = ?";
        jdbcTemplate.update(sql,
                partsModel.getId_part_number(),
                partsModel.getUnit_parts_name(),
                partsModel.getPart_name(),
                partsModel.getBrand_name(),
                partsModel.getSpecification(),
                partsModel.getBad_part(),
//                stockPartsModel.getCreated_by(),
//                stockPartsModel.getCreated_on(),
                partsModel.getUpdated_by(),
//                stockPartsModel.getUpdated_on(),
//                partsModel.getStatus(),
                partsModel.getId_mtr_parts());
    }

    @Override
    public void deleteById(String id_mtr_parts) {
        String sql = "UPDATE mtr_parts SET status = 0 where id_mtr_parts = ?";
        jdbcTemplate.update(sql, id_mtr_parts);
    }
}
