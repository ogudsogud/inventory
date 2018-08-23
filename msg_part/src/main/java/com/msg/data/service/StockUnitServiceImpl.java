package com.msg.data.service;

import com.msg.data.model.StockUnitModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ogudsogud on 8/22/2018.
 */

@Transactional
@Repository
public class StockUnitServiceImpl implements StockUnitService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<StockUnitModel> {

        @Override
        public StockUnitModel mapRow(ResultSet rs, int i) throws SQLException {
            StockUnitModel stockUnitModel = new StockUnitModel();
            stockUnitModel.setId_unit_parts(rs.getInt("id_unit_parts"));
            stockUnitModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            stockUnitModel.setQuantity_unit(rs.getInt("quantity_unit"));
            stockUnitModel.setCreated_by(rs.getString("created_by"));
            stockUnitModel.setCreated_on(rs.getString("created_on"));
            stockUnitModel.setUpdated_by(rs.getString("updated_by"));
            stockUnitModel.setUpdated_on(rs.getString("updated_on"));
            stockUnitModel.setStatus(rs.getInt("status"));
            return stockUnitModel;
        }
    }

    @Override
    public List<StockUnitModel> getStockUnit() {
        String sql = "SELECT * FROM mtr_stock_unit_parts";
        RowMapper<StockUnitModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

}
