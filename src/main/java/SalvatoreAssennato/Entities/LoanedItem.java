package SalvatoreAssennato.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//qui stiamo definendo una named query:
//l'annotazione @NamedQuery necessita di 2 argomenti:
//1 il nome della query(proprio per questo motivo si chiamano namedquery)
//2 la query vera è propria
// quindi io nella dao non dovro scrivere la query
// ma dovro semplicemente richiamarne  il nome nel metodo .createNamedQuery
@NamedQuery(name="findBYTitle",query = "SELECT l FROM LoanedItem l WHERE l.title = :title")
public abstract class LoanedItem {
    @Id
    @GeneratedValue
    protected long id;

    @Column(name="titolo")
    protected String title;
    @Column(name="anno_pubblicazione")
    protected LocalDate yearPublished;
    @Column(name="numero_pagina")
    protected int numberPage;
    @OneToMany(mappedBy = "loanedItem", cascade = CascadeType.REMOVE)
    private List<Loan> loanHistory;

    public LoanedItem() {
    }

    public LoanedItem(long id,String title, LocalDate yearPublished, int numberPage) {
        this.id=id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.numberPage = numberPage;
    }

    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(LocalDate yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public List<Loan> getLoanHistory() {
        return loanHistory;
    }

    @Override
    public String toString() {
        return "LoanedItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublished=" + yearPublished +
                ", numberPage=" + numberPage +
                ", loanHistory=" + loanHistory +
                '}';
    }
}
