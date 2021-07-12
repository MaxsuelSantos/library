package com.max.library.services;

import com.max.library.dto.GenreDTO;
import com.max.library.entities.Genre;
import com.max.library.mapper.GenreMapper;
import com.max.library.repositories.GenreRepository;
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
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Autowired
    private GenreMapper mapper;

    @Transactional(readOnly = true)
    public Page<GenreDTO> findAllPaged(Pageable pageable) {
        Page<Genre> entities = repository.findAll(pageable);
        return entities.map(GenreDTO::new);
    }

    @Transactional(readOnly = true)
    public GenreDTO findById(Long id) {
        Genre entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new GenreDTO(entity);
    }

    @Transactional
    public GenreDTO insert(GenreDTO dto) {
        Genre entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public GenreDTO update(Long id, GenreDTO dto) {
        try {
            Genre entity = repository.getOne(id);
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
