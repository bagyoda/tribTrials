package com.tribesproject.mytribes.utils;

import com.tribesproject.mytribes.buildings.Building;
import com.tribesproject.mytribes.buildings.BuildingType;
import com.tribesproject.mytribes.resources.Resource;
import com.tribesproject.mytribes.resources.ResourceType;
import com.tribesproject.mytribes.troops.Troop;
import com.tribesproject.mytribes.troops.TroopType;

public class ProductFactory implements Factory {
  @Override
  public Building createBuilding(String type) {
    return BuildingType.valueOf(type.toUpperCase()).createNewBuilding();
  }

  @Override
  public Resource createResource(String type) {
    return ResourceType.valueOf(type.toUpperCase()).createNewResource();
  }

  @Override
  public Troop createTroop(String type) {
    return TroopType.valueOf(type.toUpperCase()).createNewTroop();
  }
}
