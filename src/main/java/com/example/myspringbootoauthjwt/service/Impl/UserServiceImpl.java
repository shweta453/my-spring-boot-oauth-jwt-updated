package com.example.myspringbootoauthjwt.service.Impl;

import com.example.myspringbootoauthjwt.entity.User;
import com.example.myspringbootoauthjwt.model.UserDao;
import com.example.myspringbootoauthjwt.repository.UserRepository;
import com.example.myspringbootoauthjwt.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(UserDao userDao) {
        User user = User.builder()
                .username(userDao.getUsername())
                .password(bCryptPasswordEncoder.encode(userDao.getPassword()))
                .roles(userDao.getRoles())
                .build();
        user = userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Invalid username or password!");
        }
        return new UserDetailsImpl(user);
    }
}
