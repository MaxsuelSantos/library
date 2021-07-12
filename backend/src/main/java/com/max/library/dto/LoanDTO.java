package com.max.library.dto;


import com.max.library.entities.Loan;
import java.time.Instant;

public class LoanDTO {

    private Long id;
    private Instant loanDate;
    private Instant returnDate;
    private Long bookId;
    private Long userId;

    public LoanDTO() {
    }

    public LoanDTO(Long id, Instant loanDate, Instant returnDate, Long bookId, Long userId) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
        this.userId = userId;
    }

    public LoanDTO(Loan entity) {
        id = entity.getId();
        loanDate = entity.getLoanDate();
        returnDate = entity.getReturnDate();
        bookId = entity.getBook().getId();
        userId = entity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Instant loanDate) {
        this.loanDate = loanDate;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
