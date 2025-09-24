package cristinamastellaro.dao;

import cristinamastellaro.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazione);
        et.commit();
        try {
            List<Partecipazione> partecipationsAlreadyPresent = new ArrayList<>();
            if (partecipazione.getPerson().getEventPartecipation() != null) {
                partecipationsAlreadyPresent.addAll(partecipazione.getPerson().getEventPartecipation());
            }
            partecipationsAlreadyPresent.add(partecipazione);
            partecipazione.getPerson().setEventPartecipation(partecipationsAlreadyPresent);
            PersonaDAO pDao = new PersonaDAO(em);
            pDao.save(partecipazione.getPerson());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("L'evento " + partecipazione.getEvent().getTitolo() + " è stato salvato per " + partecipazione.getPerson().getName());
    }

    public Partecipazione findById(String id) {
        UUID idUUID = UUID.fromString(id);
        try {
            return em.find(Partecipazione.class, idUUID);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
