package com.max.library.mapper;

import com.max.library.dto.PublishingCompanyDTO;
import com.max.library.entities.PublishingCompany;
import com.max.library.entities.PublishingCompany;
import org.springframework.stereotype.Component;

@Component
public class PublishingCompanyMapper {

    public PublishingCompany toEntity(PublishingCompanyDTO dto) {
        PublishingCompany entity = new PublishingCompany();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public PublishingCompanyDTO toDTO(PublishingCompany entity) {
        PublishingCompanyDTO dto = new PublishingCompanyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public PublishingCompany updateEntity(PublishingCompany entity, PublishingCompanyDTO dto) {
        entity.setName(dto.getName());
        return entity;
    }

}
