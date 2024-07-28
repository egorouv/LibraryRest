package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.LocationHallDTO;
import ru.nsu.egorov.libraryrest.entity.LocationHall;
import ru.nsu.egorov.libraryrest.repository.LocationHallRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationHallService {

    private final LocationHallRepository locationHallRepository;
    private final LibraryService libraryService;

    public LocationHall create(LocationHallDTO dto) {
        return locationHallRepository.save(LocationHall.builder()
                .library(libraryService.findById(dto.getLibraryId()))
                .locationHall(dto.getLocationHall())
                .build());
    }

    public List<LocationHall> findAll() {
        return locationHallRepository.findAll();
    }

    public LocationHall findById(Long id) {
        return locationHallRepository.findById(id).orElseThrow(() ->
                new RuntimeException("LocationHall not found. ID: " + id));
    }

    public LocationHall update(LocationHall locationHall) {
        return locationHallRepository.save(locationHall);
    }

    public void delete(Long id) {
        locationHallRepository.deleteById(id);
    }

}
