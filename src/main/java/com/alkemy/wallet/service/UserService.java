package com.alkemy.wallet.service;

import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.wallet.model.User;

import java.util.List;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}
