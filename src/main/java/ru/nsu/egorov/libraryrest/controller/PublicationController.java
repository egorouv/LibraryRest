package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.PublicationDTO;
import ru.nsu.egorov.libraryrest.entity.Publication;
import ru.nsu.egorov.libraryrest.service.PublicationService;

import java.util.Date;
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

    @GetMapping("/date-from-lib")
    public ResponseEntity<List<Publication>> findPublicationByDateFromLibrary(
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate,
            @RequestParam Integer reader) {
        return new ResponseEntity<>(publicationService.
                findPublicationByDateFromLibrary(startDate, endDate, reader),
                HttpStatus.OK);
    }

    @GetMapping("/date-not-from-lib")
    public ResponseEntity<List<Publication>> findPublicationByDateNotFromLibrary(
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate,
            @RequestParam Integer reader) {
        return new ResponseEntity<>(publicationService.
                findPublicationByDateNotFromLibrary(startDate, endDate, reader),
                HttpStatus.OK);
    }

    @GetMapping("/library")
    public ResponseEntity<List<Publication>> findPublicationByLibrary(
            @RequestParam Integer library,
            @RequestParam Integer shelf) {
        return new ResponseEntity<>(publicationService.findPublicationByLibrary(library, shelf), HttpStatus.OK);
    }

    @GetMapping("/replenishment")
    public ResponseEntity<List<Publication>> findReplenishmentByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate) {
        return new ResponseEntity<>(publicationService.findReplenishmentByDate(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/write-off")
    public ResponseEntity<List<Publication>> findWriteOffByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate) {
        return new ResponseEntity<>(publicationService.findWriteOffByDate(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Publication>> findPublicationByTitle(@RequestParam String title) {
        return new ResponseEntity<>(publicationService.findPublicationByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Publication>> findPublicationByAuthor(
            @RequestParam String name, @RequestParam String surname) {
        return new ResponseEntity<>(publicationService.findPublicationByAuthor(name, surname), HttpStatus.OK);
    }

}
