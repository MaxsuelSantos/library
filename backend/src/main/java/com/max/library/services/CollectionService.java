package com.max.library.services;

import com.max.library.dto.CollectionDTO;
import com.max.library.entities.Collection;
import com.max.library.mapper.CollectionMapper;
import com.max.library.repositories.CollectionRepository;
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
public class CollectionService {

    @Autowired
    private CollectionRepository repository;

    @Autowired
    private CollectionMapper mapper;

    @Transactional(readOnly = true)
    public Page<CollectionDTO> findAllPaged(Pageable pageable) {
        Page<Collection> entities = repository.findAll(pageable);
        return entities.map(CollectionDTO::new);
    }

    @Transactional(readOnly = true)
    public CollectionDTO findById(Long id) {
        Collection entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new CollectionDTO(entity);
    }

    @Transactional
    public CollectionDTO insert(CollectionDTO dto) {
        Collection entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public CollectionDTO update(Long id, CollectionDTO dto) {
        try {
            Collection entity = repository.getOne(id);
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
