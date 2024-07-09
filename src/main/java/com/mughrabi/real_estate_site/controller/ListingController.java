package com.mughrabi.real_estate_site.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mughrabi.real_estate_site.model.Listing;
import com.mughrabi.real_estate_site.service.ListingService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://3.212.170.160:3000"}) // Allow requests from localhost (docker)
public class ListingController {

    private ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("/listings")
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }

    @DeleteMapping(path = "/listings/{listing_id}")
    public void deleteListing(@PathVariable int listing_id) {
        listingService.deleteListing(listing_id);
    }
    
}
