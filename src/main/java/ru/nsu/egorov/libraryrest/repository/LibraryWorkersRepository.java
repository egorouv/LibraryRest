package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.LibraryWorkers;

import java.util.List;

@Repository
public interface LibraryWorkersRepository extends JpaRepository<LibraryWorkers, Long> {

    @Query(value =
            "select lw.* " +
            "from library_workers lw " +
            "join reading_room rr on lw.work_place = rr.id " +
            "where rr.room = :room and rr.library = :library",
            nativeQuery = true)
    List<LibraryWorkers> findWorkersByLibrary(@Param("room") Integer room, @Param("library") Integer library);

}
