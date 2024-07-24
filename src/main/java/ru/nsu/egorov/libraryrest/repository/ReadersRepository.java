package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.Readers;

import java.util.List;

@Repository
public interface ReadersRepository extends JpaRepository<Readers, Long> {

    @Query(value =
            "select * " +
            "from readers " +
            "where reader_name = 'Сергей'",
            nativeQuery = true)
    List<Readers> findReaders();

}
