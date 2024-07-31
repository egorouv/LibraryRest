package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.LibraryWorkersDTO;
import ru.nsu.egorov.libraryrest.entity.LibraryWorkers;
import ru.nsu.egorov.libraryrest.service.LibraryWorkersService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/library-workers")
public class LibraryWorkersController {

    private final LibraryWorkersService libraryWorkersService;

    @PostMapping
    public ResponseEntity<LibraryWorkers> create(@RequestBody LibraryWorkersDTO dto) {
        return new ResponseEntity<>(libraryWorkersService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LibraryWorkers>> findAll() {
        return new ResponseEntity<>(libraryWorkersService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LibraryWorkers> update(@RequestBody LibraryWorkers libraryWorkers) {
        return new ResponseEntity<>(libraryWorkersService.update(libraryWorkers), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        libraryWorkersService.delete(id);
        return HttpStatus.OK;
    }

}
