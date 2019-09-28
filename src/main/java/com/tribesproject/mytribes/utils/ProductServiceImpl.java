package com.tribesproject.mytribes.utils;

import com.tribesproject.mytribes.buildings.BuildingRepository;
import com.tribesproject.mytribes.resources.ResourceRepository;
import com.tribesproject.mytribes.troops.TroopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private Factory factory;
  private TroopRepository troopRepository;
  private ResourceRepository resourceRepository;
  private BuildingRepository buildingRepository;

  @Autowired
  public ProductServiceImpl(Factory factory, TroopRepository troopRepository, ResourceRepository resourceRepository, BuildingRepository buildingRepository) {
    this.factory = factory;
    this.troopRepository = troopRepository;
    this.resourceRepository = resourceRepository;
    this.buildingRepository = buildingRepository;
  }

  @Override
  public void addNewBuilding(String type) {
    buildingRepository.save(factory.createBuilding(type));
  }
  @Override
  public void addNewResource(String type) {
    resourceRepository.save(factory.createResource(type));
  }
  @Override
  public void addNewTroop(String type) {
    troopRepository.save(factory.createTroop(type));
  }
}
