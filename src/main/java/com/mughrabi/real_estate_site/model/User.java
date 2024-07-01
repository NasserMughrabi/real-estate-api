package com.mughrabi.real_estate_site.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Listing> listings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }
}
