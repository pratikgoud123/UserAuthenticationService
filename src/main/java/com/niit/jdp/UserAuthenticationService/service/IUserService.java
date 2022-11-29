package com.niit.jdp.UserAuthenticationService.service;

import com.niit.jdp.UserAuthenticationService.domain.User;
import com.niit.jdp.UserAuthenticationService.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User loginCheck(String username, String password) throws UserNotFoundException;
    public Optional<User> getByUserId(int userId) ;
    public boolean deleteUserById (int userId);
}
