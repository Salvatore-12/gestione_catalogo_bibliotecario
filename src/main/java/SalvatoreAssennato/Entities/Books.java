package SalvatoreAssennato.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="libri")
public class Books extends LoanedItem {
    @Column(name="autore")
    private String author;
    @Column(name = "genere")
    @Enumerated(EnumType.STRING)
    private Geners geners;

    public Books(){}
    public Books(String title, LocalDate yearPublished, int numberPage, String author, Geners geners) {
        this.title=title;
        this.yearPublished=yearPublished;
        this.numberPage=numberPage;
        this.author = author;
        this.geners = geners;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Geners getGeners() {
        return geners;
    }

    public void setGeners(Geners geners) {
        this.geners = geners;
    }

    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", geners=" + geners +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", yearPublished=" + yearPublished +
                ", numberPage=" + numberPage +
                '}';
    }
}
