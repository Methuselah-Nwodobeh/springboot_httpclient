package com.example.httpclient.controllers;


import com.example.httpclient.dto.MultipleUsers;
import com.example.httpclient.dto.User;
import com.example.httpclient.services.UserClient;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {
    private final UserClient userClient;

    @GetMapping("/{id}")
    @Operation(summary = "Get a single user")
    public Mono<User> get(@PathVariable("id") Long id){
        return userClient.getById(id);
    }

    @GetMapping()
    @Operation(summary = "Get all users ")
    public Flux<MultipleUsers> getALl(){
        return userClient.getAll();
    }

    @PostMapping()
    @Operation(summary = "Create a new user")
    public Mono<ResponseEntity<Void>> create(@RequestBody User user){
        return userClient.save(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user's details")
    Mono<ResponseEntity<Void>> update(@PathVariable Long id, @RequestBody User user){
        return userClient.update(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return userClient.delete(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search for a user")
    Flux<MultipleUsers> search(@RequestParam(value = "q") String paramValue){
        return userClient.searchForUsers(paramValue);
    }
}
