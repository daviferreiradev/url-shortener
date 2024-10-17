package com.example.urlshortener.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.service.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {
  @Autowired
  private UrlService urlService;

  @PostMapping("/shorten")
  public ResponseEntity<Url> shortenUrl(@RequestParam String url, @RequestParam(required = false) LocalDateTime expirationDate) {
    Url shortUrl = urlService.generateShortUrl(url, expirationDate);
    return ResponseEntity.ok(shortUrl);
  }

  @GetMapping("/{shortUrl}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortUrl) {
        Optional<Url> optionalUrl = urlService.getOriginalUrl(shortUrl);
        if (optionalUrl.isPresent()) {
            Url url = optionalUrl.get();
            if (url.getExpirationDate() == null || url.getExpirationDate().isAfter(LocalDateTime.now())) {
                return new RedirectView(url.getOriginalUrl());
            } else {
                throw new RuntimeException("URL expirada");
            }
        } else {
            throw new RuntimeException("URL não encontrada");
        }
    }
}
