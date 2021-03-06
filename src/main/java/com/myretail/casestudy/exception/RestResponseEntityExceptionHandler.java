package com.myretail.casestudy.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler {
  @ExceptionHandler(ProductNotFoundException.class)
  protected ResponseEntity<String> handleProductNotFoundException(
      ProductNotFoundException productNotFoundException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFoundException.getMessage());
  }

  @ExceptionHandler(JsonFieldNotFoundException.class)
  protected ResponseEntity<String> handleJsonFieldNotFoundException(
      JsonFieldNotFoundException jsonFieldNotFoundException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(jsonFieldNotFoundException.getMessage());
  }

  @ExceptionHandler(JsonParseException.class)
  protected ResponseEntity<String> handleJsonParseException(JsonParseException jsonParseException) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonParseException.getMessage());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  protected ResponseEntity<String> handleIllegalArgumentException(
      IllegalArgumentException illegalArgumentException) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(illegalArgumentException.getMessage());
  }
}
