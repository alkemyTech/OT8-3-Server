package com.alkemy.wallet.service;

import com.alkemy.wallet.config.JwtServiceImpl;
import com.alkemy.wallet.dto.LoginUserRequestDTO;
import com.alkemy.wallet.dto.JwtResponseDTO;
import com.alkemy.wallet.dto.RegisterUserRequestDTO;
import com.alkemy.wallet.enums.RoleEnum;
import com.alkemy.wallet.model.Role;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.repository.RoleRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtServiceImpl jwtService;
    private AuthenticationManager authenticationManager;
    private RoleRepository roleRepository;
    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtServiceImpl jwtService, AuthenticationManager authenticationManager, RoleRepository roleRepository ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
    }


    public JwtResponseDTO registerUser(RegisterUserRequestDTO register){
        User user = new User(
                register.getFirstName(),
                register.getLastName(),
                passwordEncoder.encode(register.getPassword()),
                register.getEmail()
        );
        Role role = roleRepository.findByName(RoleEnum.USER).get();
        user.setRole(role);
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);

        JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
        jwtResponseDTO.setEmail(register.getEmail());
        jwtResponseDTO.setFirstName(register.getFirstName());
        jwtResponseDTO.setLastName(register.getLastName());
        jwtResponseDTO.setToken(jwt);
        return jwtResponseDTO;
    }
    public JwtResponseDTO loginUser (LoginUserRequestDTO login){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
        );
        User user = userRepository.findByEmail(login.getEmail()).orElseThrow(()->new IllegalStateException("no se encontro el usuario"));
        String jwt = jwtService.generateToken(user);
        JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
        jwtResponseDTO.setEmail(login.getEmail());
        jwtResponseDTO.setFirstName(user.getFirstName());
        jwtResponseDTO.setLastName(user.getLastName());
        jwtResponseDTO.setToken(jwt);
        return jwtResponseDTO;
    }
}
