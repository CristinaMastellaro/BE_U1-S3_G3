package cristinamastellaro;

import cristinamastellaro.dao.EventoDAO;
import cristinamastellaro.entities.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ge");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventoDAO eventDao = new EventoDAO(em);
        eventDao.save("Musica sotto le stelle", LocalDate.now(), EventType.PUBBLICO, 500);
        eventDao.save("Passeggiata notturna tra arte e musica", LocalDate.now().plusMonths(4), EventType.PUBBLICO, 10000);
        eventDao.save("Artisti nel glicine", LocalDate.now().plusMonths(3), EventType.PRIVATO, 150);

    }
}
