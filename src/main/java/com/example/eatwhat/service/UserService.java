package com.example.eatwhat.service;


import com.example.eatwhat.dao.UserRepository;
import com.example.eatwhat.model.User;
import com.example.eatwhat.model.UserAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(()->new UsernameNotFoundException(username));
    }

    public Optional<User> findUser(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void addAuthority(Long userId, String authority) {
        userRepository.findById(userId).ifPresent(user -> {
            UserAuthority newRole = new UserAuthority(user.getUserId(), authority);
            if (user.getAuthorities() == null) {
                HashSet<UserAuthority> authorities = new HashSet<>();
                authorities.add(newRole);
                user.setAuthorities(authorities);
                save(user);
            } else if (!user.getAuthorities().contains(newRole)) {
                HashSet<UserAuthority> authorities = new HashSet<>();
                authorities.addAll(user.getAuthorities());
                authorities.add(newRole);
                user.setAuthorities(authorities);
                save(user);
            }
        });
    }


}
