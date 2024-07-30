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

    @Query(value =
            "select r.* " +
            "from readers r " +
            "join issuance i on r.id = i.reader " +
            "join publication p on i.publication = p.id " +
            "join publication_description pd on p.description = pd.id " +
            "join publication_title pt on pd.title = pt.id " +
            "where pt.title = :title",
            nativeQuery = true)
    List<Readers> findReadersByTitle(@Param("title") String title);

    @Query(value =
            "select r.* " +
                    "from readers r " +
                    "join issuance i on r.id = i.reader " +
                    "join publication p on i.publication = p.id " +
                    "join publication_description pd on p.description = pd.id " +
                    "join publication_type pt on pd.type = pt.id " +
                    "where pt.type = :type",
            nativeQuery = true)
    List<Readers> findReadersByType(@Param("type") String type);

}
