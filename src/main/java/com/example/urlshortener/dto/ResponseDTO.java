package com.example.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotBlank(message = "Token cannot be blank")
  private String token;
}
