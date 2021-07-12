package com.max.library.dto;

import com.max.library.entities.Genre;

public class GenreDTO {

    private Long id;
    private String description;

    public GenreDTO() {
    }

    public GenreDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public GenreDTO(Genre entity) {
        id = entity.getId();
        description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
