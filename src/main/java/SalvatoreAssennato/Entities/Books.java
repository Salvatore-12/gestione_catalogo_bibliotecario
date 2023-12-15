package SalvatoreAssennato.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="libri")
public class Books {
    @Column(name="autore")
    private String author;
    Geners geners;

}
