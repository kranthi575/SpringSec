package com.example.demo.config;


import com.example.demo.Repo.CustomerRepo;
import com.example.demo.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//this class will take care of loading user from database and compare with user details entered by the user
@Service
@RequiredArgsConstructor
public class CustomizedUserDetailsService implements UserDetailsService {

    //created customer repository :: we can do CRUD operations on customer db.
    //getting customerRepo object
    @Autowired
    CustomerRepo customerRepo;


    //this helps to load the user details from the database and returns the user object.
    //return user object which needs to be authenticated.


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer=customerRepo.findByemail(username);
        List<GrantedAuthority> roles=List.of(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(),customer.getPwd(),roles);
    }
}
