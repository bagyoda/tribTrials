package com.tribesproject.mytribes.buildings;

import com.tribesproject.mytribes.kingdom.Kingdom;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public abstract class Building {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  protected String type;
  private int level;
  protected int hp;
  @ManyToOne
  private Kingdom kingdom;

  public Building() {
    this.level = 1;
  }
}
