package com.msg.data.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailMsg userDetailMsg;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/msg/part-list/**").hasAnyRole("ADMIN","USER")
                .and().formLogin()  //login configuration
                .loginPage("/msg/part-list")
                .loginProcessingUrl("/login")
                .usernameParameter("nik")
                .passwordParameter("password")
                .defaultSuccessUrl("/msg/part-list")
                .and().logout()    //logout configuration
                .logoutUrl("/app-logout")
                .logoutSuccessUrl("/login")
                .and().exceptionHandling() //exception handling configuration
                .accessDeniedPage("/msg/error");
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailMsg).passwordEncoder(passwordEncoder);
    }
}
