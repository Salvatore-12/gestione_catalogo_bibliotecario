package SalvatoreAssennato.DAO;

import SalvatoreAssennato.Entities.Books;
import SalvatoreAssennato.Entities.Magazines;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MagazinesDAO {
    private final EntityManager em;

    public MagazinesDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Magazines magazines) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(magazines);

        transaction.commit();
    }


    public Magazines findByid(long id) {
        return em.find(Magazines.class, id);
    }


    public void findByIdAndDelete(long id) {

        Magazines found = this.findByid(id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("rivista" + found.getTitle() + " eliminata correttamente!");

        } else {

            System.out.println("la rivista con l'id " + id + " non è stata trovato");
        }
    }
}
