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
            trxPartInModel.setTicket_no(rs.getString("ticket_no"));
            trxPartInModel.setId_unit_parts(rs.getString("id_unit_parts"));
            trxPartInModel.setId_unit_institution(rs.getString("id_unit_institution"));
            trxPartInModel.setId_part_number(rs.getString("id_part_number"));
            trxPartInModel.setPart_name(rs.getString("part_name"));
            trxPartInModel.setInstitution_name(rs.getString("institution_name"));
            trxPartInModel.setIns_unit_name(rs.getString("ins_unit_name"));
            trxPartInModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            trxPartInModel.setDescription(rs.getString("description"));
            trxPartInModel.setQuantity_unit(rs.getInt("quantity_unit"));
            trxPartInModel.setBad_part(rs.getString("bad_part"));
            trxPartInModel.setReturned_by(rs.getString("returned_by"));
            trxPartInModel.setReturned_on(rs.getString("returned_on"));
            trxPartInModel.setApproved_by(rs.getString("approved_by"));
            trxPartInModel.setApproved_on(rs.getString("approved_on"));
            trxPartInModel.setStatus(rs.getInt("status"));
            return trxPartInModel;
        }
    }

    @Override
    public List<TrxPartInModel> getPartsStockIn() {
        String sql = "SELECT * FROM trx_part_stock_in";
        RowMapper<TrxPartInModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertPartsStock(TrxPartInModel trxPartInModel) {

        String sql = "INSERT INTO trx_part_stock_in (" +
                                "ticket_no," +
//                                "id_unit_parts," +
//                                "id_unit_institution," +
                                "id_part_number," +
                                "part_name," +
                                "institution_name," +
                                "ins_unit_name," +
                                "unit_parts_name," +
                                "description," +
                                "quantity_unit," +
                                "bad_part," +
                                "returned_by," +
                                "returned_on," +
                                "approved_by," +
                                "approved_on," +
                                "status)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                trxPartInModel.getTicket_no(),
                trxPartInModel.getId_unit_parts(),
                trxPartInModel.getId_unit_institution(),
                trxPartInModel.getId_part_number(),
                trxPartInModel.getPart_name(),
                trxPartInModel.getInstitution_name(),
                trxPartInModel.getIns_unit_name(),
                trxPartInModel.getUnit_parts_name(),
                trxPartInModel.getDescription(),
                trxPartInModel.getQuantity_unit(),
                trxPartInModel.getBad_part(),
                trxPartInModel.getReturned_by(),
//                trxPartInModel.getReturned_on(),
                trxPartInModel.getApproved_by()
//                trxPartInModel.getApproved_on(),
//                trxPartInModel.getStatus()
        );
        return false;
    }

   @Override
    public boolean isPartsInExist(String ticket_no) {
        String sql = "SELECT count(*) from trx_part_stock_in WHERE ticket_no = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, ticket_no);
       return count == 0;
    }

    @Override
    public TrxPartInModel getTicketNo(String ticket_no) {
        String sql = "SELECT * FROM trx_part_stock_in WHERE ticket_no = ?";
        RowMapper<TrxPartInModel> rowMapper = new PartsRowMapp();
        TrxPartInModel trxPartInModel = jdbcTemplate.queryForObject(sql, rowMapper, ticket_no);
        return trxPartInModel;
    }

    @Override
    public TrxPartInModel getByPartNumb(String id_part_number) {
        String sql = "SELECT * FROM trx_part_stock_in WHERE id_part_number = ?";
        RowMapper<TrxPartInModel> rowMapper = new PartsRowMapp();
        TrxPartInModel trxPartInModel = jdbcTemplate.queryForObject(sql, rowMapper, id_part_number);
        return trxPartInModel;
    }

}
