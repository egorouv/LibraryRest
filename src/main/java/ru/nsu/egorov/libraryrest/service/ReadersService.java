package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.ReadersDTO;
import ru.nsu.egorov.libraryrest.entity.Readers;
import ru.nsu.egorov.libraryrest.repository.ReadersRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReadersService {

    private final ReadersRepository readersRepository;
    private final LibraryService libraryService;
    private final CategoryService categoryService;

    public Readers create(ReadersDTO dto) {
        return readersRepository.save(Readers.builder()
                .readerName(dto.getReaderName())
                .readerSurname(dto.getReaderSurname())
                .birthDate(dto.getBirthDate())
                .library(libraryService.findById(dto.getLibraryId()))
                .category(categoryService.findById(dto.getCategoryId()))
                .build());
    }

    public List<Readers> findAll() {
        return readersRepository.findAll();
    }

    public Readers findById(Long id) {
        return readersRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Readers not found. ID: " + id));
    }

    public Readers update(Readers readers) {
        return readersRepository.save(readers);
    }

    public void delete(Long id) {
        readersRepository.deleteById(id);
    }

    public List<Readers> findReadersByCategory(String category) {
        return readersRepository.findReadersByCategory(category);
    }

    public List<Readers> findReadersByTitle(String title) {
        return readersRepository.findReadersByTitle(title);
    }

    public List<Readers> findReadersByType(String type) {
        return readersRepository.findReadersByType(type);
    }

    public List<Readers> findReadersByDate(Date startDate, Date endDate) {
        return readersRepository.findReadersByDate(startDate, endDate);
    }

    public List<Readers> findReadersByWorker(Date startDate, Date endDate, Integer worker) {
        return readersRepository.findReadersByWorker(startDate, endDate, worker);
    }

}
