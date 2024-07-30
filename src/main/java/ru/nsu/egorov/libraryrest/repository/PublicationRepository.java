package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.Publication;

import java.util.Date;
import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

    @Query(value =
            "select p.* " +
            "from publication p " +
            "join issuance i on p.id = i.publication " +
            "join readers r on i.reader = r.id " +
            "join library_workers lw on i.worker = lw.id " +
            "join reading_room rr on lw.work_place = rr.id " +
            "where r.id = :reader " +
            "and i.issuance_date between :startDate and :endDate " +
            "and r.library = rr.library",
            nativeQuery = true)
    List<Publication> findPublicationByDateFromLibrary(@Param("startDate") Date startDate,
                                                   @Param("endDate") Date endDate,
                                                   @Param("reader") Integer reader);

    @Query(value =
            "select p.* " +
            "from publication p " +
            "join issuance i on p.id = i.publication " +
            "join readers r on i.reader = r.id " +
            "join library_workers lw on i.worker = lw.id " +
            "join reading_room rr on lw.work_place = rr.id " +
            "where r.id = :reader " +
            "and i.issuance_date between :startDate and :endDate " +
            "and r.library <> rr.library",
            nativeQuery = true)
    List<Publication> findPublicationByDateNotFromLibrary(@Param("startDate") Date startDate,
                                                          @Param("endDate") Date endDate,
                                                          @Param("reader") Integer reader);

    @Query(value =
            "select p.* " +
            "from publication p " +
            "join location_shelf ls on p.location = ls.id " +
            "join location_rack lr on ls.location_rack = lr.id " +
            "join location_hall lh on lr.location_hall = lh.id " +
            "where lh.library = :library " +
            "and ls.location_shelf = :shelf",
            nativeQuery = true)
    List<Publication> findPublicationByLibrary(@Param("library") Integer library, @Param("shelf") Integer shelf);

}
