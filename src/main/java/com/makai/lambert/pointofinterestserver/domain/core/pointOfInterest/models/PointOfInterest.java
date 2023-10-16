package com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String location;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String description;

    @NonNull
    private int rating;



    public String toString() {return String.format("%d %s %s %s %s %d", id, location, city, state, description, rating); }

}
