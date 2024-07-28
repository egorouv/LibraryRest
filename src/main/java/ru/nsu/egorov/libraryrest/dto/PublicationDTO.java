package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;

@Data
public class PublicationDTO {

    private Long locationShelfId;
    private Long publicationDescriptionId;
    private Boolean allowTake;
    private Boolean writeOff;

}
