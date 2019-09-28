package com.tribesproject.mytribes.appuser;

import com.tribesproject.mytribes.appuser.TribeUser;
import org.springframework.http.ResponseEntity;

public interface LoginService {

  ResponseEntity loginUser(TribeUser tribeUser);
  TribeUser findUserByUsername(String username);
}
