package com.msg.data.service;

import com.msg.data.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */

@Repository
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PartsRowMapp implements RowMapper<UserModel> {


        @Override
        public UserModel mapRow(ResultSet rs, int i) throws SQLException {
            UserModel userModel = new UserModel();
            userModel.setId_mtr_user(rs.getInt("id_mtr_user"));
            userModel.setId_role(rs.getInt("id_role"));
            userModel.setNik(rs.getString("nik"));
            userModel.setName(rs.getString("name"));
            userModel.setEmail(rs.getString("email"));
            userModel.setRole_access(rs.getString("role_access"));
            userModel.setCreated_by(rs.getString("created_by"));
            userModel.setCreated_on(rs.getString("created_on"));
            userModel.setUpdated_by(rs.getString("updated_by"));
            userModel.setUpdated_on(rs.getString("updated_on"));
            userModel.setStatus(rs.getInt("status"));

            return userModel;
        }
    }


    @Override
    public List<UserModel> getUser() {
        String sql = "SELECT " +
                "usr.nik, " +
                "usr.name, " +
                "usr.position, " +
                "usr.email, " +
                "usr.passwd, " +
                "role.role_access, " +
                "usr.created_by, " +
                "usr.created_on, " +
                "usr.updated_by, " +
                "usr.updated_on, " +
                "usr.status " +
                "FROM mtr_user usr " +
                "LEFT JOIN mtr_role role ON role.id_role = usr.id_role " +
                "WHERE usr.status = 1";
        RowMapper<UserModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    @Override
    public boolean insertUser(UserModel userModel) {

        String sql = "INSERT INTO mtr_user (" +
                "                nik," +
                "                name," +
                "                position," +
                "                email," +
                "                passwd," +
                "                id_role," +
                "                created_by," +
                "                created_on," +
                "                updated_by," +
                "                updated_on," +
                "                status)" +
                "                VALUES ( ?,?,?,?,?,?,?,NOW(),?,NOW(),1)";
        jdbcTemplate.update(sql,
                userModel.getNik(),
                userModel.getName(),
                userModel.getPosition(),
                userModel.getEmail(),
                userModel.getPasswd(),
                userModel.getId_role(),
                userModel.getCreated_by(),
//                userModel.getCreated_on(),
                userModel.getUpdated_by()
//                userModel.getUpdated_on(),
//                userModel.getStatus()
        );

        return false;
    }



    @Override
    public boolean isNikExist(String nik, String passwd) {
        String sql = "SELECT COUNT(*) FROM mtr_user WHERE nik = ? AND passwd = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, nik, passwd);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }


        @Override
    public List<UserModel> getNik(String nik) {
        String sql = "SELECT nik FROM mtr_user WHERE nik = ?  AND status = 1";
        RowMapper<UserModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    @Override
    public List<UserModel> getPasswd(String passwd) {
        String sql = "SELECT * FROM mtr_user WHERE passwd = ? AND status = 1";
        RowMapper<UserModel> rowMapper = new PartsRowMapp();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

}
