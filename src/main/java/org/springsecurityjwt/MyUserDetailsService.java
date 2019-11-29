package org.springsecurityjwt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springsecurityjwt.util.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Configuration
@ComponentScan(value = "org.springsecurityjwt.util")
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails users = userRepository.findById(s).orElse(null);
        if(users != null){
            return users;
        }else
            new UsernameNotFoundException("User not found.");
        return null;
    }
}

