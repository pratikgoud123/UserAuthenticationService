/*
 * Author Name: Pratik Goud
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticationService.service;

import com.niit.jdp.UserAuthenticationService.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements ISecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = null;
        jwtToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretKey").compact();

        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message", "User Successfully logged in");
        return map;
    }

}
