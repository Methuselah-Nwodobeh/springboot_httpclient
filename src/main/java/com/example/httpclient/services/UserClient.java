package com.example.httpclient.services;


import com.example.httpclient.dto.MultipleUsers;
import com.example.httpclient.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@HttpExchange(url = "/users", accept = "application/json", contentType = "application/json")
public interface UserClient {
    @GetExchange()
    Flux<MultipleUsers> getAll();

  @GetExchange("/{id}")
  Mono<User> getById(@PathVariable("id") Long id);

  @PostExchange("/add")
  Mono<ResponseEntity<Void>> save(@RequestBody User user);

  @PutExchange("/{id}")
  Mono<ResponseEntity<Void>> update(@PathVariable Long id, @RequestBody User user);

  @DeleteExchange("/{id}")
  Mono<ResponseEntity<Void>> delete(@PathVariable Long id);

  @GetExchange("/search")
    Flux<MultipleUsers> searchForUsers(@RequestParam(value = "q") String paramValue);
}
