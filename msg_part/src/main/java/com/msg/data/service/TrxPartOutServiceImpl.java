package com.msg.data.service;

import com.msg.data.model.TrxPartOutModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 10/07/2018.
 */

@Transactional
@Repository
public class TrxPartOutServiceImpl implements TrxPartOutService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<TrxPartOutModel> {

        @Override
        public TrxPartOutModel mapRow(ResultSet rs, int i) throws SQLException {
            TrxPartOutModel trxPartOutModel = new TrxPartOutModel();
            trxPartOutModel.setTicket_no(rs.getString("ticket_no"));
            trxPartOutModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            trxPartOutModel.setId_parts_number(rs.getString("id_parts_number"));
            trxPartOutModel.setSub_parts_name(rs.getString("sub_parts_name"));
            trxPartOutModel.setBrand_name(rs.getString("brand_name"));
            trxPartOutModel.setInstitution_name(rs.getString("institution_name"));
            trxPartOutModel.setIns_unit_name(rs.getString("ins_unit_name"));
            trxPartOutModel.setDescription(rs.getString("description"));
            trxPartOutModel.setQuantity_unit(rs.getInt("quantity_unit"));
            trxPartOutModel.setRequested_by(rs.getString("requested_by"));
            trxPartOutModel.setRequested_on(rs.getString("requested_on"));
            trxPartOutModel.setApproved_by(rs.getString("approved_by"));
            trxPartOutModel.setApproved_on(rs.getString("approved_on"));
            return trxPartOutModel;
        }
    }

    @Override
    public List<TrxPartOutModel> getPartsStockOut() {
        String sql = "SELECT  stokot.ticket_no," +
                "unit.unit_parts_name," +
                "parts.id_parts_number," +
                "parts.sub_parts_name," +
                "brand.brand_name," +
                "ins.institution_name," +
                "uninst.ins_unit_name," +
                "stokot.description," +
                "stokot.quantity_unit," +
                "stokot.requested_by," +
                "stokot.requested_on," +
                "stokot.approved_by," +
                "stokot.approved_on " +
                "FROM trx_parts_stock_out stokot " +
                "LEFT JOIN mtr_sub_parts parts ON parts.id_mtr_sub_parts = stokot.id_mtr_sub_parts " +
                "LEFT JOIN mtr_unit_parts unit ON unit.id_unit_parts = parts.id_unit_parts " +
                "LEFT JOIN mtr_brand brand ON brand.id_brand = parts.id_brand " +
                "LEFT JOIN mtr_unit_institution uninst ON uninst.id_unit_institution = stokot.id_unit_institution " +
                "LEFT JOIN mtr_institution ins ON ins.id_institution = uninst.id_institution " +
                "WHERE stokot.status = 1";
        RowMapper<TrxPartOutModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsOut(TrxPartOutModel trxPartOutModel) {

        String sql = "INSERT INTO trx_parts_stock_out (" +
                "id_stock_unit_parts," +
                "ticket_no, " +
                "id_mtr_sub_parts, " +
                "id_unit_institution, " +
                "description, " +
                "quantity_unit, " +
                "requested_by, " +
                "requested_on, " +
                "approved_by, " +
                "approved_on, " +
                "updated_by, " +
                "updated_on, " +
                "status) " +

                "VALUES (?,?,?,?,?,?,?,NOW(),?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                trxPartOutModel.getId_stock_unit_parts(),
                trxPartOutModel.getTicket_no(),
                trxPartOutModel.getId_mtr_sub_parts(),
                trxPartOutModel.getId_unit_institution(),
                trxPartOutModel.getDescription(),
                trxPartOutModel.getQuantity_unit(),
                trxPartOutModel.getRequested_by(),
//                partOutModel.getRequested_on(),
                trxPartOutModel.getApproved_by(),
//                partOutModel.getApproved_on(),
                trxPartOutModel.getUpdated_by()
//                partOutModel.getUpdated_on()
//                partOutModel.getStatus()
        );
        return false;
    }

    @Override
    public void updateTrxPart(TrxPartOutModel trxPartInModel) {
        String sql = "UPDATE trx_parts_stock_in SET " +
                "id_stock_unit_parts," +
                "ticket_no," +
                "id_mtr_sub_parts," +
                "id_unit_institution," +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_trx_parts_stock_out = ? AND status = 1";
        jdbcTemplate.update(sql,
                trxPartInModel.getId_stock_unit_parts(),
                trxPartInModel.getTicket_no(),
                trxPartInModel.getId_mtr_sub_parts(),
                trxPartInModel.getId_unit_institution(),
                trxPartInModel.getUpdated_by(),
                trxPartInModel.getId_trx_parts_stock_out());
    }


    @Override
    public boolean isPartsOutExist(String po_number) {
        String sql = "SELECT count(*) from trx_parts_stock_out WHERE ticket_no = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, po_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public TrxPartOutModel getByTikno(String ticket_no) {
        String sql = "SELECT * FROM trx_part_stock_out WHERE ticket_no = ?";
        RowMapper<TrxPartOutModel> rowMapper = new PartsRowMapp();
        TrxPartOutModel trxPartOutModel = jdbcTemplate.queryForObject(sql, rowMapper, ticket_no);
        return trxPartOutModel;
    }


    @Override
    public void deleteByTicket(String ticket_no) {
        String sql = "UPDATE trx_part_stock_out SET status = 0 WHERE ticket_no = ?";
        jdbcTemplate.update(sql, ticket_no);
    }

}
