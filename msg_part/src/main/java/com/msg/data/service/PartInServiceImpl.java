package com.msg.data.service;


import com.msg.data.model.PartInModel;
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
public class PartInServiceImpl implements PartInService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<PartInModel> {

        @Override
        public PartInModel mapRow(ResultSet rs, int i) throws SQLException {
            PartInModel partInModel = new PartInModel();
            partInModel.setPart_number(rs.getString("ticket_no"));
            partInModel.setPart_name(rs.getString("part_name"));
            partInModel.setPart_number(rs.getString("part_number"));
            partInModel.setTujuan(rs.getString("tujuan"));
            partInModel.setDescription(rs.getString("description"));
            partInModel.setQuantity(rs.getInt("quantity"));
            partInModel.setReturned_by(rs.getString("returned_by"));
            partInModel.setReturned_on(rs.getString("returned_on"));
            partInModel.setApproved_by(rs.getString("approved_by"));
            partInModel.setApproved_on(rs.getString("approved_on"));
            return partInModel;
        }
    }

    //untuk menampilkan data parts stock-in
    @Override
    public List<PartInModel> getPartsStockIn() {
        String sql = "SELECT * FROM trx_part_stock_in";
        RowMapper<PartInModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    //untuk insert parts stock-in
    @Override
    public boolean insertPartsStock(PartInModel partInModel) {

        String sql = "INSERT INTO trx_part_stock_in (ticket_no, part_name, part_number, tujuan, description, quantity, returned_by, returned_on, approved_by, approved_on, status)" +
                "VALUES (?,?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                partInModel.getTicket_no(),
                partInModel.getPart_name(),
                partInModel.getPart_number(),
                partInModel.getTujuan(),
                partInModel.getDescription(),
                partInModel.getQuantity(),
                partInModel.getReturned_by(),
                partInModel.getApproved_by()
        );
        return false;
    }

    //jika insert po-parts baru sudah ada
    @Override
    public boolean isPartsInExist(String po_number) {
        String sql = "SELECT count(*) from trx_part_stock_in WHERE ticket_no = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, po_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    //untuk mencari data parts berdasarkan parameter
    @Override
    public PartInModel getByPoNumb(String po_number) {
        String sql = "SELECT * FROM trx_part_stock_in WHERE ticket_no = ?";
        RowMapper<PartInModel> rowMapper = new PartsRowMapp();
        PartInModel partInModel = jdbcTemplate.queryForObject(sql, rowMapper, po_number);
        return partInModel;
    }

    @Override
    public PartInModel getByPartNumb(String part_number) {
        String sql = "SELECT * FROM trx_part_stock_in WHERE part_number = ?";
        RowMapper<PartInModel> rowMapper = new PartsRowMapp();
        PartInModel partInModel = jdbcTemplate.queryForObject(sql, rowMapper, part_number);
        return partInModel;
    }

}
