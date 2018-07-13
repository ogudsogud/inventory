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
 * Created by Ogudsogud on 7/7/2018.
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
            unitPartsModel.setId_unit_parts(rs.getString("id_unit_parts"));
            unitPartsModel.setPart_number(rs.getString("part_number"));
            unitPartsModel.setUnit_name(rs.getString("unit_name"));
            unitPartsModel.setPart_name(rs.getString("part_name"));
            unitPartsModel.setSpesification(rs.getString("spesification"));
            unitPartsModel.setQuantity(rs.getInt("quantity"));
            unitPartsModel.setCreated_by(rs.getString("created_by"));
            unitPartsModel.setCreated_on(rs.getString("created_on"));
            unitPartsModel.setUpdated_by(rs.getString("updated_by"));
            unitPartsModel.setUpdated_on(rs.getString("updated_on"));
            unitPartsModel.setStatus(rs.getInt("status"));

            return unitPartsModel;
        }
    }

    //untuk menampilkan data parts
    @Override
    public List<UnitPartsModel> getDataParts() {
        String sql = "SELECT * FROM mtr_unit_parts";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert unit parts
    @Override
    public boolean insertUnitPartsNew(UnitPartsModel unitPartsModel) {

        String sql = "INSERT INTO mtr_unit_parts (part_number,unit_name, part_name, spesification, quantity, created_by, created_on, updated_by, updated_on,status)" +
                "VALUES (?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                unitPartsModel.getPart_number(),
                unitPartsModel.getUnit_name(),
                unitPartsModel.getPart_name(),
                unitPartsModel.getSpesification(),
                unitPartsModel.getQuantity(),
                unitPartsModel.getCreated_by(),
                unitPartsModel.getUpdated_by()
 );

        return false;
    }

    //jika insert parts baru sudah ada
    @Override
    public boolean isPartsExist(String part_number) {
        String sql = "SELECT count(*) from mtr_unit_parts WHERE part_number = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, part_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    //untuk mencari data parts berdasarkan parameter
    @Override
    public UnitPartsModel getByUnitPartNumb(String part_number) {
        String sql = "SELECT * FROM mtr_unit_parts WHERE part_number = ?";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        UnitPartsModel unitPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_number);
        return unitPartsModel;
    }

    @Override
         public UnitPartsModel getByUnitPartName(String part_name) {
        String sql = "SELECT * FROM mtr_unit_parts WHERE part_name LIKE ?";
        RowMapper<UnitPartsModel> rowMapper = new PartsRowMapp();
        UnitPartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_name);
        return partsModel;
    }


//    @Override
//    public User getByUserPassword(final String username, final String password) {
//
//        try {
//            User user = this.jdbcTemplate.queryForObject("SELECT * FROM t_mtr_user WHERE username = ? and password = ?",
//                    new Object[]{username, password},
//                    new RowMapper<User>() {
//                        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                            User user = new User();
//                            user.setUsername(rs.getString(username));
//                            user.setPassword(rs.getString(password));
//                            return user;
//                        }
//                    });
//            return user;
//        }catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
}
