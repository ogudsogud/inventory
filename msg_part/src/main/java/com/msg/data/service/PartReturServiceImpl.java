package com.msg.data.service;

import com.msg.data.model.PartReturModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
public class PartReturServiceImpl implements PartReturService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<PartReturModel> {

        @Override
        public PartReturModel mapRow(ResultSet rs, int i) throws SQLException {
            PartReturModel returModel = new PartReturModel();
            returModel.setPart_number(rs.getString("po_number"));
            returModel.setPart_name(rs.getString("part_name"));
            returModel.setPart_number(rs.getString("part_number"));
            returModel.setBrand_name(rs.getString("brand_name"));
            returModel.setBrand_name(rs.getString("description"));
            returModel.setQuantity(rs.getInt("quantity"));
            returModel.setReturned_by(rs.getString("returned_by"));
            returModel.setReturned_on(rs.getString("returned_on"));
            returModel.setApproved_by(rs.getString("approved_by"));
            returModel.setApproved_on(rs.getString("approved_on"));
            return returModel;
        }
    }

    //untuk menampilkan data parts stock-in
    @Override
    public List<PartReturModel> getPartsStockIn() {
        String sql = "SELECT * FROM trx_part_in";
        RowMapper<PartReturModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert parts stock-in
    @Override
    public boolean insertPartsStock(PartReturModel returModel) {

        String sql = "INSERT INTO trx_part_stock_in (po_number, part_name, part_number, brand_name, description, quantity, returned_by, returned_on, approved_by, approved_on)" +
                "VALUES (?,?,?,?,?,?,?,NOW(),?,NOW())";
        jdbcTemplate.update(sql,
                returModel.getPo_number(),
                returModel.getPart_name(),
                returModel.getPart_number(),
                returModel.getBrand_name(),
                returModel.getDescription(),
                returModel.getQuantity(),
                returModel.getReturned_by(),
                returModel.getApproved_by()
        );
        return false;
    }

    //jika insert po-parts baru sudah ada
    @Override
    public boolean isPartsExist(String part_number) {
        String sql = "SELECT count(*) from trx_part_stock_in WHERE po_number = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, part_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

}
