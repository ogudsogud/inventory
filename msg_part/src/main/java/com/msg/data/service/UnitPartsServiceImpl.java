package com.msg.data.service;

import com.msg.data.model.UnitPartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 13/07/2018.
 */

@Transactional
@Repository
public class UnitPartsServiceImpl implements UnitPartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<UnitPartsModel> {

        @Override
        public UnitPartsModel mapRow(ResultSet rs, int i) throws SQLException {
            UnitPartsModel unitPartsModel = new UnitPartsModel();
            unitPartsModel.setId_unit_parts(rs.getInt("id_unit_parts"));
            unitPartsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            unitPartsModel.setQuantity_unit(rs.getInt("id_unit_parts"));
            unitPartsModel.setCreated_by(rs.getString("created_by"));
            unitPartsModel.setCreated_on(rs.getString("created_on"));
            unitPartsModel.setUpdated_by(rs.getString("updated_by"));
            unitPartsModel.setUpdated_on(rs.getString("updated_on"));
            unitPartsModel.setStatus(rs.getInt("status"));

            return unitPartsModel;
        }
    }

        //untuk insert unit parts
        @Override
        public boolean insertUnitParts(UnitPartsModel partsModel) {

            String sql = "INSERT INTO mtr_stock_unit_parts (" +
                    "                id_unit_parts," +
                    "                unit_parts_name," +
                    "                quantity_unit," +
                    "                created_by," +
                    "                created_on," +
                    "                updated_by," +
                    "                updated_on," +
                    "                status)" +
                    "                VALUES ( ?,?,?,?,NOW(),?,NOW(),1)";
            jdbcTemplate.update(sql,
                    partsModel.getId_unit_parts(),
                    partsModel.getUnit_parts_name(),
                    partsModel.getQuantity_unit(),
                    partsModel.getCreated_by(),
//                partsModel.getCreated_on(),
                    partsModel.getUpdated_by()
//                partsModel.getUpdated_on(),
//                partsModel.getStatus()
            );

            return false;
        }

    //untuk update data unit

    @Override
    public void updateUnitPart(UnitPartsModel unitPartsModel) {
        String sql = "UPDATE mtr_stock_unit_parts SET " +
                "unit_parts_name = ?, " +
                "bad_parts = ?, " +
                "quantity_unit = ?, " +
//                "created_by = ?, " +
//                "created_on = now(), " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_unit_parts = ?";
        jdbcTemplate.update(sql,
                unitPartsModel.getUnit_parts_name(),
                unitPartsModel.getBad_parts(),
                unitPartsModel.getQuantity_unit(),
//                unitPartsModel.getCreated_by(),
//                unitPartsModel.getCreated_on(),
                unitPartsModel.getUpdated_by(),
//                unitPartsModel.getUpdated_on(),
                unitPartsModel.getStatus());
    }


    //untuk menampilkan data unit
    @Override
    public List<UnitPartsModel> getDataUnit() {
        String sql = "SELECT * FROM mtr_stock_unit_parts WHERE status = 1";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    // cari data

    @Override
    public UnitPartsModel getByIdUnitPart(String id_unit_parts) {
        String sql = "SELECT * FROM mtr_stock_unit_parts WHERE id_unit_parts = ?";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        UnitPartsModel unitPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, id_unit_parts);
        return unitPartsModel;
    }

    @Override
    public UnitPartsModel getByBadPart(String bad_parts) {
        String sql = "SELECT * FROM mtr_stock_unit_parts WHERE bad_parts = ?";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        UnitPartsModel unitPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, bad_parts);
        return unitPartsModel;
    }

    @Override
    public UnitPartsModel getCreatedOn(String created_on) {
        String sql = "SELECT * FROM mtr_stock_unit_parts WHERE created_on = ?";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        UnitPartsModel unitPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, created_on);
        return unitPartsModel;
    }

    //menghapus data unit
    @Override
    public void deleteByIdUnit(String id_unit_parts) {
        String sql = "UPDATE mtr_stock_unit_parts SET status = 0 where id_unit_parts = ?";
        jdbcTemplate.update(sql, id_unit_parts);
    }

    }

