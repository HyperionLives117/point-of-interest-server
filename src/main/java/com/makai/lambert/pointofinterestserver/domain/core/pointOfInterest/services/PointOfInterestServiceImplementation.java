package com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.services;


import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.models.PointOfInterest;
import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.repos.PointOfInterestRepository;
import com.makai.lambert.pointofinterestserver.domain.exceptions.ResourceCreationException;
import com.makai.lambert.pointofinterestserver.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointOfInterestServiceImplementation implements PointOfInterestService{

    private PointOfInterestRepository pointOfInterestRepository;

    @Autowired
    public PointOfInterestServiceImplementation(PointOfInterestRepository pointOfInterestRepository) {
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    @Override
    public PointOfInterest create(PointOfInterest pointOfInterest) throws ResourceCreationException {
        Optional<PointOfInterest> optional = pointOfInterestRepository.findByLocation(pointOfInterest.getLocation());
        if(optional.isPresent()) {
            throw new ResourceCreationException("Point of interest already exists: " + pointOfInterest.getLocation());
        }
        return pointOfInterestRepository.save(pointOfInterest);
    }

    @Override
    public PointOfInterest getByLocation(String location) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByLocation(location)
                .orElseThrow(() -> new ResourceNotFoundException("No point of interest with location name exists: " + location));
        return pointOfInterest;
    }

    @Override
    public PointOfInterest getByCity(String city) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByCity(city)
                .orElseThrow(() -> new ResourceNotFoundException("No point of interest with city name exists: " + city));
        return pointOfInterest;
    }

    @Override
    public PointOfInterest getByState(String state) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByState(state)
                .orElseThrow(() -> new ResourceNotFoundException("No point of interest with state name exists: " + state));
        return pointOfInterest;
    }

    @Override
    public PointOfInterest getByDescription(String description) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByDescription(description)
                .orElseThrow(() -> new ResourceNotFoundException("No point of interest with description exists: " + description));
        return pointOfInterest;
    }

    @Override
    public PointOfInterest getByRating(Integer rating) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findByRating(rating)
                .orElseThrow(() -> new ResourceNotFoundException("No point of interest with rating exists: " + rating));
        return pointOfInterest;
    }

    @Override
    public PointOfInterest getById(Long id) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = pointOfInterestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No point of interest with id exists: " + id));
        return pointOfInterest;
    }

    @Override
    public List<PointOfInterest> getAll() {
        return pointOfInterestRepository.findAll();
    }

    @Override
    public PointOfInterest update(Long id, PointOfInterest updateDetail) throws ResourceNotFoundException {
        PointOfInterest pointOfInterest = getById(id);
        pointOfInterest.setLocation(updateDetail.getLocation());
        pointOfInterest.setId(updateDetail.getId());
        pointOfInterest.setCity(updateDetail.getCity());
        pointOfInterest.setState(updateDetail.getState());
        pointOfInterest.setDescription(updateDetail.getDescription());
        pointOfInterest.setRating(updateDetail.getRating());
        return pointOfInterest;
    }

    @Override
    public void delete(Long id) {
        PointOfInterest pointOfInterest = getById(id);
        pointOfInterestRepository.delete(pointOfInterest);
    }


}
