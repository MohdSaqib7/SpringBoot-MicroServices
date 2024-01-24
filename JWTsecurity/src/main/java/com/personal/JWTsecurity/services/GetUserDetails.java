package com.personal.JWTsecurity.services;

import org.springframework.stereotype.Service;

@Service
public class GetUserDetails {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equals("Saqib")){
            return new User("Saqib","ivy@123", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User Not found");
        }
    }
}
