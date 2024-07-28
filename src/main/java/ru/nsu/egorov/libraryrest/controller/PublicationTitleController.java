package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.PublicationTitleDTO;
import ru.nsu.egorov.libraryrest.entity.PublicationTitle;
import ru.nsu.egorov.libraryrest.service.PublicationTitleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/publication_title")
public class PublicationTitleController {

    private final PublicationTitleService publicationTitleService;

    @PostMapping
    public ResponseEntity<PublicationTitle> create(@RequestBody PublicationTitleDTO dto) {
        return new ResponseEntity<>(publicationTitleService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublicationTitle>> findAll() {
        return new ResponseEntity<>(publicationTitleService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PublicationTitle> update(@RequestBody PublicationTitle publicationTitle) {
        return new ResponseEntity<>(publicationTitleService.update(publicationTitle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(Long id) {
        publicationTitleService.delete(id);
        return HttpStatus.OK;
    }

}
