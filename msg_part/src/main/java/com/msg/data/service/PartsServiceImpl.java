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
            partsModel.setPart_name(rs.getString("part_name"));
            partsModel.setPart_number(rs.getString("part_number"));
            partsModel.setBrand_name(rs.getString("brand_name"));
            partsModel.setQuantity(rs.getInt("quantity"));
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
        String sql = "SELECT * FROM mtr_parts";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert parts baru
    @Override
    public boolean insertPartsNew(PartsModel partsModel) {

        String sql = "INSERT INTO mtr_parts (part_number, part_name, brand_name, quantity, created_by, created_on, updated_by, updated_on,status)" +
                "VALUES (?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                partsModel.getPart_number(),
                partsModel.getPart_name(),
                partsModel.getBrand_name(),
                partsModel.getQuantity(),
                partsModel.getCreated_by(),
                partsModel.getUpdated_by()
 );

        return false;
    }

    //jika insert parts baru sudah ada
    @Override
    public boolean isPartsExist(String part_number) {
        String sql = "SELECT count(*) from mtr_parts WHERE part_number = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, part_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }



    //untuk mencari data parts berdasarkan parameter
    @Override
    public PartsModel getByPartNumb(String part_number) {
        String sql = "SELECT * FROM mtr_parts WHERE part_number LIKE ?";
        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_number);
        return partsModel;
    }

//    @Override
//         public PartsModel getByPartName(String part_name) {
//        String sql = "SELECT * FROM mtr_parts WHERE part_name LIKE ?";
//        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
//        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_name);
//        return partsModel;
//    }
//
//    @Override
//    public PartsModel getByBrandName(String brand_name) {
//        String sql = "SELECT * FROM mtr_parts WHERE brand_name LIKE ?";
//        RowMapper<PartsModel> rowMapper = new PartsRowMapp();
//        PartsModel partsModel = jdbcTemplate.queryForObject(sql, rowMapper, brand_name);
//        return partsModel;
//    }

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
