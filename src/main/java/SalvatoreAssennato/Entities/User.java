package SalvatoreAssennato.Entities;

import javax.persistence.*;
import java.time.LocalDate;

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

}
