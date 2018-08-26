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
            trxPartInModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            trxPartInModel.setParts_name(rs.getString("parts_name"));
            trxPartInModel.setBrand_name(rs.getString("brand_name"));
            trxPartInModel.setSpecification(rs.getString("specification"));
            trxPartInModel.setBase_country(rs.getString("base_country"));
            trxPartInModel.setQuantity_unit(rs.getInt("quantity_unit"));
            trxPartInModel.setCreated_by(rs.getString("created_by"));
            trxPartInModel.setCreated_on(rs.getString("created_on"));
//            trxPartInModel.setUpdated_by(rs.getString("updated_by"));
//            trxPartInModel.setUpdated_on(rs.getString("updated_on"));
//            trxPartInModel.setStatus(rs.getInt("status"));
            return trxPartInModel;
        }
    }

    @Override
    public List<TrxPartInModel> getPartsIn() {
        String sql = "SELECT " +
                "stokin.id_trx_parts_stock_in, " +
                "parts.id_parts_number," +
                "unit.unit_parts_name," +
                "parts.parts_name," +
                "brand.brand_name," +
                "parts.specification," +
                "brand.base_country," +
                "stokin.quantity_unit," +
                "stokin.created_by," +
                "stokin.created_on " +
                "FROM trx_parts_stock_in stokin " +
                "LEFT JOIN mtr_parts parts ON stokin.id_mtr_parts = parts.id_mtr_parts " +
                "LEFT JOIN mtr_unit_parts unit ON parts.id_unit_parts = unit.id_unit_parts " +
                "LEFT JOIN mtr_brand brand ON parts.id_brand = brand.id_brand " +
                "WHERE stokin.status = 1";
        RowMapper<TrxPartInModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsStock(TrxPartInModel trxPartInModel) {
        String sql = "INSERT INTO trx_parts_stock_in (" +
                                "id_stock_unit_parts," +
                                "id_mtr_parts," +
                                "quantity_unit," +
                                "created_by," +
                                "created_on," +
                                "status) " +
                        "VALUES (?,?,?,?,NOW(),1)";
        jdbcTemplate.update(sql,
                trxPartInModel.getId_stock_unit_parts(),
                trxPartInModel.getId_mtr_parts(),
                trxPartInModel.getQuantity_unit(),
                trxPartInModel.getCreated_by()
       );
        return false;
    }

   @Override
    public boolean isPartsInExist(String id_trx_parts_stock_in) {
        String sql = "SELECT count(*) from trx_parts_stock_in WHERE id_trx_parts_stock_in = ? AND status=1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_trx_parts_stock_in);
       return count == 0;
    }


    @Override
    public void updateTrxPart(TrxPartInModel trxPartInModel) {
        String sql = "UPDATE trx_parts_stock_in SET " +
                "id_stock_unit_parts," +
                "id_mtr_parts," +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_trx_parts_stock_in = ? AND status = 1";
        jdbcTemplate.update(sql,
                trxPartInModel.getId_stock_unit_parts(),
                trxPartInModel.getId_mtr_parts(),
                trxPartInModel.getUpdated_by(),
                trxPartInModel.getId_trx_parts_stock_in());
    }

    @Override
    public void deleteId(String trx_parts_stock_in) {
        String sql = "UPDATE trx_parts_stock_in SET status = 0 where trx_parts_stock_in = ? ";
        jdbcTemplate.update(sql, trx_parts_stock_in);
    }

}
