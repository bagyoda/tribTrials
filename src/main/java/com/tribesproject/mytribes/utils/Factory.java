package com.tribesproject.mytribes.utils;

import com.tribesproject.mytribes.buildings.Building;
import com.tribesproject.mytribes.resources.Resource;
import com.tribesproject.mytribes.troops.Troop;

public interface Factory {
  Building createBuilding(String type);
  Resource createResource(String type);
  Troop createTroop(String type);
}
