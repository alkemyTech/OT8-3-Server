package com.alkemy.wallet.controller;

import com.alkemy.wallet.dto.AccountUpdateDTO;
import com.alkemy.wallet.dto.AccountUpdateResponseDTO;
import com.alkemy.wallet.dto.UserRequestDTO;
import com.alkemy.wallet.dto.UserResponseDTO;
import com.alkemy.wallet.model.User;
import com.alkemy.wallet.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> get() {
        List<User> userList = this.userService.findAll();

        return userList.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        try {
            User user = this.userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO>updateUser(@RequestBody UserRequestDTO userRequest, @PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.userService.updateUser(userRequest, authentication.getName(),id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            this.userService.softDeleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}