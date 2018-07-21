package com.msg.data.service;

import com.msg.data.model.BrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ogudsogud on 7/21/2018.
 */

@Transactional
@Repository
public class BrandServiceImpl implements BrandService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<BrandModel> {

        @Override
        public BrandModel mapRow(ResultSet rs, int i) throws SQLException {
            BrandModel brandModel = new BrandModel();
            brandModel.setId_brand(rs.getInt("id_brand"));
            brandModel.setBrand_name(rs.getString("brand_name"));
            brandModel.setBase_country(rs.getString("base_country"));
            brandModel.setCreated_by(rs.getString("created_by"));
            brandModel.setCreated_on(rs.getString("created_on"));
            brandModel.setUpdated_by(rs.getString("updated_by"));
            brandModel.setUpdated_on(rs.getString("updated_on"));
            brandModel.setStatus(rs.getInt("status"));
            return brandModel;
        }
    }

    //untuk insert brand
    @Override
    public boolean insertBrand(BrandModel brandModel) {

        String sql = "INSERT INTO mtr_brand (" +
                "brand_name," +
                "base_country," +
                "created_by," +
                "created_on," +
                "updated_by," +
                "updated_on," +
                "status)" +
                "VALUES (?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                brandModel.getBrand_name(),
                brandModel.getBase_country(),
                brandModel.getCreated_by(),
//                brandModel.getCreated_on(),
                brandModel.getUpdated_by()
//                brandModel.getUpdated_on(),
//                brandModel.getStatus()
        );
        return false;
    }

    @Override
    public BrandModel getByIdBrand(String id_brand) {
        String sql = "SELECT * FROM mtr_brand WHERE id_brand = ?";
        RowMapper<BrandModel> rowMapper = new PartsRowMapp();
        BrandModel brandModel = jdbcTemplate.queryForObject(sql, rowMapper, id_brand);
        return brandModel;
    }

}
