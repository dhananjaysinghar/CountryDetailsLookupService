package com.identity.controller;

import com.identity.controller.dto.ResponseObject;
import com.identity.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseObject getCountries(@PathVariable String name) {
        return ResponseObject
                .builder()
                .data(locationRepository.findBySortnameLikeIgnoreCase(name))
                .status(HttpStatus.OK.toString())
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseObject findSortNames() {
        return ResponseObject
                .builder()
                .data(locationRepository.findSortNames())
                .status(HttpStatus.OK.toString())
                .build();
    }

}
