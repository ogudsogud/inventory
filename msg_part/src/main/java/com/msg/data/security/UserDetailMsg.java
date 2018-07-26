package com.msg.data.security;

import com.msg.data.model.PrivilageModel;
import com.msg.data.service.PriviligeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */
@Service
public class UserDetailMsg implements UserDetailsService{

    @Autowired
    private PriviligeService priviligeService;
    @Override
    public UserDetails loadUserByUsername(String nik) throws UsernameNotFoundException {
        PrivilageModel roleModel = priviligeService.getNik(nik);
        GrantedAuthority authority = new SimpleGrantedAuthority(roleModel.getRole_access());
        UserDetails userDetails = new User(roleModel.getNik(),
                roleModel.getPasswd(), Arrays.asList(authority));
        return userDetails;
    }


}
