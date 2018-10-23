package com.msg.data.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by JavaDeveloperZone on 04-08-2017.
 */
@Configuration
@Component
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("datasource")
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .authoritiesByUsernameQuery("select usr.email,role.role_access FROM mtr_user usr LEFT JOIN mtr_role role ON role.id_role = usr.id_role where usr.email = ?")
            .usersByUsernameQuery("select usr.email,usr.password FROM user WHERE email = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();

        http.csrf().disable();

    }
}
