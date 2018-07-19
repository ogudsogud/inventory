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
            partInModel.setTicket_no(rs.getString("ticket_no"));
            partInModel.setId_unit_parts(rs.getString("id_unit_parts"));
            partInModel.setId_unit_institution(rs.getString("id_unit_institution"));
            partInModel.setId_part_number(rs.getString("id_part_number"));
            partInModel.setPart_name(rs.getString("part_name"));
            partInModel.setInstitution_name(rs.getString("institution_name"));
            partInModel.setIns_unit_name(rs.getString("ins_unit_name"));
            partInModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            partInModel.setDescription(rs.getString("description"));
            partInModel.setQuantity_unit(rs.getInt("quantity_unit"));
            partInModel.setBad_part(rs.getString("bad_part"));
            partInModel.setReturned_by(rs.getString("returned_by"));
            partInModel.setReturned_on(rs.getString("returned_on"));
            partInModel.setApproved_by(rs.getString("approved_by"));
            partInModel.setApproved_on(rs.getString("approved_on"));
            partInModel.setStatus(rs.getInt("status"));
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

        String sql = "INSERT INTO trx_part_stock_in (" +
                                "ticket_no," +
                                "id_unit_parts," +
                                "id_unit_institution," +
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
                        "VALUES (?,?,?,?,,,,?,?,?,?,(SELECT NOW()),?,(SELECT NOW()),1)";
        jdbcTemplate.update(sql,
                partInModel.getTicket_no(),
                partInModel.getId_unit_parts(),
                partInModel.getId_unit_institution(),
                partInModel.getId_part_number(),
                partInModel.getPart_name(),
                partInModel.getInstitution_name(),
                partInModel.getIns_unit_name(),
                partInModel.getUnit_parts_name(),
                partInModel.getDescription(),
                partInModel.getQuantity_unit(),
                partInModel.getBad_part(),
                partInModel.getReturned_by(),
//                partInModel.getReturned_on(),
                partInModel.getApproved_by()
//                partInModel.getApproved_on(),
//                partInModel.getStatus()
        );
        return false;
    }

    //jika insert po-parts baru sudah ada
    @Override
    public boolean isPartsInExist(String ticket_no) {
        String sql = "SELECT count(*) from trx_part_stock_in WHERE ticket_no = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, ticket_no);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    //untuk mencari data parts berdasarkan parameter
    @Override
    public PartInModel getByPoNumb(String ticket_no) {
            String sql = "SELECT * FROM trx_part_stock_in WHERE ticket_no = ?";
        RowMapper<PartInModel> rowMapper = new PartsRowMapp();
        PartInModel partInModel = jdbcTemplate.queryForObject(sql, rowMapper, ticket_no);
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
