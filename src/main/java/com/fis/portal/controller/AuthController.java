package com.fis.portal.controller;

import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.User;
import com.fis.portal.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
  @Autowired
  private IAuthService authService;

  @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BaseResponse> authentication(@RequestBody User request) {
    return new ResponseEntity<>(authService.authentication(request), HttpStatus.OK);
  }

  @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BaseResponse> register(@RequestBody User user) {
    return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
  }
}
