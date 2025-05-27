package com.psp.fd.pspspringboot.spring_security.service;

import com.jdbcauth.jdbc.dto.MyUserDetail;
import com.jdbcauth.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetail myUserDetail;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//      Optional<User> user = userRepository.findByUserName(s); //this one
        //return user.map(MyUserDetail::new).get();
        return new MyUserDetail(s);
    }
}
