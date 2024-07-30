package ru.nsu.egorov.libraryrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsu.egorov.libraryrest.entity.Issuance;

import java.util.Date;
import java.util.List;

@Repository
public interface IssuanceRepository extends JpaRepository<Issuance, Long> {

    @Query(value =
            "select i.* " +
            "from issuance i " +
            "where i.issuance_date between :startDate and :endDate",
            nativeQuery = true)
    List<Issuance> findIssuanceByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
