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
public class WriteOff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date writeOffDate;

    @ManyToOne
    @JoinColumn(name = "library_worker", referencedColumnName = "id")
    private LibraryWorkers libraryWorkers;

    @ManyToOne
    @JoinColumn(name = "publication", referencedColumnName = "id")
    private Publication publication;

}
