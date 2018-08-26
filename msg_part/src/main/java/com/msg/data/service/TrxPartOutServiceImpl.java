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
            trxPartOutModel.setId_trx_parts_stock_out(rs.getInt("id_trx_parts_stock_out"));
            trxPartOutModel.setId_stock_unit_parts(rs.getInt("id_stock_unit_parts"));
            trxPartOutModel.setTicket_no(rs.getString("ticket_no"));
            trxPartOutModel.setId_mtr_parts(rs.getInt("id_mtr_parts"));
            trxPartOutModel.setId_unit_institution(rs.getInt("id_unit_institution"));
            trxPartOutModel.setId_unit_parts(rs.getInt("id_unit_parts"));
            trxPartOutModel.setId_brand(rs.getInt("id_brand"));
            trxPartOutModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            trxPartOutModel.setIns_unit_name(rs.getString("id_parts_number"));
            trxPartOutModel.setParts_name(rs.getString("parts_name"));
            trxPartOutModel.setBrand_name(rs.getString("brand_name"));
            trxPartOutModel.setInstitution_name(rs.getString("institution_name"));
            trxPartOutModel.setIns_unit_name(rs.getString("ins_unit_name"));
            trxPartOutModel.setDescription(rs.getString("description"));
            trxPartOutModel.setQuantity_unit(rs.getInt("quantity_unit"));
            trxPartOutModel.setRequested_by(rs.getString("requested_by"));
            trxPartOutModel.setRequested_on(rs.getString("requested_on"));
            trxPartOutModel.setApproved_by(rs.getString("approved_by"));
            trxPartOutModel.setApproved_on(rs.getString("approved_on"));
            trxPartOutModel.setStatus(rs.getInt("status"));
            return trxPartOutModel;
        }
    }

    @Override
    public List<TrxPartOutModel> getPartsStockOut() {
        String sql = "SELECT  stokot.ticket_no," +
                "unit.unit_parts_name," +
                "parts.id_parts_number," +
                "parts.parts_name," +
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
                "LEFT JOIN mtr_parts parts ON stokot.id_mtr_parts = parts.id_mtr_parts " +
                "LEFT JOIN mtr_unit_parts unit ON stokot.id_mtr_parts = parts.id_mtr_parts " +
                "LEFT JOIN mtr_brand brand ON parts.id_brand = brand.id_brand " +
                "LEFT JOIN mtr_unit_institution uninst ON stokot.id_unit_institution = uninst.id_unit_institution " +
                "LEFT JOIN mtr_institution ins ON uninst.id_institution = ins.id_institution " +
                "WHERE stokot.status = 1";
        RowMapper<TrxPartOutModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsOut(TrxPartOutModel trxPartOutModel) {

        String sql = "INSERT INTO trx_part_stock_out (" +
                "id_stock_unit_parts," +
                "ticket_no, " +
                "id_mtr_parts, " +
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
                trxPartOutModel.getId_mtr_parts(),
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
    public boolean isPartsOutExist(String po_number) {
        String sql = "SELECT count(*) from trx_part_stock_out WHERE ticket_no = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, po_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public TrxPartOutModel getByPoNumb(String ticket_no) {
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
