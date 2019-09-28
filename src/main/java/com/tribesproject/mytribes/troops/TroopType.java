package com.tribesproject.mytribes.troops;

public enum TroopType {
  SWORDSMEN {
    @Override
    public Swordsmen createNewTroop() {
      return new Swordsmen();
    }
  };
  public abstract Troop createNewTroop();
}
