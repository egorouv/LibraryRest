package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.Readers;

import java.util.List;

@Repository
public interface ReadersRepository extends JpaRepository<Readers, Long> {

    @Query(value =
            "select r.* " +
            "from readers r " +
            "join category c on r.category = c.id " +
            "where c.category = :category",
            nativeQuery = true)
    List<Readers> findReadersByCategory(@Param("category") String category);

}
