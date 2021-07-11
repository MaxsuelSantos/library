package com.max.library.services;

import com.max.library.dto.BookDTO;
import com.max.library.entities.Book;
import com.max.library.mapper.BookMapper;
import com.max.library.repositories.BookRepository;
import com.max.library.services.exceptions.DatabaseException;
import com.max.library.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    @Transactional(readOnly = true)
    public Page<BookDTO> findAllPaged(Pageable pageable) {
        Page<Book> entities = repository.findAll(pageable);
        return entities.map(BookDTO::new);
    }

    @Transactional(readOnly = true)
    public BookDTO findById(Long id) {
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new BookDTO(entity);
    }

    @Transactional
    public BookDTO insert(BookDTO dto) {
        Book entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public BookDTO update(Long id, BookDTO dto) {
        try {
            Book entity = repository.getOne(id);
            entity = repository.save(mapper.updateEntity(entity, dto));
            return mapper.toDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
