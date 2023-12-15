package SalvatoreAssennato.DAO;

import SalvatoreAssennato.Entities.Books;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BooksDAO {
    private final EntityManager em;

    public BooksDAO(EntityManager em) {
        this.em = em;
    }

    // metodo per salvare
    public void save(Books books) {
        // 0. Ho bisogno di una transazione (mi viene fornita dall'EntityManager)
        EntityTransaction transaction = em.getTransaction();
        // 1. startare la transazione
        transaction.begin();
        // 2. Aggiungo l'evento al Persistence Context
        em.persist(books);
        // 3. Concludo la transazione col salvataggio nel database
        transaction.commit();
    }

    // metodo per ricercare per id
    public Books findByid(long id) {
        return em.find(Books.class, id);
    }

    // metodo per ricercare ed eliminare per id
    public void findByIdAndDelete(long id) {
        // 1. Cerco lo studente in db
        Books found = this.findByid(id);

        if (found != null) {
            // 2. Se lo studente c'è lo elimino

            // 2.0 Ho bisogno di una transazione (mi viene fornita dall'EntityManager
            EntityTransaction transaction = em.getTransaction();

            // 2.1 Inizio la transazione
            transaction.begin();

            // 2.2 Rimuovo l'oggetto dal Persistence Context (in questo momento non sarà ancora rimosso da DB)
            em.remove(found);

            // 2.3. Concludo la transazione con la rimozione effettiva di una riga dalla tabella students
            transaction.commit();

            System.out.println("libro " + found.getTitle() + " eliminato correttamente!");

        } else {
            // 3. Se non c'è --> "Non trovato"
            System.out.println("il libro con l'id " + id + " non è stato trovato");
        }
    }
}
