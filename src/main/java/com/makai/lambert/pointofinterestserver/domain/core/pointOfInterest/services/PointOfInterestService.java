package com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.services;

import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.models.PointOfInterest;
import com.makai.lambert.pointofinterestserver.domain.exceptions.ResourceCreationException;
import com.makai.lambert.pointofinterestserver.domain.exceptions.ResourceNotFoundException;

import java.util.List;

public interface PointOfInterestService {
    PointOfInterest create(PointOfInterest pointOfInterest) throws ResourceCreationException;

    PointOfInterest getByLocation(String location) throws ResourceNotFoundException;

    PointOfInterest getByCity(String city) throws ResourceNotFoundException;

    PointOfInterest getByState(String state) throws ResourceNotFoundException;

    PointOfInterest getByDescription(String description) throws ResourceNotFoundException;

    PointOfInterest getByRating(Integer rating) throws ResourceNotFoundException;

    PointOfInterest getById(Long id) throws ResourceNotFoundException;

    List<PointOfInterest> getAll();

    PointOfInterest update(Long id, PointOfInterest description) throws ResourceNotFoundException;

    void delete(Long id);




}
