package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.IssuanceDTO;
import ru.nsu.egorov.libraryrest.entity.Issuance;
import ru.nsu.egorov.libraryrest.repository.IssuanceRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class IssuanceService {

    private final IssuanceRepository issuanceRepository;
    private final ReadersService readersService;
    private final LibraryWorkersService libraryWorkersService;
    private final PublicationService publicationService;

    public Issuance create(IssuanceDTO dto) {
        return issuanceRepository.save(Issuance.builder()
                .readers(readersService.findById(dto.getReaderId()))
                .libraryWorkers(libraryWorkersService.findById(dto.getWorkerId()))
                .publication(publicationService.findById(dto.getPublicationId()))
                .issuanceDate(dto.getIssuanceDate())
                .returnDate(dto.getReturnDate())
                .actualReturnDate(dto.getActualReturnDate())
                .build());
    }

    public List<Issuance> findAll() {
        return issuanceRepository.findAll();
    }

    public Issuance findById(Long id) {
        return issuanceRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Publication not found. ID: " + id));
    }

    public Issuance update(Issuance issuance) {
        return issuanceRepository.save(issuance);
    }

    public void delete(Long id) {
        issuanceRepository.deleteById(id);
    }

    public List<Issuance> findIssuanceByDate(Date startDate, Date endDate) {
        return issuanceRepository.findIssuanceByDate(startDate, endDate);
    }

}
