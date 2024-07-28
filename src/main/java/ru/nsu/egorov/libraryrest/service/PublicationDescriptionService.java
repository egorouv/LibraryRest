package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.PublicationDescriptionDTO;
import ru.nsu.egorov.libraryrest.entity.PublicationDescription;
import ru.nsu.egorov.libraryrest.repository.PublicationDescriptionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationDescriptionService {

    private final PublicationDescriptionRepository publicationDescriptionRepository;
    private final PublicationTitleService publicationTitleService;
    private final AuthorsService authorsService;
    private final PublicationTypeService publicationTypeService;

    public PublicationDescription create(PublicationDescriptionDTO dto) {
        return publicationDescriptionRepository.save(PublicationDescription.builder()
                .publicationTitle(publicationTitleService.findById(dto.getPublicationTitleId()))
                .authors(authorsService.findById(dto.getAuthorId()))
                .publicationType(publicationTypeService.findById(dto.getPublicationTypeId()))
                .build());
    }

    public List<PublicationDescription> findAll() {
        return publicationDescriptionRepository.findAll();
    }

    public PublicationDescription findById(Long id) {
        return publicationDescriptionRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Description not found. ID: " + id));
    }

    public PublicationDescription update(PublicationDescription publicationDescription) {
        return publicationDescriptionRepository.save(publicationDescription);
    }

    public void delete(Long id) {
        publicationDescriptionRepository.deleteById(id);
    }

}
