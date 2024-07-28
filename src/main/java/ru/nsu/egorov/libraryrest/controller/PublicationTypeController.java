package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.PublicationTypeDTO;
import ru.nsu.egorov.libraryrest.entity.PublicationType;
import ru.nsu.egorov.libraryrest.service.PublicationTypeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/publication_type")
public class PublicationTypeController {

    private final PublicationTypeService publicationTypeService;

    @PostMapping
    public ResponseEntity<PublicationType> create(@RequestBody PublicationTypeDTO dto) {
        return new ResponseEntity<>(publicationTypeService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublicationType>> findAll() {
        return new ResponseEntity<>(publicationTypeService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PublicationType> update(@RequestBody PublicationType publicationType) {
        return new ResponseEntity<>(publicationTypeService.update(publicationType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        publicationTypeService.delete(id);
        return HttpStatus.OK;
    }

}
