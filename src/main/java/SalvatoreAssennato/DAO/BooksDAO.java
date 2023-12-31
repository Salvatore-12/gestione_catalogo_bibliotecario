package SalvatoreAssennato.DAO;

import SalvatoreAssennato.Entities.Books;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class BooksDAO {
    private final EntityManager em;

    public BooksDAO(EntityManager em) {
        this.em = em;
    }

    // metodo per salvare
    public void save(Books books) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(books);

        transaction.commit();
    }

    // metodo per ricercare per id
    public Books findByid(long id) {
        return em.find(Books.class, id);
    }


    public void findByIdAndDelete(long id) {

        Books found = this.findByid(id);

        if (found != null) {



            EntityTransaction transaction = em.getTransaction();

            transaction.begin();


            em.remove(found);


            transaction.commit();

            System.out.println("libro " + found.getTitle() + " eliminato correttamente!");

        } else {

            System.out.println("il libro con l'id " + id + " non è stato trovato");
        }
    }

}
