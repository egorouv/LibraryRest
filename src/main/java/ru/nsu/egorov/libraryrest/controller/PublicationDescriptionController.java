package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.PublicationDescriptionDTO;
import ru.nsu.egorov.libraryrest.entity.PublicationDescription;
import ru.nsu.egorov.libraryrest.service.PublicationDescriptionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/publication-description")
public class PublicationDescriptionController {

    private final PublicationDescriptionService publicationDescriptionService;

    @PostMapping
    public ResponseEntity<PublicationDescription> create(@RequestBody PublicationDescriptionDTO dto) {
        return new ResponseEntity<>(publicationDescriptionService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublicationDescription>> findAll() {
        return new ResponseEntity<>(publicationDescriptionService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PublicationDescription> update(@RequestBody PublicationDescription publicationDescription) {
        return new ResponseEntity<>(publicationDescriptionService.update(publicationDescription), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        publicationDescriptionService.delete(id);
        return HttpStatus.OK;
    }

}
