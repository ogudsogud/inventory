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
            stockPartsModel.setId_brand(rs.getString("id_brand"));
            stockPartsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            stockPartsModel.setId_part_number(rs.getString("id_part_number"));
            stockPartsModel.setPart_name(rs.getString("part_name"));
            stockPartsModel.setBrand_name(rs.getString("brand_name"));
            stockPartsModel.setSpesification(rs.getString("specification"));
            stockPartsModel.setBad_part(rs.getString("bad_part"));
            stockPartsModel.setQuantity_unit(rs.getInt("quantity_unit"));
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
    public List<StockPartsModel> getDataStockParts() {
        String sql = "SELECT * FROM mtr_stock_parts";
        RowMapper<StockPartsModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert unit parts
    @Override
    public boolean insertStockPartsNew(StockPartsModel stockPartsModel) {

        String sql = "INSERT INTO mtr_stock_parts (" +
                "                id_unit_parts," +
                "                id_brand," +
                "                unit_parts_name," +
                "                id_part_number," +
                "                part_name," +
                "                brand_name," +
                "                specification," +
                "                bad_part," +
                "                quantity_unit," +
                "                created_by," +
                "                created_on," +
                "                updated_by," +
                "                updated_on," +
                "                status)" +
                "                VALUES ( ?,?,?,?,?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                stockPartsModel.getId_unit_parts(),
                stockPartsModel.getId_brand(),
                stockPartsModel.getUnit_parts_name(),
                stockPartsModel.getId_part_number(),
                stockPartsModel.getPart_name(),
                stockPartsModel.getBrand_name(),
                stockPartsModel.getSpesification(),
                stockPartsModel.getBad_part(),
                stockPartsModel.getQuantity_unit(),
                stockPartsModel.getCreated_by(),
//                stockPartsModel.getCreated_on(),
                stockPartsModel.getUpdated_by()
//                stockPartsModel.getUpdated_on(),
//                stockPartsModel.getStatus()
 );

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
