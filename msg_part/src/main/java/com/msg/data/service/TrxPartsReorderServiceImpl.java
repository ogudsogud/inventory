package com.msg.data.service;

import com.msg.data.model.TrxPartsReorderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 26/09/2018.
 */

@Transactional
@Repository
public class TrxPartsReorderServiceImpl implements TrxPartsReorderService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    class TrxPartsReorderRowMapp implements RowMapper<TrxPartsReorderModel> {

        @Override
        public TrxPartsReorderModel mapRow(ResultSet rs, int i) throws SQLException {
            TrxPartsReorderModel trxPartsReorderModel = new TrxPartsReorderModel();
            trxPartsReorderModel.setId_trx_parts_stock_in_reorder(rs.getInt("id_trx_parts_stock_in_reorder"));
            trxPartsReorderModel.setId_mtr_sub_parts(rs.getInt("id_mtr_sub_parts"));
            trxPartsReorderModel.setId_unit_institution(rs.getInt("unit_parts_name"));
            trxPartsReorderModel.setId_unit_institution(rs.getInt("token_no"));
            trxPartsReorderModel.setId_parts_number(rs.getString("id_parts_number"));
            trxPartsReorderModel.setSub_parts_name(rs.getString("sub_parts_name"));
            trxPartsReorderModel.setBrand_name(rs.getString("brand_name"));
            trxPartsReorderModel.setInstitution_name(rs.getString("institution_name"));
            trxPartsReorderModel.setUnit_ins_name(rs.getString("ins_unit_name"));
            trxPartsReorderModel.setBad_parts(rs.getString("bad_parts"));
            trxPartsReorderModel.setDescription(rs.getString("description"));
            trxPartsReorderModel.setReturned_by(rs.getString("returned_by"));
            trxPartsReorderModel.setReturned_on(rs.getString("returned_on"));
            trxPartsReorderModel.setAccepted_by(rs.getString("accepted_by"));
            trxPartsReorderModel.setAccepted_on(rs.getString("accepted_on"));
            trxPartsReorderModel.setStatus(rs.getInt("status"));
            return trxPartsReorderModel;
        }
    }

    @Override
    public List<TrxPartsReorderModel> getPartsReorder() {
        String sql = "SELECT  reorder.id_trx_parts_stock_in_reorder," +
                "trxout.id_mtr_sub_parts," +
                "                parts.sub_parts_name," +
                "                unit.unit_parts_name," +
                "                trxout.ticket_no, " +
                "                brand.brand_name," +
                "                parts.id_parts_number, "+
                "                ins.institution_name," +
                "                uninst.ins_unit_name," +
                "                reorder.bad_parts," +
                "                reorder.description," +
                "                reorder.quantity_unit," +
                "                reorder.returned_by," +
                "                reorder.returned_on," +
                "                reorder.accepted_by," +
                "                reorder.accepted_on, " +
                "                reorder.status " +
                "                FROM trx_parts_stock_in_reorder reorder " +
                "                LEFT JOIN trx_parts_stock_out trxout ON reorder.id_trx_parts_stock_out = trxout.id_trx_parts_stock_out " +
                "                LEFT JOIN mtr_sub_parts parts ON parts.id_mtr_sub_parts = trxout.id_mtr_sub_parts " +
                "                LEFT JOIN mtr_unit_parts unit ON unit.id_unit_parts = parts.id_unit_parts " +
                "                LEFT JOIN mtr_brand brand ON brand.id_brand = parts.id_brand " +
                "                LEFT JOIN mtr_unit_institution uninst ON uninst.id_unit_institution = trxout.id_unit_institution " +
                "                LEFT JOIN mtr_institution ins ON ins.id_institution = uninst.id_institution " +
                "                WHERE reorder.status = 1";
        RowMapper<TrxPartsReorderModel> rowMapper = new TrxPartsReorderRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    @Override
    public boolean insertReorder(TrxPartsReorderModel trxPartsReorderModel) {

        String sql = "INSERT INTO trx_parts_stock_in_reorder (" +
                "id_trx_parts_stock_out, " +
                "bad_parts, " +
                "description, " +
                "quantity_unit, " +
                "returned_by, " +
                "returned_on, " +
                "accepted_by, " +
                "accepted_on, " +
                "status) " +

                "VALUES (?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                trxPartsReorderModel.getId_trx_parts_stock_out(),
                trxPartsReorderModel.getBad_parts(),
                trxPartsReorderModel.getDescription(),
                trxPartsReorderModel.getQuantity_unit(),
                trxPartsReorderModel.getReturned_by(),
//                trxPartsReorderModel.getReturned_on(),
                trxPartsReorderModel.getAccepted_by()
//                trxPartsReorderModel.getAccepted_on(),
//                trxPartsReorderModel.getStatus()
        );
        return false;
    }


    @Override
    public void updateTrxParteorder(TrxPartsReorderModel trxPartsReorderModel) {
        String sql = "UPDATE trx_parts_stock_in_reorder SET " +
                "id_trx_parts_stock_out = ?," +
                "bad_parts = ?," +
                "description = ?," +
                "quantity_unit = ?," +
                "returned_by = ?," +
                "returned_on = now()," +
                "accepted_by = ?," +
                "accepted_on = now() WHERE " +
                "id_trx_parts_stock_in_reorder = ? AND status = 1";
        jdbcTemplate.update(sql,
                trxPartsReorderModel.getId_trx_parts_stock_out(),
                trxPartsReorderModel.getBad_parts(),
                trxPartsReorderModel.getDescription(),
                trxPartsReorderModel.getQuantity_unit(),
                trxPartsReorderModel.getReturned_by(),
                trxPartsReorderModel.getAccepted_by(),
                trxPartsReorderModel.getId_trx_parts_stock_in_reorder());
    }


    @Override
    public void deletePartsReorder(String id_trx_reorder) {
        String sql = "UPDATE trx_parts_stock_in_reorder SET status = 0 WHERE id_trx_parts_stock_in_reorder = ?";
        jdbcTemplate.update(sql, id_trx_reorder);
    }
}
