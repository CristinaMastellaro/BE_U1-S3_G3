package cristinamastellaro.dao;

import cristinamastellaro.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
        System.out.println("Evento " + evento.getTitolo() + " salvato!");
    }

    public Evento getById(String id) {
        try {
            UUID idUUID = UUID.fromString(id);
            Evento eventoCercato = em.find(Evento.class, idUUID);
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

    public void getByIdAndDelete(String id) {
        Evento eventoCercato = this.getById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(eventoCercato);
        et.commit();
        System.out.println("Evento cancellato!");
    }

    public List<Concerto> getConcertInStreaming() {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.streaming = true", Concerto.class);
        return query.getResultList();
    }

    //    public Map<Genere, List<Concerto>> getConcertiPerGenere()
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaCalcio> getPartiteVinteDallaCasa() {
        TypedQuery<PartitaCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaCalcio.class);
        return query.getResultList();
    }

    public List<PartitaCalcio> getPartiteVinteInCasa(String squadra) {
        TypedQuery<PartitaCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaCalcio.class);
        query.setParameter("squadra", squadra);
        return query.getResultList();
    }

    public List<PartitaCalcio> getPartiteVinteDallaTrasferta() {
        TypedQuery<PartitaCalcio> query = em.createNamedQuery("getPartiteVinteDallaTrasferta", PartitaCalcio.class);
        return query.getResultList();
    }

    public List<PartitaCalcio> getPartiteVinteInTrasferta(String ospite) {
        TypedQuery<PartitaCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaCalcio.class);
        query.setParameter("ospite", ospite);
        return query.getResultList();
    }

    public List<PartitaCalcio> getPartitePareggiate() {
        TypedQuery<PartitaCalcio> query = em.createQuery("SELECT pc FROM PartitaCalcio pc WHERE pc.squadraVincente IS NULL", PartitaCalcio.class);
        return query.getResultList();
    }

    public List<GaraAtletica> getGareDiAtleticaPerVincitore(String id) {
        UUID idUUID = UUID.fromString(id);
        TypedQuery<GaraAtletica> query = em.createQuery("SELECT ga FROM GaraAtletica ga WHERE ga.vincitore.id = :vincitore_id", GaraAtletica.class);
        query.setParameter("vincitore_id", idUUID);
        return query.getResultList();
    }

    public List<GaraAtletica> getGareDiAtleticaPerPartecipante(Persona persona) {
//    public List<Persona> getGareDiAtleticaPerPartecipante(String id) {
//        UUID idUUID = UUID.fromString(id);
//        PersonaDAO pdao = new PersonaDAO(em);
        TypedQuery<GaraAtletica> query = em.createQuery("SELECT ga FROM GaraAtletica ga JOIN ga.atleti a WHERE a = :persona", GaraAtletica.class);
//        TypedQuery<Persona> query = em.createQuery("SELECT ga.atleti FROM GaraAtletica ga", Persona.class);
        query.setParameter("persona", persona);
        return query.getResultList();
    }
}