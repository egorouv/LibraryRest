package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.ReadingRoomDTO;
import ru.nsu.egorov.libraryrest.entity.ReadingRoom;
import ru.nsu.egorov.libraryrest.repository.ReadingRoomRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReadingRoomService {

    private final ReadingRoomRepository readingRoomRepository;
    private final LibraryService libraryService;

    public ReadingRoom create(ReadingRoomDTO dto) {
        return readingRoomRepository.save(ReadingRoom.builder()
                .library(libraryService.findById(dto.getLibraryId()))
                .room(dto.getRoom())
                .build());
    }

    public List<ReadingRoom> findAll() {
        return readingRoomRepository.findAll();
    }

    public ReadingRoom findById(Long id) {
        return readingRoomRepository.findById(id).orElseThrow(() ->
                new RuntimeException("ReadingRoom not found. ID: " + id));
    }

    public ReadingRoom update(ReadingRoom readingRoom) {
        return readingRoomRepository.save(readingRoom);
    }

    public void delete(Long id) {
        readingRoomRepository.deleteById(id);
    }

}
