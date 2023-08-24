package ru.job4j.dreamjob.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Candidate {

    private int id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private int cityId;


}
