package com.mughrabi.real_estate_site.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mughrabi.real_estate_site.model.Listing;
import com.mughrabi.real_estate_site.model.User;
import com.mughrabi.real_estate_site.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost (docker)
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping(path = "/users/{id}/listings")
    public List<Listing> getListingsForUser(@PathVariable int id) {
        return userService.getListingsForUser(id);
    }

    @GetMapping(path = "/users/{user_id}/listings/{listing_id}")
    public Optional<Listing> getListingForUser(@PathVariable int user_id, @PathVariable int listing_id) {
        return userService.getListingForUser(user_id, listing_id);
    }

    @PostMapping(path = "/users/{user_id}/listings")
    public void createListingForUser(@PathVariable int user_id, @RequestBody Listing listing) {
        userService.createListingForUser(user_id, listing);
    }

}
