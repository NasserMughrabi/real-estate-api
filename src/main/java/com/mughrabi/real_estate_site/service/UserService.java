package com.mughrabi.real_estate_site.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mughrabi.real_estate_site.model.Listing;
import com.mughrabi.real_estate_site.model.User;
import com.mughrabi.real_estate_site.repository.ListingRepository;
import com.mughrabi.real_estate_site.repository.UserRepository;

@Component
public class UserService {

    private UserRepository userRepository;
    private ListingRepository listingRepository;

    public UserService(UserRepository userRepository, ListingRepository listingRepository) {
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user == null) {
            System.out.println(user);
            // Add custom exception
        }
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<Listing> getListingsForUser(int userId) {
        // Find user
        Optional<User> user = userRepository.findById(userId);
        if (user == null) {
            System.out.println(user);
            // Add custom exception
        }

        // Find listings for user
        return user.get().getListings();
    }

    public Optional<Listing> getListingForUser(int userId, int listingId) {
        // Find user
        Optional<User> user = userRepository.findById(userId);
        if (user == null) {
            System.out.println(user);
            // Add custom exception
        }

        // Find listing
        Optional<Listing> listing = listingRepository.findById(listingId);
        if (listing == null || !listing.get().getUser().getId().equals(userId)) {
            System.out.println(user);
            // Add custom exception
        }
        return listing;
    }

    public void createListingForUser(int userId, Listing listing) {
        // Find user
        Optional<User> user = userRepository.findById(userId);
        if (user == null) {
            System.out.println(user);
            // Add custom exception
        }

        // update listing to have a user and save to db using repository
        listing.setUser(user.get());
        listingRepository.save(listing);
    }

}
