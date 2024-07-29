package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.WriteOffDTO;
import ru.nsu.egorov.libraryrest.entity.WriteOff;
import ru.nsu.egorov.libraryrest.repository.WriteOffRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class WriteOffService {

    private final WriteOffRepository writeOffRepository;
    private final LibraryWorkersService libraryWorkersService;
    private final PublicationService publicationService;

    public WriteOff create(WriteOffDTO dto) {
        return writeOffRepository.save(WriteOff.builder()
                .writeOffDate(dto.getWriteOffDate())
                .libraryWorkers(libraryWorkersService.findById(dto.getLibraryWorkerId()))
                .publication(publicationService.findById(dto.getPublicationId()))
                .build());
    }

    public List<WriteOff> findAll() {
        return writeOffRepository.findAll();
    }

    public WriteOff update(WriteOff writeOff) {
        return writeOffRepository.save(writeOff);
    }

    public void delete(Long id) {
        writeOffRepository.deleteById(id);
    }

}
