package com.tribesproject.mytribes.resources;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public abstract class Resource {

  @Id
  @GeneratedValue
  private long id;
  protected String type;
  protected int amount;
  private int generation;

  public Resource() {
    this.generation = 1;
  }
}
