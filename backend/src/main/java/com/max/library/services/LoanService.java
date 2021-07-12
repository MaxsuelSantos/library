package com.max.library.services;

import com.max.library.dto.LoanDTO;
import com.max.library.entities.Loan;
import com.max.library.mapper.LoanMapper;
import com.max.library.repositories.LoanRepository;
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
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Autowired
    private LoanMapper mapper;

    @Transactional(readOnly = true)
    public Page<LoanDTO> findAllPaged(Pageable pageable) {
        Page<Loan> entities = repository.findAll(pageable);
        return entities.map(LoanDTO::new);
    }

    @Transactional(readOnly = true)
    public LoanDTO findById(Long id) {
        Loan entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new LoanDTO(entity);
    }

    @Transactional
    public LoanDTO insert(LoanDTO dto) {
        Loan entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public LoanDTO update(Long id, LoanDTO dto) {
        try {
            Loan entity = repository.getOne(id);
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
