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
            trxPartOutModel.setPart_name(rs.getString("id_unit_parts"));
            trxPartOutModel.setPart_name(rs.getString("id_unit_institution"));
            trxPartOutModel.setPart_name(rs.getString("id_part_number"));
            trxPartOutModel.setPart_name(rs.getString("part_name"));
            trxPartOutModel.setPart_name(rs.getString("institution_name"));
            trxPartOutModel.setIns_unit_name(rs.getString("ins_unit_name"));
            trxPartOutModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            trxPartOutModel.setDescription(rs.getString("description"));
            trxPartOutModel.setQuantity_unit(rs.getInt("quantity_unit"));
            trxPartOutModel.setRequested_by(rs.getString("requested_by"));
            trxPartOutModel.setRequested_on(rs.getString("requested_on"));
            trxPartOutModel.setApproved_by(rs.getString("approved_by"));
            trxPartOutModel.setApproved_on(rs.getString("approved_on"));
            trxPartOutModel.setUpdated_by(rs.getString("updated_by"));
            trxPartOutModel.setUpdated_on(rs.getString("updated_on"));
            trxPartOutModel.setStatus(rs.getInt("status"));
            return trxPartOutModel;
        }
    }

    @Override
    public List<TrxPartOutModel> getPartsStockOut() {
        String sql = "SELECT * FROM trx_part_stock_out WHERE status = 1";
        RowMapper<TrxPartOutModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsOut(TrxPartOutModel trxPartOutModel) {

        String sql = "INSERT INTO trx_part_stock_out (" +
                "ticket_no," +
                "id_part_number, " +
                "part_name, " +
                "institution_name, " +
                "ins_unit_name,  " +
                "unit_parts_name, " +
                "description, " +
                "quantity_unit, " +
                "requested_by, " +
                "requested_on, " +
                "approved_by, " +
                "approved_on, " +
                "updated_by, " +
                "updated_on, " +
                "status) " +

                "VALUES (?,?,?,?,?,?,?,?,?,NOW(),?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                trxPartOutModel.getTicket_no(),
                trxPartOutModel.getId_part_number(),
                trxPartOutModel.getPart_name(),
                trxPartOutModel.getInstitution_name(),
                trxPartOutModel.getIns_unit_name(),
                trxPartOutModel.getUnit_parts_name(),
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
