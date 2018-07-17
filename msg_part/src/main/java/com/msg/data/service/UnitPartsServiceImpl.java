package com.msg.data.service;

import com.msg.data.model.UnitPartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoga.wiguna on 13/07/2018.
 */
public class UnitPartsServiceImpl implements UnitPartsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<UnitPartsModel> {

        @Override
        public UnitPartsModel mapRow(ResultSet rs, int i) throws SQLException {
            UnitPartsModel unitPartsModel = new UnitPartsModel();
            unitPartsModel.setId_unit_parts(rs.getInt("id_unit_parts"));
            unitPartsModel.setUnit_parts_name(rs.getString("unit_parts_name"));
            unitPartsModel.setCreated_by(rs.getString("created_by"));
            unitPartsModel.setCreated_on(rs.getString("created_on"));
            unitPartsModel.setUpdated_by(rs.getString("updated_by"));
            unitPartsModel.setUpdated_on(rs.getString("updated_on"));
            unitPartsModel.setStatus(rs.getInt("status"));

            return unitPartsModel;
        }
    }

}
