package com.msg.data.service;

import com.msg.data.model.PartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ogudsogud on 7/7/2018.
 */

@Transactional
@Repository
public class PartsServiceImpl implements PartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<PartsModel> {

        @Override
        public PartsModel mapRow(ResultSet rs, int i) throws SQLException {
            PartsModel partsModel = new PartsModel();
            partsModel.setId_part(rs.getInt("id_part"));
            partsModel.setPart_name(rs.getString("part_name"));
            partsModel.setPart_number(rs.getString("part_number"));
            partsModel.setBrand_name(rs.getString("brand_name"));
            partsModel.setQuantity(rs.getInt("quantity"));
            partsModel.setCreated_by(rs.getString("created_by"));
            partsModel.setCreated_on(rs.getString("created_on"));
            partsModel.setUpdated_by(rs.getString("updated_by"));
            partsModel.setUpdated_on(rs.getString("updated_on"));
            partsModel.setStatus(rs.getInt("status"));

            return partsModel;
        }
    }

    //untuk insert parts
    @Override
    public boolean insertParts(PartsModel partsModel) {

        String sql = "INSERT INTO mtr_parts (part_name, part_number, brand_name, quantity, created_by, created_on, updated_by, updated_on,status)" +
                "VALUES (?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                partsModel.getPart_name(),
                partsModel.getPart_number(),
                partsModel.getBrand_name(),
                partsModel.getQuantity(),
                partsModel.getCreated_by(),
//                partsModel.getCreated_on(),
                partsModel.getUpdated_by()
//                partsModel.getUpdated_on(),
//                partsModel.getStatus()
 );

        return false;
    }

    //jika parts sudah ada
    @Override
    public boolean isPartsExist(String part_number) {
        String sql = "SELECT count(*) from mtr_parts WHERE part_number = ? ";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, part_number);
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
