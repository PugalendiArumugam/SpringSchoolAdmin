package com.nexusai.SchoolAppSpring.service;

import com.nexusai.SchoolAppSpring.model.UserPrincipal;
import com.nexusai.SchoolAppSpring.model.Users;
import com.nexusai.SchoolAppSpring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found-exception");
        } else {
            System.out.println("User found !! ->"+username);
        }

        return new UserPrincipal(user);
    }


}
