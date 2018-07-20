package com.msg.data.service;

import com.msg.data.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoga.wiguna on 20/07/2018.
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<UserModel> {

        @Override
        public UserModel mapRow(ResultSet rs, int i) throws SQLException {
            UserModel userModel = new UserModel();
            userModel.setNik(rs.getString("nik"));
            userModel.setName(rs.getString("name"));
            userModel.setPosition(rs.getString("position"));
            userModel.setEmail(rs.getString("email"));
            userModel.setPassword(rs.getString("password"));
            userModel.setCreated_by(rs.getString("created_by"));
            userModel.setCreated_on(rs.getString("created_on"));
            userModel.setUpdated_by(rs.getString("updated_by"));
            userModel.setUpdated_on(rs.getString("updated_on"));
            userModel.setStatus(rs.getInt("status"));

            return userModel;
        }
    }


        @Override
    public UserModel getByNikPassword(final String nik, final String password) {

        try {
            UserModel userModel = this.jdbcTemplate.queryForObject("SELECT * FROM mtr_user WHERE nik = ? and password = ?",
                    new Object[]{nik, password},
                    new RowMapper<UserModel>() {
                        public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                            UserModel user = new UserModel();
                            user.setNik(rs.getString(nik));
                            user.setPassword(rs.getString(password));
                            return user;
                        }
                    });
            return userModel;
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
