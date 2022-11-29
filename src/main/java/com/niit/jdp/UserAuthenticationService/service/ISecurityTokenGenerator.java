package com.niit.jdp.UserAuthenticationService.service;

import com.niit.jdp.UserAuthenticationService.domain.User;

import java.util.Map;

public interface ISecurityTokenGenerator {

    Map<String, String> generateToken (User user);

}
