package com.tribesproject.mytribes.kingdom;

import com.tribesproject.mytribes.appuser.TribeUser;

import javax.persistence.*;

@Entity
@Table(name = "kingdoms")
public class Kingdom {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  private String name;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//  @MapsId
  private TribeUser tribeUser;

//  private List<Building> buildings;

  public Kingdom() {
  }

  public Kingdom(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TribeUser getTribeUser() {
    return tribeUser;
  }

  public void setTribeUser(TribeUser tribeUser) {
    this.tribeUser = tribeUser;
  }
}
