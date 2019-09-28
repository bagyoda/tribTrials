package com.tribesproject.mytribes.appuser;

import com.tribesproject.mytribes.DTOs.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
  ResponseEntity createNewUser(RegisterDTO registerDTO) throws Exception;
}
