package com.rakoi.webapp.classeye.classeye.Services;

import com.rakoi.webapp.classeye.classeye.Entities.User;
import com.rakoi.webapp.classeye.classeye.repos.RoleRepository;
import com.rakoi.webapp.classeye.classeye.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetails implements UserDetailsService {

    //test
    @Autowired
    UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(s);
        if(user==null){

            throw  new UsernameNotFoundException(user.getUsername());
        }else{
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getRoles());

        }

    }
}
