package com.tribesproject.mytribes.DTOs;

import javax.validation.constraints.NotNull;

public class RegisterDTO {

  @NotNull(message = "Please provide a name")
  private String username;
  @NotNull(message = "Please provide a name")
  private String password;
  private String kingdom;

  public RegisterDTO() {
  }

  public RegisterDTO(String username, String password, String kingdom) {
    this.username = username;
    this.password = password;
    this.kingdom = kingdom;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getKingdom() {
    return kingdom;
  }

  public void setKingdom(String kingdom) {
    this.kingdom = kingdom;
  }
}
