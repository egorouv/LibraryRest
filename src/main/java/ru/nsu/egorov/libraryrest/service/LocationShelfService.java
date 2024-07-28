package ru.nsu.egorov.libraryrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.egorov.libraryrest.dto.LocationShelfDTO;
import ru.nsu.egorov.libraryrest.entity.LocationShelf;
import ru.nsu.egorov.libraryrest.repository.LocationShelfRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationShelfService {

    private final LocationShelfRepository locationShelfRepository;
    private final LocationRackService locationRackService;

    public LocationShelf create(LocationShelfDTO dto) {
        return locationShelfRepository.save(LocationShelf.builder()
                .locationRack(locationRackService.findById(dto.getLocationRackId()))
                .locationShelf(dto.getLocationShelf())
                .build());
    }

    public List<LocationShelf> findAll() {
        return locationShelfRepository.findAll();
    }

    public LocationShelf findById(Long id) {
        return locationShelfRepository.findById(id).orElseThrow(() ->
                new RuntimeException("LocationShelf not found. ID: " + id));
    }

    public LocationShelf update(LocationShelf locationShelf) {
        return locationShelfRepository.save(locationShelf);
    }

    public void delete(Long id) {
        locationShelfRepository.deleteById(id);
    }

}
