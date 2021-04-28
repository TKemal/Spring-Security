package com.tihic.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomRestourantDetailsService implements UserDetailsService {
    
    @Autowired
    private RestaurantRepository repository;
   

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User restaurant = (User) repository.findAll();
        if(restaurant == null){
        throw new UnsupportedOperationException("Not supported yet."); 
        }
        return new CustomRestourantDetails(restaurant);
    }
    
    public UserDetails findAll(){
        List allRest = repository.findAll();
        return (UserDetails) allRest;
    }
}
