package com.msg.data.service;

import com.msg.data.model.StockPartsModel;
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
public class StockPartsServiceImpl implements StockPartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<StockPartsModel> {

        @Override
        public StockPartsModel mapRow(ResultSet rs, int i) throws SQLException {
            StockPartsModel stockPartsModel = new StockPartsModel();
            stockPartsModel.setId_unit_parts(rs.getString("id_unit_parts"));
            stockPartsModel.setPart_number(rs.getString("part_number"));
            stockPartsModel.setUnit_name(rs.getString("unit_name"));
            stockPartsModel.setPart_name(rs.getString("part_name"));
            stockPartsModel.setSpesification(rs.getString("spesification"));
            stockPartsModel.setQuantity(rs.getInt("quantity"));
            stockPartsModel.setCreated_by(rs.getString("created_by"));
            stockPartsModel.setCreated_on(rs.getString("created_on"));
            stockPartsModel.setUpdated_by(rs.getString("updated_by"));
            stockPartsModel.setUpdated_on(rs.getString("updated_on"));
            stockPartsModel.setStatus(rs.getInt("status"));

            return stockPartsModel;
        }
    }

    //untuk menampilkan data parts
    @Override
    public List<StockPartsModel> getDataParts() {
        String sql = "SELECT * FROM mtr_stock_parts";
        RowMapper<StockPartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert unit parts
    @Override
    public boolean insertUnitPartsNew(StockPartsModel unitPartsModel) {

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
    public StockPartsModel getByUnitPartNumb(String part_number) {
        String sql = "SELECT * FROM mtr_stock_parts WHERE part_number = ?";
        RowMapper<StockPartsModel> rowMapper = new PartsRowMapp();
        StockPartsModel stockPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_number);
        return stockPartsModel;
    }

    @Override
         public StockPartsModel getByUnitPartName(String part_name) {
        String sql = "SELECT * FROM mtr_stock_parts WHERE part_name LIKE ?";
        RowMapper<StockPartsModel> rowMapper = new PartsRowMapp();
        StockPartsModel stockPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_name);
        return stockPartsModel;
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
