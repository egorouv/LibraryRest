package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.LibraryDTO;
import ru.nsu.egorov.libraryrest.entity.Library;
import ru.nsu.egorov.libraryrest.repository.LibraryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public Library create(LibraryDTO dto) {
        return libraryRepository.save(Library.builder()
                .libraryName(dto.getLibraryName())
                .address(dto.getAddress())
                .build());
    }

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    public Library update(Library library) {
        return libraryRepository.save(library);
    }

    public void delete(Long id) {
        libraryRepository.deleteById(id);
    }

}
