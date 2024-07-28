package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class IssuanceDTO {

    private Long readerId;
    private Long workerId;
    private Long publicationId;
    private Date issuanceDate;
    private Date returnDate;
    private Date actualReturnDate;

}
