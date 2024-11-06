package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loans {
    @Id
    private int loanId;
    private int bookId;
    private int userId;

    public Loans(){

    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
