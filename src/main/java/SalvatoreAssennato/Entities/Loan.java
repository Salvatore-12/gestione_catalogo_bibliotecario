package SalvatoreAssennato.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="prestiti")
public class Loan {
    @Id
    @GeneratedValue
    @JoinColumn(name="loan_id")
    private long Id;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="isbn_code",nullable = false)
    private LoanedItem loanedItem;
    @Column(name = "start_date",nullable = false)
    private LocalDate startDate;
    @Column(name = "due_date")
    private LocalDate expectedDate;
    @Column(name = "return_date")
    private LocalDate returnDate;

    public Loan(){

    }

    public Loan(User user, LoanedItem loanedItem , LocalDate startDate, LocalDate expectedDate, LocalDate returnDate) {
        this.user = user;
        this.loanedItem = loanedItem;
        this.startDate = startDate;
        this.expectedDate = expectedDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoanedItem getLoanedItem() {
        return loanedItem;
    }
    public void setLoanedItem(LoanedItem loanedItem) {
        this.loanedItem = loanedItem;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "Id=" + Id +
                ", user=" + user +
                ", loanedItem=" + loanedItem +
                ", startDate=" + startDate +
                ", expectedDate=" + expectedDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
