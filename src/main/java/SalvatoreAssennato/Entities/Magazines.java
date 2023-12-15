package SalvatoreAssennato.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("riviste")
public class Magazines extends LoanedItem{
    @Column(name="periodicità")
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;
    public Magazines(){}
    public Magazines(String title, LocalDate yearPublished, int numberPage, Periodicity periodicity) {
        this.title=title;
        this.yearPublished=yearPublished;
        this.numberPage=numberPage;
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazines{" +
                "periodicity=" + periodicity +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", yearPublished=" + yearPublished +
                ", numberPage=" + numberPage +
                '}';
    }
}
