package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.LocationShelfDTO;
import ru.nsu.egorov.libraryrest.entity.LocationShelf;
import ru.nsu.egorov.libraryrest.service.LocationShelfService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/location-shelf")
public class LocationShelfController {

    private final LocationShelfService locationShelfService;

    @PostMapping
    public ResponseEntity<LocationShelf> create(@RequestBody LocationShelfDTO dto) {
        return new ResponseEntity<>(locationShelfService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LocationShelf>> findAll() {
        return new ResponseEntity<>(locationShelfService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LocationShelf> update(@RequestBody LocationShelf locationShelf) {
        return new ResponseEntity<>(locationShelfService.update(locationShelf), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        locationShelfService.delete(id);
        return HttpStatus.OK;
    }

}
