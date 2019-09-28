package com.tribesproject.mytribes.resources;

public enum ResourceType {
  COAL {
    @Override
    public Resource createNewResource() {
      return new Coal();
    }
  },
  WOOD {
    @Override
    public Resource createNewResource() {
      return new Wood();
    }
  };
  public abstract Resource createNewResource();
}
