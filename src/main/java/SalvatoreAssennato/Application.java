package SalvatoreAssennato;

import SalvatoreAssennato.DAO.*;
import SalvatoreAssennato.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_catalogo");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BooksDAO bd = new BooksDAO(em);
        MagazinesDAO md=new MagazinesDAO(em);
        UserDAO ud=new UserDAO(em);
        LoanDAO ld=new LoanDAO(em);
        LoanedItemDAO lid=new LoanedItemDAO(em);
        //lid.findByTitle("il_Signore_Degli_Anelli").forEach(System.out::println);

        Books il_Signore_Degli_Anelli=new Books("le due torri", LocalDate.of(2004,2,4),700,"J. R. R. Tolkien", Geners.FANTASY);
        //bd.save(il_Signore_Degli_Anelli);
        Books book_Hoobit=new Books("lo Hobbit",LocalDate.of(2000,3,15),500,"J. R. R. Tolkien",Geners.FANTASY);
        //bd.save(book_Hoobit);

        Magazines rivistaHorror=new Magazines("the dark side",LocalDate.of(1991,1,12),200,Periodicity.SETTIMANALE);
        //md.save(rivistaHorror);
        Magazines rivistCuriosita=new Magazines("Focus",LocalDate.of(2018,4,15),200,Periodicity.MENSILE);
        //md.save(rivistCuriosita);


        User Luca=new User("Luca","Bianchi",LocalDate.of(2002,8,24));
        //ud.save(Luca);

        User Marco=new User("Marco","Rossi",LocalDate.of(2003,5,12));
        //ud.save(Marco);

        //*************Aggiunto un prestito***************
        Loan uno=new Loan(Luca,il_Signore_Degli_Anelli,LocalDate.now(),LocalDate.now().plusDays(30),LocalDate.now().plusDays(20));
        //ld.save(uno);

        //*********** Libro eliminato tramite il suo id************
        //lid.findByIdAndDelete(24);
        //*********** Rivista trovata tramite anno di pubblicazione*****************
        List<LoanedItem> rivisteTrovateDaDb= lid.findByYearPubblication(2018);
        rivisteTrovateDaDb.forEach(System.out::println);
        //*********** Libro trovato tramite anno di pubblicazione*****************
        List<LoanedItem> libroTrovateDaDb= lid.findByYearPubblication(2004);
        libroTrovateDaDb.forEach(System.out::println);
        //*********** Rivista trovato tramite il suo titolo*****************
        List<LoanedItem>elementiPerTitolo=lid.findByTitle("the dark side");
        elementiPerTitolo.forEach(System.out::println);
        //*********** Libro trovato tramite il suo autore*****************
        List<Books>autoreTrovatoDaDb=lid.findByAuthor("J. R. R. Tolkien");
        autoreTrovatoDaDb.forEach(System.out::println);

        em.close();
        emf.close();

    }
}
