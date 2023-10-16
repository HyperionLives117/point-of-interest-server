package com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.repos;

import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.models.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
    Optional<PointOfInterest> findByLocation(String location);

    Optional<PointOfInterest> findByState(String state);

    Optional<PointOfInterest> findByCity(String city);

    Optional<PointOfInterest> findByDescription(String description);

    Optional<PointOfInterest> findByRating(Integer rating);
}
