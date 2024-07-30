package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.ReadersDTO;
import ru.nsu.egorov.libraryrest.entity.Readers;
import ru.nsu.egorov.libraryrest.service.ReadersService;

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

    @GetMapping("/")
    public ResponseEntity<List<Readers>> findReadersByCategory(@RequestParam String category) {
        return new ResponseEntity<>(readersService.findReadersByCategory(category), HttpStatus.OK);
    }


}
