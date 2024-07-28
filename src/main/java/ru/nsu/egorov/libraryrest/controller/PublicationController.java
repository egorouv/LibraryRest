package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.PublicationDTO;
import ru.nsu.egorov.libraryrest.entity.Publication;
import ru.nsu.egorov.libraryrest.service.PublicationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationService publicationService;

    @PostMapping
    public ResponseEntity<Publication> create(@RequestBody PublicationDTO dto) {
        return new ResponseEntity<>(publicationService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Publication>> findAll() {
        return new ResponseEntity<>(publicationService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Publication> update(@RequestBody Publication publication) {
        return new ResponseEntity<>(publicationService.update(publication), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        publicationService.delete(id);
        return HttpStatus.OK;
    }

}
