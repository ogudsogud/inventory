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
            stockPartsModel.setId_stock_parts(rs.getInt("id_unit_parts"));
            stockPartsModel.setId_unit_parts(rs.getString("id_unit_parts"));
            stockPartsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            stockPartsModel.setPart_name(rs.getString("part_name"));
            stockPartsModel.setSpesification(rs.getString("spesification"));
            stockPartsModel.setBad_part(rs.getString("bad_part"));
            stockPartsModel.setQuantity(rs.getInt("quantity"));
            stockPartsModel.setStatus(rs.getInt("status"));

            return stockPartsModel;
        }
    }

    //untuk menampilkan data parts
    @Override
    public List<StockPartsModel> getDataStockParts() {
        String sql = "SELECT * FROM mtr_stock_parts";
        RowMapper<StockPartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert unit parts
    @Override
    public boolean insertStockPartsNew(StockPartsModel stockPartsModel) {

        String sql = "INSERT INTO mtr_stock_parts (id_stock_parts, id_unit_parts,  part_number, " +
                "unit_parts_name, part_name, bad_part, spesification, quantity, status)" +
                "VALUES (?,?,?,?,?,?,?,?,1)";
        jdbcTemplate.update(sql,
                stockPartsModel.getId_stock_parts(),
                stockPartsModel.getId_unit_parts(),
                stockPartsModel.getPart_number(),
                stockPartsModel.getUnit_parts_name(),
                stockPartsModel.getPart_name(),
                stockPartsModel.getBad_part(),
                stockPartsModel.getSpesification(),
                stockPartsModel.getQuantity(),
                stockPartsModel.getStatus());

        return false;
    }

    //jika insert parts baru sudah ada
    @Override
    public boolean isStockPartsExist(String part_number) {
        String sql = "SELECT count(*) from mtr_stock_parts WHERE part_number = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, part_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    //untuk mencari data parts berdasarkan parameter
    @Override
    public StockPartsModel getPartNumb(String part_number) {
        String sql = "SELECT * FROM mtr_stock_parts WHERE part_number = ?";
        RowMapper<StockPartsModel> rowMapper = new PartsRowMapp();
        StockPartsModel stockPartsModel = jdbcTemplate.queryForObject(sql, rowMapper, part_number);
        return stockPartsModel;
    }

    @Override
         public StockPartsModel getByStockPartName(String part_name) {
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
