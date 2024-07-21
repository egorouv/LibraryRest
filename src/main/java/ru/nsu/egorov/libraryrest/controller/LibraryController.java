package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.LibraryDTO;
import ru.nsu.egorov.libraryrest.entity.Library;
import ru.nsu.egorov.libraryrest.service.LibraryService;

import java.util.List;

@RestController
@AllArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> create(@RequestBody LibraryDTO dto) {
        return new ResponseEntity<>(libraryService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/library")
    public ResponseEntity<List<Library>> findAll() {
        return new ResponseEntity<>(libraryService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Library> update(@RequestBody Library library) {
        return new ResponseEntity<>(libraryService.update(library), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        libraryService.delete(id);
        return HttpStatus.OK;
    }

}
