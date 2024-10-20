package com.example.urlshortener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortener.dto.LoginRequestDTO;
import com.example.urlshortener.dto.RegisterRequestDTO;
import com.example.urlshortener.dto.ResponseDTO;
import com.example.urlshortener.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
    ResponseDTO response = authService.login(body);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/register")
  public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
    ResponseDTO response = authService.register(body);
    return ResponseEntity.ok(response);
  }
}
