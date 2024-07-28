package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.LibraryWorkersDTO;
import ru.nsu.egorov.libraryrest.entity.LibraryWorkers;
import ru.nsu.egorov.libraryrest.repository.LibraryWorkersRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryWorkersService {

    private final LibraryWorkersRepository libraryWorkersRepository;
    private final ReadingRoomService readingRoomService;

    public LibraryWorkers create(LibraryWorkersDTO dto) {
        return libraryWorkersRepository.save(LibraryWorkers.builder()
                .workerName(dto.getWorkerName())
                .workerSurname(dto.getWorkerSurname())
                .birthDate(dto.getBirthDate())
                .readingRoom(readingRoomService.findById(dto.getReadingRoomId()))
                .build());
    }

    public List<LibraryWorkers> findAll() {
        return libraryWorkersRepository.findAll();
    }

    public LibraryWorkers findById(Long id) {
        return libraryWorkersRepository.findById(id).orElseThrow(() ->
                new RuntimeException("LibraryWorkers not found. ID: " + id));
    }

    public LibraryWorkers update(LibraryWorkers libraryWorkers) {
        return libraryWorkersRepository.save(libraryWorkers);
    }

    public void delete(Long id) {
        libraryWorkersRepository.deleteById(id);
    }

}
