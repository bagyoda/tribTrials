package com.tribesproject.mytribes.kingdom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdomServiceImpl implements KingdomService {

  private KingdomRepository kingdomRepository;

  @Autowired
  public KingdomServiceImpl(KingdomRepository kingdomRepository) {

    this.kingdomRepository = kingdomRepository;
  }

//  public Kingdom saveNewKingdom(Kingdom kingdom) {
//    return kingdomRepository.saveKingdom(kingdom);
//  }

}
