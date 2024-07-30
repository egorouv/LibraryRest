package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.ReadersDTO;
import ru.nsu.egorov.libraryrest.entity.Readers;
import ru.nsu.egorov.libraryrest.service.ReadersService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/readers")
public class ReadersController {

    private final ReadersService readersService;

    @PostMapping
    public ResponseEntity<Readers> create(@RequestBody ReadersDTO dto) {
        return new ResponseEntity<>(readersService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Readers>> findAll() {
        return new ResponseEntity<>(readersService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Readers> update(@RequestBody Readers readers) {
        return new ResponseEntity<>(readersService.update(readers), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        readersService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/category")
    public ResponseEntity<List<Readers>> findReadersByCategory(@RequestParam String category) {
        return new ResponseEntity<>(readersService.findReadersByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Readers>> findReadersByTitle(@RequestParam String title) {
        return new ResponseEntity<>(readersService.findReadersByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Readers>> findReadersByType(@RequestParam String type) {
        return new ResponseEntity<>(readersService.findReadersByType(type), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Readers>> findReadersByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate) {
        return new ResponseEntity<>(readersService.findReadersByDate(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/worker")
    public ResponseEntity<List<Readers>> findReadersByWorker(
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate,
            @RequestParam Integer worker) {
        return new ResponseEntity<>(readersService.findReadersByWorker(startDate, endDate, worker), HttpStatus.OK);
    }

}
