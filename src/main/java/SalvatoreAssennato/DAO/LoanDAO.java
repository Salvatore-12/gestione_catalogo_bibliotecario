package SalvatoreAssennato.DAO;

import SalvatoreAssennato.Entities.Loan;
import SalvatoreAssennato.Entities.LoanedItem;
import SalvatoreAssennato.Entities.Magazines;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Loan loan) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(loan);

        transaction.commit();
    }

    public Loan findByid(long id) {
        return em.find(Loan.class, id);
    }

    public void findByIdAndDelete(long id) {

        Loan found = this.findByid(id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("il prestito con ISBN" + found.getLoanedItem() + " è stato eliminato correttamente!");

        } else {

            System.out.println("il prestito con l'id" + id + " non è stata trovato");
        }
    }
}
