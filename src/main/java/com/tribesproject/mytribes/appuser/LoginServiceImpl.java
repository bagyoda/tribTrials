package com.tribesproject.mytribes.appuser;

import com.tribesproject.mytribes.DTOs.StatusResponse;
import com.tribesproject.mytribes.appuser.LoginService;
import com.tribesproject.mytribes.errors.ErrorResponseImpl;
import com.tribesproject.mytribes.appuser.TribeUser;
import com.tribesproject.mytribes.appuser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  private UserRepository userRepository;

  @Autowired
  public LoginServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public ResponseEntity loginUser(TribeUser tribeUser) {

    TribeUser user = userRepository.findUserByUsername(tribeUser.getUsername());
    if ( user != null && tribeUser.getPassword().equals(user.getPassword())) {
      return ResponseEntity.status(200).body(new StatusResponse("ok"));
    } else {
      return givenUserParameterMeasurer(user);
    }
  }

  public ResponseEntity givenUserParameterMeasurer(TribeUser user) {

    if (user == null) {
      return ResponseEntity.status(401).body(new ErrorResponseImpl("error", "Wrong username!"));
    } else {
      return ResponseEntity.status(401).body(new ErrorResponseImpl("error", "Wrong password!"));
    }
  }

  @Override
  public TribeUser findUserByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }
}
