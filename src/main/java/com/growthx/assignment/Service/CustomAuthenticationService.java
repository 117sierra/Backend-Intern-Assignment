package com.growthx.assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationService implements UserDetailsService {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails adminUser = adminAuthenticationService.loadUserByUsername("admin_" + username);
        if (adminUser != null) {
            return adminUser;
        }
        return userAuthenticationService.loadUserByUsername(username);
    }
}
