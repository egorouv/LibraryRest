package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.LocationRackDTO;
import ru.nsu.egorov.libraryrest.entity.LocationRack;
import ru.nsu.egorov.libraryrest.repository.LocationRackRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationRackService {

    private final LocationRackRepository locationRackRepository;
    private final LocationHallService locationHallService;

    public LocationRack create(LocationRackDTO dto) {
        return locationRackRepository.save(LocationRack.builder()
                .locationHall(locationHallService.findById(dto.getLocationHallId()))
                .locationRack(dto.getLocationRack())
                .build());
    }

    public List<LocationRack> findAll() {
        return locationRackRepository.findAll();
    }

    public LocationRack findById(Long id) {
        return locationRackRepository.findById(id).orElseThrow(() ->
                new RuntimeException("LocationRack not found. ID: " + id));
    }

    public LocationRack update(LocationRack locationRack) {
        return locationRackRepository.save(locationRack);
    }

    public void delete(Long id) {
        locationRackRepository.deleteById(id);
    }

}
