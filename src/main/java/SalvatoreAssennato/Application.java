package SalvatoreAssennato;

import SalvatoreAssennato.DAO.BooksDAO;
import SalvatoreAssennato.DAO.MagazinesDAO;
import SalvatoreAssennato.DAO.UserDAO;
import SalvatoreAssennato.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_catalogo");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BooksDAO bd = new BooksDAO(em);
        MagazinesDAO md=new MagazinesDAO(em);
        UserDAO ud=new UserDAO(em);

        Books il_Signore_Degli_Anelli=new Books("le due torri", LocalDate.of(2004,2,4),700,"J. R. R. Tolkien", Geners.FANTASY);
        //bd.save(il_Signore_Degli_Anelli);
        Books book_Hoobit=new Books("lo Hobbit",LocalDate.of(2000,3,15),500,"J. R. R. Tolkien",Geners.FANTASY);
        //bd.save(book_Hoobit);
        Magazines rivistaHorror=new Magazines("the dark side",LocalDate.of(1991,1,12),200,Periodicity.SETTIMANALE);
        md.save(rivistaHorror);
        Magazines rivistCuriosita=new Magazines("Focus",LocalDate.of(2018,4,15),200,Periodicity.MENSILE);
        md.save(rivistCuriosita);


        User Luca=new User("Luca","Bianchi",LocalDate.of(2002,8,24));
        //ud.save(Luca);

        User Marco=new User("Marco","Rossi",LocalDate.of(2003,5,12));
        //ud.save(Marco);

        em.close();
        emf.close();

    }
}
