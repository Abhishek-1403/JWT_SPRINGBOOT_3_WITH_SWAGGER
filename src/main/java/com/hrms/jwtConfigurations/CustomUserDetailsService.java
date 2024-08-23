package com.hrms.jwtConfigurations;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserRepository userRepository; // Assuming you have a User entity and repository
//	@Autowired
//	PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    	
    	

        return new org.springframework.security.core.userdetails.User("Abhishek","$2a$12$KDDy/.yCyXM4PFKxcGPSjOhcL3siacSQHFXlU6PERXWtexLtUTyze",
                new ArrayList<>()); // Add roles if you have them
    }
}

