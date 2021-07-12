package com.max.library.mapper;

import com.max.library.dto.LoanDTO;
import com.max.library.entities.Loan;
import com.max.library.repositories.BookRepository;
import com.max.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Loan toEntity(LoanDTO dto) {
        Loan entity = new Loan();
        entity.setId(dto.getId());
        entity.setLoanDate(dto.getLoanDate());
        entity.setReturnDate(dto.getReturnDate());
        entity.setBook(bookRepository.getOne(dto.getBookId()));
        entity.setUser(userRepository.getOne(dto.getUserId()));
        return entity;
    }

    public LoanDTO toDTO(Loan entity) {
        LoanDTO dto = new LoanDTO();
        dto.setId(entity.getId());
        dto.setLoanDate(entity.getLoanDate());
        dto.setReturnDate(entity.getReturnDate());
        dto.setBookId(entity.getBook().getId());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

    public Loan updateEntity(Loan entity, LoanDTO dto) {
        entity.setLoanDate(dto.getLoanDate());
        entity.setReturnDate(dto.getReturnDate());
        entity.setBook(bookRepository.getOne(dto.getBookId()));
        entity.setUser(userRepository.getOne(dto.getUserId()));
        return entity;
    }

}
