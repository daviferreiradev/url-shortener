package com.example.urlshortener.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.urlshortener.dto.LoginRequestDTO;
import com.example.urlshortener.dto.RegisterRequestDTO;
import com.example.urlshortener.dto.ResponseDTO;
import com.example.urlshortener.exception.UserAlreadyExistsException;
import com.example.urlshortener.exception.UserNotFoundException;
import com.example.urlshortener.infra.security.TokenService;
import com.example.urlshortener.model.User;
import com.example.urlshortener.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final TokenService tokenService;

  public ResponseDTO login(LoginRequestDTO body) {
    User user = repository.findByEmail(body.email())
        .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

    if (!passwordEncoder.matches(body.password(), user.getPassword())) {
      throw new IllegalArgumentException("Credenciais inválidas");
    }

    String token = tokenService.generateToken(user);
    return new ResponseDTO(user.getName(), token);
  }

  public ResponseDTO register(RegisterRequestDTO body) {
    if (repository.findByEmail(body.email()).isPresent()) {
      throw new UserAlreadyExistsException("Usuário já existe");
    }

    User newUser = new User();
    newUser.setName(body.name());
    newUser.setEmail(body.email());
    newUser.setPassword(passwordEncoder.encode(body.password()));
    repository.save(newUser);

    String token = tokenService.generateToken(newUser);
    return new ResponseDTO(newUser.getName(), token);
  }
}
