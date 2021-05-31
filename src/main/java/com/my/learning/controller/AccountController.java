package com.my.learning.controller;

import com.my.learning.entity.Customer;
import com.my.learning.entity.User;
import com.my.learning.service.IEntityService;
import com.my.learning.utility.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    IEntityService<User> userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/authorize")
    public ResponseEntity<Customer> login(@RequestBody User user) {
        Optional<User> userDetail = userService.findByProperty(Helper.getFieldName(user.getUserName(), user), user.getUserName());
        if(!userDetail.isEmpty() && userDetail.isPresent())
        {
            String userPassword = bCryptPasswordEncoder.encode(user.getPassword());
            String dbPassword = userDetail.get().getPassword();

            if(userPassword.equals(dbPassword))
            {
                // generate token
                return null;
            }
        }
        else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return new ResponseEntity<User>(userService.add(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
