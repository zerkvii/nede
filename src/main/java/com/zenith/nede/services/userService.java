package com.zenith.nede.services;

import com.zenith.nede.Repository.userRepository;
import com.zenith.nede.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@Slf4j
public class userService implements UserDetailsService {

    private final userRepository user_repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public userService(userRepository user_repository, PasswordEncoder passwordEncoder) {
        this.user_repository = user_repository;
        this.passwordEncoder = passwordEncoder;
    }

    public user createUser(user u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return user_repository.save(u);
    }

    public boolean changePassword(user u, String password, String newpassword) {
        if (password == null || newpassword == null || password.isEmpty() || newpassword.isEmpty())
            return false;
        boolean match = passwordEncoder.matches(password, u.getPassword());
        if (!match) return false;
        u.setPassword(passwordEncoder.encode(newpassword));
        user_repository.save(u);
        log.info("User @{} changed password.", u.getUsername());
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
