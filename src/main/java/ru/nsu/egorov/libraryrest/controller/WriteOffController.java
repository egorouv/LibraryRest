package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.WriteOffDTO;
import ru.nsu.egorov.libraryrest.entity.WriteOff;
import ru.nsu.egorov.libraryrest.service.WriteOffService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/write_off")
public class WriteOffController {

    private final WriteOffService writeOffService;

    @PostMapping
    public ResponseEntity<WriteOff> create(@RequestBody WriteOffDTO dto) {
        return new ResponseEntity<>(writeOffService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WriteOff>> findAll() {
        return new ResponseEntity<>(writeOffService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WriteOff> update(@RequestBody WriteOff writeOff) {
        return new ResponseEntity<>(writeOffService.update(writeOff), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        writeOffService.delete(id);
        return HttpStatus.OK;
    }

}
