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
public class PublicationDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "title", referencedColumnName = "id")
    private PublicationTitle publicationTitle;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Authors authors;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private PublicationType publicationType;

}
