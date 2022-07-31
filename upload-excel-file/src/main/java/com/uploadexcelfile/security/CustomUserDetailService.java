package com.uploadexcelfile.security;

import com.uploadexcelfile.entities.User;
import com.uploadexcelfile.exceptions.ResourceNotFoundException;
import com.uploadexcelfile.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loading user from database by name
        User user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException(
                "username ", "User name", username));

        return user;
    }
}
