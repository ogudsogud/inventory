package com.msg.data.service;


import com.msg.data.model.TrxPartInModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 09/07/2018.
 */
@Transactional
@Repository
public class TrxPartInServiceImpl implements TrxPartInService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<TrxPartInModel> {

        @Override
        public TrxPartInModel mapRow(ResultSet rs, int i) throws SQLException {
            TrxPartInModel trxPartInModel = new TrxPartInModel();
            trxPartInModel.setId_trx_parts_stock_in(rs.getInt("id_trx_parts_stock_in"));
            trxPartInModel.setId_parts_number(rs.getString("id_parts_number"));
            trxPartInModel.setParts_name(rs.getString("parts_name"));
            trxPartInModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            trxPartInModel.setSpecification(rs.getString("specification"));
            trxPartInModel.setQuantity_unit(rs.getInt("quantity_unit"));
            trxPartInModel.setCreated_by(rs.getString("created_by"));
            trxPartInModel.setCreated_on(rs.getString("created_on"));
            trxPartInModel.setUpdated_by(rs.getString("updated_by"));
            trxPartInModel.setUpdated_on(rs.getString("updated_on"));
            trxPartInModel.setStatus(rs.getInt("status"));
            return trxPartInModel;
        }
    }

    @Override
    public List<TrxPartInModel> getPartsIn() {
        String sql = "SELECT * FROM trx_part_stock_in";
        RowMapper<TrxPartInModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsStock(TrxPartInModel trxPartInModel) {

        String sql = "INSERT INTO trx_part_stock_in (" +
                                "id_parts_number," +
                                "parts_name," +
                                "unit_parts_name," +
                                "description," +
                                "quantity_unit," +
                                "created_by," +
                                "created_on," +
                                "updated_by," +
                                "updated_on," +
                                "status)" +
                        "VALUES (?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                trxPartInModel.getId_parts_number(),
                trxPartInModel.getParts_name(),
                trxPartInModel.getUnit_parts_name(),
                trxPartInModel.getSpecification(),
                trxPartInModel.getQuantity_unit(),
                trxPartInModel.getCreated_by(),
                trxPartInModel.getUpdated_by()
        );
        return false;
    }

   @Override
    public boolean isPartsInExist(String id_parts_number) {
        String sql = "SELECT count(*) from trx_part_stock_in WHERE id_parts_number = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_parts_number);
       return count == 0;
    }

    @Override
    public TrxPartInModel getPartsNumber(String id_parts_number) {
        String sql = "SELECT * FROM trx_part_stock_in WHERE id_parts_number = ?";
        RowMapper<TrxPartInModel> rowMapper = new PartsRowMapp();
        TrxPartInModel trxPartInModel = jdbcTemplate.queryForObject(sql, rowMapper, id_parts_number);
        return trxPartInModel;
    }

    @Override
    public void updateTrxPart(TrxPartInModel trxPartInModel) {
        String sql = "UPDATE trx_part_stock_in SET " +
                "id_parts_number = ?, " +
                "parts_name = ?, " +
                "unit_parts_name = ?, " +
                "brand_name = ?, " +
                "specification = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_trx_parts_stock_in = ?";
        jdbcTemplate.update(sql,
                trxPartInModel.getId_parts_number(),
                trxPartInModel.getUnit_parts_name(),
                trxPartInModel.getParts_name(),
                trxPartInModel.getUnit_parts_name(),
                trxPartInModel.getBrand_name(),
                trxPartInModel.getSpecification(),
                trxPartInModel.getUpdated_by(),
                trxPartInModel.getId_parts_number());
    }

    @Override
    public void deletePartNumber(String id_part_number) {
        String sql = "UPDATE trx_parts_stock_in SET status = 0 where id_parts_number = ? ";
        jdbcTemplate.update(sql, id_part_number);
    }

}
