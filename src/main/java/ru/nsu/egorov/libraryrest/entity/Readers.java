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
public class Readers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String readerName;
    private String readerSurname;
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "library", referencedColumnName = "id")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

}
