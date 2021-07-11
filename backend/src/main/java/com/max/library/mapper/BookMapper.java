package com.max.library.mapper;

import com.max.library.dto.BookDTO;
import com.max.library.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookDTO dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setPages(dto.getPages());
        entity.setFineAmount(dto.getFineAmount());
        return entity;
    }

    public BookDTO toDTO(Book entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPages(entity.getPages());
        dto.setFineAmount(entity.getFineAmount());
        return dto;
    }

    public Book updateEntity(Book entity, BookDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setPages(dto.getPages());
        entity.setFineAmount(dto.getFineAmount());
        return entity;
    }

}
