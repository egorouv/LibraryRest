package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class WriteOffDTO {

    private Date writeOffDate;
    private Long libraryWorkerId;
    private Long publicationId;

}
