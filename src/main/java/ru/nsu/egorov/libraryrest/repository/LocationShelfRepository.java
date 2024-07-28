package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.LocationShelf;

@Repository
public interface LocationShelfRepository extends JpaRepository<LocationShelf, Long> {}
