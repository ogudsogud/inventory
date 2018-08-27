package com.msg.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */

@Repository
@Transactional
public class UserLogServiceImpl implements UserLogService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean isNikExist(String nik, String passwd) {
        String sql = "SELECT COUNT(*) FROM mtr_user WHERE nik = ? and passwd = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, nik, passwd);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }

}
