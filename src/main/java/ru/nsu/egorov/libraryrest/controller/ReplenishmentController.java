package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.ReplenishmentDTO;
import ru.nsu.egorov.libraryrest.entity.Replenishment;
import ru.nsu.egorov.libraryrest.service.ReplenishmentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/replenishment")
public class ReplenishmentController {

    private final ReplenishmentService replenishmentService;

    @PostMapping
    public ResponseEntity<Replenishment> create(@RequestBody ReplenishmentDTO dto) {
        return new ResponseEntity<>(replenishmentService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Replenishment>> findAll() {
        return new ResponseEntity<>(replenishmentService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Replenishment> update(@RequestBody Replenishment replenishment) {
        return new ResponseEntity<>(replenishmentService.update(replenishment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        replenishmentService.delete(id);
        return HttpStatus.OK;
    }

}
