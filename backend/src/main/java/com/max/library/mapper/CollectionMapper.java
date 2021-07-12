package com.max.library.mapper;

import com.max.library.dto.CollectionDTO;
import com.max.library.entities.Collection;
import org.springframework.stereotype.Component;

@Component
public class CollectionMapper {

    public Collection toEntity(CollectionDTO dto) {
        Collection entity = new Collection();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public CollectionDTO toDTO(Collection entity) {
        CollectionDTO dto = new CollectionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Collection updateEntity(Collection entity, CollectionDTO dto) {
        entity.setName(dto.getName());
        return entity;
    }

}
