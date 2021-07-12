package com.max.library.services;

import com.max.library.dto.PublishingCompanyDTO;
import com.max.library.entities.PublishingCompany;
import com.max.library.mapper.PublishingCompanyMapper;
import com.max.library.repositories.PublishingCompanyRepository;
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
public class PublishingCompanyService {

    @Autowired
    private PublishingCompanyRepository repository;

    @Autowired
    private PublishingCompanyMapper mapper;

    @Transactional(readOnly = true)
    public Page<PublishingCompanyDTO> findAllPaged(Pageable pageable) {
        Page<PublishingCompany> entities = repository.findAll(pageable);
        return entities.map(PublishingCompanyDTO::new);
    }

    @Transactional(readOnly = true)
    public PublishingCompanyDTO findById(Long id) {
        PublishingCompany entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PublishingCompanyDTO(entity);
    }

    @Transactional
    public PublishingCompanyDTO insert(PublishingCompanyDTO dto) {
        PublishingCompany entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public PublishingCompanyDTO update(Long id, PublishingCompanyDTO dto) {
        try {
            PublishingCompany entity = repository.getOne(id);
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
