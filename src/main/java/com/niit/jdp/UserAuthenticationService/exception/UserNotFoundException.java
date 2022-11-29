/*
 * Author Name: Pratik Goud
 * Date: 29-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Login failed! Invalid username or password")
public class UserNotFoundException extends Exception{
}
