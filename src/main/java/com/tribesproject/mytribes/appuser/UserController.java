package com.tribesproject.mytribes.appuser;

import com.tribesproject.mytribes.DTOs.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

  private RegisterService registerService;
  private LoginService loginService;

  @Autowired
  public UserController(RegisterService registerService, LoginService loginService) {
    this.registerService = registerService;
    this.loginService = loginService;
  }

  @RequestMapping(value = "/register")
  public ResponseEntity registerNewUser(@Valid @RequestBody RegisterDTO registerDTO) {

    try {
        return registerService.createNewUser(registerDTO);
      } catch (Exception e) {
        return ResponseEntity.status(400).body(new Exception(e.getMessage())) ;
      }
  }

  @PostMapping("/login")
  public ResponseEntity loginUser(@Valid @RequestBody TribeUser tribeUser) {
    return loginService.loginUser(tribeUser);
  }
}

