package cristinamastellaro.dao;

import cristinamastellaro.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona person) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(person);
        et.commit();
        System.out.println(person.getName() + " è stata registrata!");
    }

    public Persona findById(String id) {
        UUID idUUID = UUID.fromString(id);
        try {
            return em.find(Persona.class, idUUID);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
