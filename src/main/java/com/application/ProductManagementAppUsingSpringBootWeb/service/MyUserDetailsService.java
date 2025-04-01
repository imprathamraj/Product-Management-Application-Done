package com.application.ProductManagementAppUsingSpringBootWeb.service;

import com.application.ProductManagementAppUsingSpringBootWeb.entity.User;
import com.application.ProductManagementAppUsingSpringBootWeb.repository.UserRepository;
import com.application.ProductManagementAppUsingSpringBootWeb.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  // Fixed method name
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return new UserPrincipal(user);
    }
}
