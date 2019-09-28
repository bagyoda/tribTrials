package com.tribesproject.mytribes.troops;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@Entity
public abstract class Troop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  protected String type;
  private int level;
  private int hp;
  private int attack;
  private int defence;
  private Date started_at;
  private Date finished_at;

  public Troop() {
    this.level = 1;
    this.hp = 100;
  }
}
