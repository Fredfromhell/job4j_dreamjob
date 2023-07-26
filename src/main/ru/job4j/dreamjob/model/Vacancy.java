package ru.job4j.dreamjob.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vacancy {

    private int id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private boolean visible;

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

