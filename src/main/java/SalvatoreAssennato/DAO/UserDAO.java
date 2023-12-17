package SalvatoreAssennato.DAO;


import SalvatoreAssennato.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(user);

        transaction.commit();
    }


    public User findByid(long id) {
        return em.find(User.class, id);
    }


    public void findByIdAndDelete(long id) {

       User found = this.findByid(id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("utente" + found.getNumberCard_id() + " eliminato correttamente!");

        } else {

            System.out.println("l'utente con l'id " + id + " non è stato trovato");
        }
    }
}
