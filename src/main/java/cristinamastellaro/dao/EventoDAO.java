package cristinamastellaro.dao;

import cristinamastellaro.entities.EventType;
import cristinamastellaro.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(String titolo, LocalDate dataEvento, EventType tipoEvento, int maxNumPartecipanti) {
        Evento evento = new Evento(titolo, dataEvento, tipoEvento, maxNumPartecipanti);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
        System.out.println("Evento " + evento.getTitolo() + " salvato!");
    }

    public Evento getById(long id) {
        try {
            Evento eventoCercato = em.find(Evento.class, id);
            if (eventoCercato == null) throw new Exception("Evento non trovato");
            else return eventoCercato;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void delete(Evento event) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(event);
        et.commit();
        System.out.println("Evento cancellato");
    }

    public void getByIdAndDelete(long id) {
        Evento eventoCercato = this.getById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(eventoCercato);
        et.commit();
        System.out.println("Evento cancellato!");
    }
}