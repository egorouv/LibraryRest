package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LibraryWorkersDTO {

    private String workerName;
    private String workerSurname;
    private Date birthDate;
    private Long readingRoomId;

}
