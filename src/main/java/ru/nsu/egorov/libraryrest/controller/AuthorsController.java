package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.AuthorsDTO;
import ru.nsu.egorov.libraryrest.entity.Authors;
import ru.nsu.egorov.libraryrest.service.AuthorsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsService authorsService;

    @PostMapping
    public ResponseEntity<Authors> create(@RequestBody AuthorsDTO dto) {
        return new ResponseEntity<>(authorsService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Authors>> findAll() {
        return new ResponseEntity<>(authorsService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Authors> update(@RequestBody Authors authors) {
        return new ResponseEntity<>(authorsService.update(authors), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(Long id) {
        authorsService.delete(id);
        return HttpStatus.OK;
    }

}
