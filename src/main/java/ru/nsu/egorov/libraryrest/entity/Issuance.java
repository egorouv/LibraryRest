package ru.nsu.egorov.libraryrest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issuance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reader", referencedColumnName = "id")
    private Readers readers;

    @ManyToOne
    @JoinColumn(name = "worker", referencedColumnName = "id")
    private LibraryWorkers libraryWorkers;

    @ManyToOne
    @JoinColumn(name = "publication", referencedColumnName = "id")
    private Publication publication;

    private Date issuanceDate;
    private Date returnDate;
    private Date actualReturnDate;

}
