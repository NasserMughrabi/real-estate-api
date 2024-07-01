package com.mughrabi.real_estate_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mughrabi.real_estate_site.model.Listing;


public interface ListingRepository extends JpaRepository<Listing, Integer>{
    
}
