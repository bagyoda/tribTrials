package com.tribesproject.mytribes.errors;

public interface ErrorResponse {
  ErrorResponseImpl usernameTaken();
  ErrorResponseImpl saveFailure(Exception e);
  ErrorResponseImpl saveKingdomFailure(Exception e);

}
