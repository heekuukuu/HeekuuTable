package com.example.HeekuuTable.service;

import com.example.HeekuuTable.model.Customer;
import com.example.HeekuuTable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Customer customer = userRepository.findByPhoneNumber(phoneNumber);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found with phone number: " + phoneNumber);
        }

        return new org.springframework.security.core.userdetails.User(
                customer.getPhoneNumber(),
                customer.getPassword(),
                customer.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.name()))
                        .collect(Collectors.toList())
        );
    }
}