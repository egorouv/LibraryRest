package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.AuthorsDTO;
import ru.nsu.egorov.libraryrest.entity.Authors;
import ru.nsu.egorov.libraryrest.repository.AuthorsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public Authors create(AuthorsDTO dto) {
        return authorsRepository.save(Authors.builder()
                .authorName(dto.getAuthorName())
                .authorSurname(dto.getAuthorSurname())
                .build());
    }

    public List<Authors> findAll() {
        return authorsRepository.findAll();
    }

    public Authors findById(Long id) {
        return authorsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Author not found. ID: " + id));
    }

    public Authors update(Authors author) {
        return authorsRepository.save(author);
    }

    public void delete(Long id) {
        authorsRepository.deleteById(id);
    }

}
