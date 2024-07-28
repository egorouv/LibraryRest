package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.IssuanceDTO;
import ru.nsu.egorov.libraryrest.entity.Issuance;
import ru.nsu.egorov.libraryrest.service.IssuanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/issuance")
public class IssuanceController {

    private final IssuanceService issuanceService;

    @PostMapping
    public ResponseEntity<Issuance> create(@RequestBody IssuanceDTO dto) {
        return new ResponseEntity<>(issuanceService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Issuance>> findAll() {
        return new ResponseEntity<>(issuanceService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Issuance> update(@RequestBody Issuance issuance) {
        return new ResponseEntity<>(issuanceService.update(issuance), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        issuanceService.delete(id);
        return HttpStatus.OK;
    }

}
