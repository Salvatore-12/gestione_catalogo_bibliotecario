package SalvatoreAssennato.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="utenti")
public class User {
    @Column(name="nome")
    protected String name;
    protected  String surname;
    protected LocalDate dateOfBirth;
    @Id
    @GeneratedValue
    protected long numberCard_id;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Loan> listOfLoans;

    public User(){

    }

    public User(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;

    }

    public long getNumberCard_id() {
        return numberCard_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", numberCard_id=" + numberCard_id +
                '}';
    }
}
