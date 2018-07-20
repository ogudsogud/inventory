package com.msg.data.service;

/**
 * Created by yoga.wiguna on 20/07/2018.
 */
public class UserServiceImpl {

    //    @Override
//    public User getByUserPassword(final String username, final String password) {
//
//        try {
//            User user = this.jdbcTemplate.queryForObject("SELECT * FROM t_mtr_user WHERE username = ? and password = ?",
//                    new Object[]{username, password},
//                    new RowMapper<User>() {
//                        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                            User user = new User();
//                            user.setUsername(rs.getString(username));
//                            user.setPassword(rs.getString(password));
//                            return user;
//                        }
//                    });
//            return user;
//        }catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
}
