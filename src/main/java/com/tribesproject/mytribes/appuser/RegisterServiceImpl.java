package com.tribesproject.mytribes.appuser;

import com.tribesproject.mytribes.DTOs.RegisterDTO;
import com.tribesproject.mytribes.DTOs.RegisterResponseDTO;
import com.tribesproject.mytribes.appuser.RegisterService;
import com.tribesproject.mytribes.errors.ErrorResponse;
import com.tribesproject.mytribes.kingdom.Kingdom;
import com.tribesproject.mytribes.appuser.TribeUser;
import com.tribesproject.mytribes.kingdom.KingdomRepository;
import com.tribesproject.mytribes.appuser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class RegisterServiceImpl implements RegisterService {

  private UserRepository userRepository;
  private KingdomRepository kingdomRepository;
  private ErrorResponse errorResponse;


  @Autowired
  public RegisterServiceImpl(UserRepository userRepository, KingdomRepository kingdomRepository, ErrorResponse errorResponse) {
    this.userRepository = userRepository;
    this.kingdomRepository = kingdomRepository;
    this.errorResponse = errorResponse;
  }

  @Override
  public ResponseEntity createNewUser(RegisterDTO registerDTO) throws Exception {
    try {
      if (occupiedUserName(registerDTO)) {
        return ResponseEntity.status(400).body(errorResponse.usernameTaken());
      } else {
        TribeUser newUser = new TribeUser(registerDTO.getUsername(), registerDTO.getPassword());
        Kingdom kingdom = configureKingdom(registerDTO, newUser);
        userRepository.save(newUser);
        return ResponseEntity.status(200).body(new RegisterResponseDTO(newUser, kingdom.getId()));
      }
    } catch (Exception e) {
      throw new Exception("Unsuccesful saving attepmt. Message: " + e.getMessage());
    }
  }

  private Kingdom configureKingdom(RegisterDTO registerDTO, TribeUser newUser) throws Exception {
    TribeUser user = newUser;
    Kingdom newKingdom = new Kingdom(registerDTO.getKingdom()) ;
    if (StringUtils.isEmpty(registerDTO.getKingdom())
        || registerDTO.getKingdom() == null || registerDTO.getKingdom().length() < 1) {
      newKingdom.setName(registerDTO.getUsername() + "'s kingdom");
    }
    try {
        newKingdom.setTribeUser(newUser);
        return kingdomRepository.save(newKingdom);
    } catch (Exception e) {
     throw new Exception("Could not create Kingdom. Message: " + e.getMessage());
    }
  }

  private boolean occupiedUserName(RegisterDTO registerDTO){
    TribeUser tribeUser = userRepository.findUserByUsername(registerDTO.getUsername());
    if (tribeUser != null && tribeUser.getUsername().equals(registerDTO.getUsername())){
      return true;
    }
    return false;
  }

}
