package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.LocationHallDTO;
import ru.nsu.egorov.libraryrest.entity.LocationHall;
import ru.nsu.egorov.libraryrest.service.LocationHallService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/location_hall")
public class LocationHallController {

    private final LocationHallService locationHallService;

    @PostMapping
    public ResponseEntity<LocationHall> create(@RequestBody LocationHallDTO dto) {
        return new ResponseEntity<>(locationHallService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LocationHall>> findAll() {
        return new ResponseEntity<>(locationHallService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LocationHall> update(@RequestBody LocationHall locationHall) {
        return new ResponseEntity<>(locationHallService.update(locationHall), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        locationHallService.delete(id);
        return HttpStatus.OK;
    }

}
