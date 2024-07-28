package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.PublicationTitle;

@Repository
public interface PublicationTitleRepository extends JpaRepository<PublicationTitle, Long> {}
