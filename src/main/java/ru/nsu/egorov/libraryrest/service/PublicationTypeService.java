package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.PublicationTypeDTO;
import ru.nsu.egorov.libraryrest.entity.PublicationType;
import ru.nsu.egorov.libraryrest.repository.PublicationTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationTypeService {

    private final PublicationTypeRepository publicationTypeRepository;

    public PublicationType create(PublicationTypeDTO dto) {
        return publicationTypeRepository.save(PublicationType.builder()
                .type(dto.getType())
                .build());
    }

    public List<PublicationType> findAll() {
        return publicationTypeRepository.findAll();
    }

    public PublicationType findById(Long id) {
        return publicationTypeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("PublicationType not found. ID: " + id));
    }

    public PublicationType update(PublicationType publicationType) {
        return publicationTypeRepository.save(publicationType);
    }

    public void delete(Long id) {
        publicationTypeRepository.deleteById(id);
    }

}
