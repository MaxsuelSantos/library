package com.max.library.dto;

import com.max.library.entities.PublishingCompany;

public class PublishingCompanyDTO {

    private Long id;
    private String name;

    public PublishingCompanyDTO() {
    }

    public PublishingCompanyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublishingCompanyDTO(PublishingCompany entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
