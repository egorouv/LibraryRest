package ru.nsu.egorov.libraryrest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "id")
    private LocationShelf locationShelf;

    @ManyToOne
    @JoinColumn(name = "description", referencedColumnName = "id")
    private PublicationDescription publicationDescription;

    private Boolean allowTake;
    private Boolean writeOff;

}
