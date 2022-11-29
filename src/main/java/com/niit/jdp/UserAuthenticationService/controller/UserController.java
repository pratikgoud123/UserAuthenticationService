/*
 * Author Name: Pratik Goud
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticationService.controller;

import com.niit.jdp.UserAuthenticationService.domain.User;
import com.niit.jdp.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.jdp.UserAuthenticationService.service.SecurityTokenGeneratorImpl;
import com.niit.jdp.UserAuthenticationService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    private UserServiceImpl userService;
    private SecurityTokenGeneratorImpl securityTokenGenerator;
    @Autowired
    public UserController(UserServiceImpl userService, SecurityTokenGeneratorImpl securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> insertUser (@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>("user registered successfully", HttpStatus.CREATED);
    }
    @GetMapping("/api/vi/fetchAllUsers")
    public ResponseEntity<?> fetchAllUsers (){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/login")
    public ResponseEntity<?> loginEmployee (@RequestBody User user) throws UserNotFoundException {
        try{
            userService.loginCheck(user.getUsername(), user.getPassword());
            Map<String, String>  secretKey = new HashMap<>();
            secretKey = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(secretKey, HttpStatus.OK);

        }catch(UserNotFoundException ue){
            throw new UserNotFoundException();
        }catch(Exception e){
            return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/api/vi/fetchById/{userId}")
    public ResponseEntity<?> fetchById (@PathVariable int userId){
        return new ResponseEntity<>(userService.getByUserId(userId), HttpStatus.OK);
    }

}