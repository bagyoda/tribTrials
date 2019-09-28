package com.tribesproject.mytribes.errors;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponseImpl implements ErrorResponse {

  private String status;
  private String message;

  public ErrorResponseImpl() {
  }

  public ErrorResponseImpl(String message) {
    this.status = "error";
    this.message = message;
  }

  public ErrorResponseImpl(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public ErrorResponseImpl usernameTaken() {
    return new ErrorResponseImpl("error","Username already taken, please choose an other one.");
  }

  @Override
  public ErrorResponseImpl saveFailure(Exception e) {
    String message = "Unsuccesful saving attempt. " + e.getMessage();
    return new ErrorResponseImpl("error", message);
  }

  @Override
  public ErrorResponseImpl saveKingdomFailure(Exception e) {
    String message = "Could not create Kingdom. " + e.getMessage();
    return new ErrorResponseImpl("error", message);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
