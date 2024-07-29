package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.egorov.libraryrest.entity.Replenishment;

public interface ReplenishmentRepository extends JpaRepository<Replenishment, Long> {}
