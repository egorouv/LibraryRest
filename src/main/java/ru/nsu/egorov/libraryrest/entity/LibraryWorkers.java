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
public class LibraryWorkers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String workerName;
    private String workerSurname;
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "reading_room", referencedColumnName = "id")
    private ReadingRoom readingRoom;

}
