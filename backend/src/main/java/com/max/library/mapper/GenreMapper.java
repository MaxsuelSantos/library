package com.max.library.mapper;

import com.max.library.dto.GenreDTO;
import com.max.library.entities.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public Genre toEntity(GenreDTO dto) {
        Genre entity = new Genre();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public GenreDTO toDTO(Genre entity) {
        GenreDTO dto = new GenreDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Genre updateEntity(Genre entity, GenreDTO dto) {
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
