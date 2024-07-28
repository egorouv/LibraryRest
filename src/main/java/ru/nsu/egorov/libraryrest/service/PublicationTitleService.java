package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.PublicationTitleDTO;
import ru.nsu.egorov.libraryrest.entity.PublicationTitle;
import ru.nsu.egorov.libraryrest.repository.PublicationTitleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationTitleService {

    private final PublicationTitleRepository publicationTitleRepository;

    public PublicationTitle create(PublicationTitleDTO dto) {
        return publicationTitleRepository.save(PublicationTitle.builder()
                .title(dto.getTitle())
                .build());
    }

    public List<PublicationTitle> findAll() {
        return publicationTitleRepository.findAll();
    }

    public PublicationTitle findById(Long id) {
        return publicationTitleRepository.findById(id).orElseThrow(() ->
                new RuntimeException("PublicationTitle not found. ID: " + id));
    }

    public PublicationTitle update(PublicationTitle publicationTitle) {
        return publicationTitleRepository.save(publicationTitle);
    }

    public void delete(Long id) {
        publicationTitleRepository.deleteById(id);
    }

}
