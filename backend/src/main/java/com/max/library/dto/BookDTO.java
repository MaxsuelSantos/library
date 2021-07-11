package com.max.library.dto;

import com.max.library.entities.Book;

public class BookDTO {

    private Long id;
    private String title;
    private Integer pages;
    private Double fineAmount;

    public BookDTO() {
    }

    public BookDTO(Long id, String title, Integer pages, Double fineAmount) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.fineAmount = fineAmount;
    }

    public BookDTO(Book entity) {
        id = entity.getId();
        title = entity.getTitle();
        pages = entity.getPages();
        fineAmount = entity.getFineAmount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }
}
