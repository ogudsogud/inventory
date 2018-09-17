package com.msg.data.service;

import com.msg.data.model.LogUserLoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yoga.wiguna on 17/09/2018.
 */

@Repository
@Transactional
public class LogUserLoginServiceImpl implements LogUserLoginService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<LogUserLoginModel> {
        @Override
        public LogUserLoginModel mapRow(ResultSet rs, int i) throws SQLException {
            LogUserLoginModel userLoginModel = new LogUserLoginModel();
            userLoginModel.setId_login(rs.getInt("id_login"));
            userLoginModel.setNik(rs.getString("nik"));
            userLoginModel.setName(rs.getString("name"));
            userLoginModel.setLogin_at(rs.getString("login_at"));
            userLoginModel.setLogout_at(rs.getString("logout_at"));
            userLoginModel.setStatus(rs.getInt("status"));

            return userLoginModel;
        }
    }



    @Override
    public boolean insertLog(String nik) {

        String sql = "INSERT INTO log_user_login (" +
                " nik," +
                " name," +
                " login_at," +
                " status)" +
                " VALUES ( (SELECT nik FROM mtr_user WHERE nik = "+nik+"),(SELECT name FROM mtr_user WHERE nik = "+nik+"),NOW(),1) ";
        jdbcTemplate.update(sql
        );
        return false;
    }



    @Override
    public boolean updateLog(String nik) {
        String sql = "UPDATE log_user_login SET " +
                " logout_at = now()," +
                " status = 0 " +
                " WHERE nik = "+nik+" AND status = 1";
        jdbcTemplate.update(sql
        );
        return false;
    }


    @Override
    public boolean isNikExist(String nik) {
        String sql = "SELECT COUNT(*) FROM log_user_login WHERE nik = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, nik);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
