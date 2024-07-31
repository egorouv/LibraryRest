package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.LocationRackDTO;
import ru.nsu.egorov.libraryrest.entity.LocationRack;
import ru.nsu.egorov.libraryrest.service.LocationRackService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/location-rack")
public class LocationRackController {

    private final LocationRackService locationRackService;

    @PostMapping
    public ResponseEntity<LocationRack> create(@RequestBody LocationRackDTO dto) {
        return new ResponseEntity<>(locationRackService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LocationRack>> findAll() {
        return new ResponseEntity<>(locationRackService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LocationRack> update(@RequestBody LocationRack locationRack) {
        return new ResponseEntity<>(locationRackService.update(locationRack), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        locationRackService.delete(id);
        return HttpStatus.OK;
    }

}
