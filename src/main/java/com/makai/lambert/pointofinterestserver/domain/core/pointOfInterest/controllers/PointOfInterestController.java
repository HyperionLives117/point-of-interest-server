package com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.controllers;

import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.models.PointOfInterest;
import com.makai.lambert.pointofinterestserver.domain.core.pointOfInterest.services.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/poi")
@CrossOrigin("*")
public class PointOfInterestController {


    private PointOfInterestService pointOfInterestService;

    @Autowired
    public PointOfInterestController(PointOfInterestService pointOfInterestService) {
        this.pointOfInterestService = pointOfInterestService;
    }

    @GetMapping
    public ResponseEntity<List<PointOfInterest>> getAll() {
        List<PointOfInterest> pointOfInterests = pointOfInterestService.getAll();
        return new ResponseEntity<>(pointOfInterests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PointOfInterest> create(@RequestBody PointOfInterest pointOfInterest) {
        pointOfInterest = pointOfInterestService.create(pointOfInterest);
        return new ResponseEntity<>(pointOfInterest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PointOfInterest> getById(@PathVariable("id")Long id) {
        PointOfInterest pointOfInterest = pointOfInterestService.getById(id);
        return new ResponseEntity<>(pointOfInterest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<PointOfInterest> getByLocation(@RequestParam String location) {
        PointOfInterest pointOfInterest = pointOfInterestService.getByLocation(location);
        return new ResponseEntity<>(pointOfInterest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PointOfInterest> update(@PathVariable("id") Long id, @RequestBody PointOfInterest poiDetail) {
        poiDetail = pointOfInterestService.update(id, poiDetail);
        return new ResponseEntity<>(poiDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        pointOfInterestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
