package cristinamastellaro;

import cristinamastellaro.dao.EventoDAO;
import cristinamastellaro.dao.LocationDAO;
import cristinamastellaro.dao.PartecipazioneDAO;
import cristinamastellaro.dao.PersonaDAO;
import cristinamastellaro.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ge");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        LocationDAO lDao = new LocationDAO(em);
        Location location1 = new Location("Campo di Girasoli", "PD");
        Location location2 = new Location("Torre del cielo", "MI");
        Location location3 = new Location("Colosseo", "RO");
        lDao.save(location1);
        lDao.save(location3);
        lDao.save(location2);

        EventoDAO eventoDao = new EventoDAO(em);
        Evento evento1 = new Evento("Musica sotto le stelle", LocalDate.now().plusMonths(1), EventType.PUBBLICO, 250, location1);
        Evento evento2 = new Evento("Passeggiata notturna tra arte e musica", LocalDate.now().plusMonths(4), EventType.PUBBLICO, 10000, location2);
        Evento evento3 = new Evento("Artisti nel glicine", LocalDate.now().plusMonths(3), EventType.PRIVATO, 150, location1);
        eventoDao.save(evento1);
        eventoDao.save(evento2);
        eventoDao.save(evento3);

        PersonaDAO pDao = new PersonaDAO(em);
        Persona person1 = new Persona("Gino", "Paoli", "gino@paoli", LocalDate.of(1958, 11, 30), Sesso.M, new ArrayList<>());
        Persona person2 = new Persona("Pina", "Gini", "pina@gini", LocalDate.of(1975, 7, 7), Sesso.F, new ArrayList<>());
        Persona person3 = new Persona("Sara", "Saretti", "sara@saretti", LocalDate.of(2004, 1, 9), Sesso.F, new ArrayList<>());
        Persona person4 = new Persona("Carlo", "Sofficini", "carlo@sofficini", LocalDate.of(1940, 12, 31), Sesso.M, new ArrayList<>());
        pDao.save(person1);
        pDao.save(person2);
        pDao.save(person3);
        pDao.save(person4);

        PartecipazioneDAO partDao = new PartecipazioneDAO(em);
        Partecipazione part1 = new Partecipazione(person1, evento1, StatoPartecipazione.CONFERMATO);
        Partecipazione part2 = new Partecipazione(person2, evento1, StatoPartecipazione.DA_CONFERMARE);
        Partecipazione part3 = new Partecipazione(person4, evento2, StatoPartecipazione.CONFERMATO);
        partDao.save(part1);
        partDao.save(part2);
        partDao.save(part3);
    }
}
