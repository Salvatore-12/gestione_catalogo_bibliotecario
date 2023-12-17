package SalvatoreAssennato.DAO;

import SalvatoreAssennato.Entities.Books;
import SalvatoreAssennato.Entities.LoanedItem;
import SalvatoreAssennato.Entities.Magazines;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoanedItemDAO {
    private final EntityManager em;

    public LoanedItemDAO(EntityManager em) {
        this.em = em;
    }
    public void save(LoanedItem loanedItem) {

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(loanedItem);

        transaction.commit();
    }

    public LoanedItem findByid(long id) {
        return em.find(LoanedItem.class, id);
    }


    // Metodo per eliminare il libro o rivista tramite il suo id
    public void findByIdAndDelete(long id) {
        LoanedItem found = this.findByid(id);
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

    //Metodo per ricercare un libro o una rivista tramite l'anno di pubblicazione
    public List<LoanedItem> findByYearPubblication(int year){
        //noi utilizziamo una TypedQuery per avere una query tipizzata
        //IMPORTANTE:in questo caso è necessario indicare il tipo di elemento ritornato come secondo argomento(ES:LoanedItem.class)
        // il metodo EXTRACT:e un metodo sql che ci consente di estrarre l'anno da una data specifica
        //questa è una query di tipo dinamico, e si fa tramite createQuery dove dentro va fatta la query
        TypedQuery<LoanedItem> getYearPubblication=em.createQuery("SELECT l FROM LoanedItem l WHERE EXTRACT(YEAR FROM l.yearPublished) = :year",LoanedItem.class);
        //dopo aver definito la query e necessario utilizzare il serParameter per impostare una corrispondenza tra il parametro della query e il parametro del metodo
        getYearPubblication.setParameter("year",year);
        return getYearPubblication.getResultList();
    }


    //Metodo per ricercare un libro o una rivista tramite il suo titolo
    public List<LoanedItem> findByTitle(String title) {
        // Alternativamente alla TypedQuery potrei utilizzare Query ma così non avrei certezza sui tipi
        //questa è una named query:le named query vengo definite sopra la loro classe di riferimento
        // quindi nel DAO non dobbiamo scrivere la query ma dobbiamo solo richiamarne il nome
        TypedQuery<LoanedItem> getLoanedItemByTitle = em.createNamedQuery("findBYTitle", LoanedItem.class);
        getLoanedItemByTitle.setParameter("title", title);
        return getLoanedItemByTitle.getResultList();
    }
    //Metodo per ricercare un autore di un  libro o di una rivista
    public List<Books> findByAuthor(String author){
        TypedQuery<Books> getLoanedItemByAuthor= em.createQuery("SELECT a FROM Books a WHERE a.author= :author", Books.class);
        getLoanedItemByAuthor.setParameter("author",author);
        return getLoanedItemByAuthor.getResultList();
    }
}
