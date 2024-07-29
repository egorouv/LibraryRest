package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.ReplenishmentDTO;
import ru.nsu.egorov.libraryrest.entity.Replenishment;
import ru.nsu.egorov.libraryrest.repository.ReplenishmentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReplenishmentService {

    private final ReplenishmentRepository replenishmentRepository;
    private final LibraryWorkersService libraryWorkersService;
    private final PublicationService publicationService;

    public Replenishment create(ReplenishmentDTO dto) {
        return replenishmentRepository.save(Replenishment.builder()
                .replenishmentDate(dto.getReplenishmentDate())
                .libraryWorkers(libraryWorkersService.findById(dto.getLibraryWorkerId()))
                .publication(publicationService.findById(dto.getPublicationId()))
                .build());
    }

    public List<Replenishment> findAll() {
        return replenishmentRepository.findAll();
    }

    public Replenishment update(Replenishment replenishment) {
        return replenishmentRepository.save(replenishment);
    }

    public void delete(Long id) {
        replenishmentRepository.deleteById(id);
    }

}
