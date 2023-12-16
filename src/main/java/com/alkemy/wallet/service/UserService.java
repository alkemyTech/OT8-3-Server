package com.alkemy.wallet.service;

import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.wallet.model.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findBySoftDeleteNot(true);
    }

    public void softDeleteById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.get().getSoftDelete().equals(true)){
            throw new EntityNotFoundException("User not found");
        }
        user.get().setSoftDelete(true);
        this.userRepository.save(user.get());
    }

    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isEmpty()){
            throw new EntityNotFoundException("User not found");
        }
        if(user.get().getSoftDelete().equals(true)){
            throw new EntityNotFoundException("User not found");
        }
        return user.get();
    }

}
