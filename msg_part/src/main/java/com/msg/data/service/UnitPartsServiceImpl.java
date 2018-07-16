package com.msg.data.service;

import com.msg.data.model.StockPartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoga.wiguna on 13/07/2018.
 */
public class UnitPartsServiceImpl implements UnitPartsService {

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

}
