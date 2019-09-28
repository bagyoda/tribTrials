package com.tribesproject.mytribes.buildings;

public enum BuildingType {
  ACADEMY {
    @Override
    public Building createNewBuilding() {
      return new Academy();
    }
  },
  FARM {
    @Override
    public Building createNewBuilding() {
      return new Farm();
    }
  },
  MINE {
    @Override
    public Building createNewBuilding() {
      return new Mine();
    }
  },
  TOWNHALL {
    @Override
    public Building createNewBuilding() {
      return new TownHall();
    }
  };
  public abstract Building createNewBuilding();
}
