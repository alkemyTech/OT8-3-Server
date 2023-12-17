package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.UserRequestDTO;
import com.alkemy.wallet.dto.UserResponseDTO;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.wallet.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

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

    public UserResponseDTO updateUser (UserRequestDTO userRequest, String userAuthEmail, Long userId){
        User userAuth = userRepository.findByEmail(userAuthEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if(user.getId().equals(userAuth.getId())) {
            if(userRequest.getFirstName() != null && !userRequest.getFirstName().isBlank()) {
                user.setFirstName(userRequest.getFirstName());
            }
            if(userRequest.getLastName() != null && !userRequest.getLastName().isBlank()) {
                user.setLastName(userRequest.getLastName());
            }
            if(userRequest.getPassword() != null && !userRequest.getPassword().isBlank()) {
                user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            }
            userRepository.save(user);
            return new UserResponseDTO(
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getRole().getUpdateDate()
            );
        } else {throw new IllegalStateException("id no corresponde a la cuenta");}
    }



}
