package ru.nsu.egorov.libraryrest.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ReadersDTO {

    private String readerName;
    private String readerSurname;
    private Date birthDate;
    private Long libraryId;
    private Long categoryId;

}
