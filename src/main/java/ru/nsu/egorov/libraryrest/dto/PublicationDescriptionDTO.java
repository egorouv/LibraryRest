package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;

@Data
public class PublicationDescriptionDTO {

    private Long publicationTitleId;
    private Long authorId;
    private Long publicationTypeId;

}
