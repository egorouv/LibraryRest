package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.PublicationDTO;
import ru.nsu.egorov.libraryrest.entity.Publication;
import ru.nsu.egorov.libraryrest.repository.PublicationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {

    private final PublicationRepository publicationRepository;
    private final PublicationDescriptionService publicationDescriptionService;
    private final LocationShelfService locationShelfService;

    public Publication create(PublicationDTO dto) {
        return publicationRepository.save(Publication.builder()
                .publicationDescription(publicationDescriptionService.findById(dto.getPublicationDescriptionId()))
                .locationShelf(locationShelfService.findById(dto.getPublicationDescriptionId()))
                .allowTake(dto.getAllowTake())
                .writeOff(dto.getWriteOff())
                .build());
    }

    public List<Publication> findAll() {
        return publicationRepository.findAll();
    }

    public Publication findById(Long id) {
        return publicationRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Publication not found. ID: " + id));
    }

    public Publication update(Publication publication) {
        return publicationRepository.save(publication);
    }

    public void delete(Long id) {
        publicationRepository.deleteById(id);
    }

}