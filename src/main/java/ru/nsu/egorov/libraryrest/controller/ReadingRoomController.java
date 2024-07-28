package ru.nsu.egorov.libraryrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.egorov.libraryrest.dto.ReadingRoomDTO;
import ru.nsu.egorov.libraryrest.entity.ReadingRoom;
import ru.nsu.egorov.libraryrest.service.ReadingRoomService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reading_room")
public class ReadingRoomController {

    private final ReadingRoomService readingRoomService;

    @PostMapping
    public ResponseEntity<ReadingRoom> create(@RequestBody ReadingRoomDTO dto) {
        return new ResponseEntity<>(readingRoomService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReadingRoom>> findAll() {
        return new ResponseEntity<>(readingRoomService.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ReadingRoom> update(@RequestBody ReadingRoom readingRoom) {
        return new ResponseEntity<>(readingRoomService.update(readingRoom), HttpStatus.OK);
    }

    @DeleteMapping
    public HttpStatus delete(@PathVariable Long id) {
        readingRoomService.delete(id);
        return HttpStatus.OK;
    }

}
