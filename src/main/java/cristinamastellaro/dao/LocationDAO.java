package cristinamastellaro.dao;

import cristinamastellaro.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(location);
        et.commit();
        System.out.println("La location " + location.getName() + " è stata salvata!");
    }

    public Location findById(String id) {
        UUID idUUID = UUID.fromString(id);
        try {
            Location found = em.find(Location.class, idUUID);
            return found;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
