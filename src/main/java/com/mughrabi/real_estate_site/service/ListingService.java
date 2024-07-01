package com.mughrabi.real_estate_site.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mughrabi.real_estate_site.model.Listing;
import com.mughrabi.real_estate_site.repository.ListingRepository;

@Component
public class ListingService {

    private ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public void deleteListing(int listing_id) {
        listingRepository.deleteById(listing_id);
    }

}
