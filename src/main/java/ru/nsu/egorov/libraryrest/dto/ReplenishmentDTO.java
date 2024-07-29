package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReplenishmentDTO {

    private Date replenishmentDate;
    private Long libraryWorkerId;
    private Long publicationId;

}
