package com.max.library.repositories;

import com.max.library.entities.Book;
import com.max.library.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
