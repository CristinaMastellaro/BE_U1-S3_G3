package cristinamastellaro;

import cristinamastellaro.dao.EventoDAO;
import cristinamastellaro.dao.PersonaDAO;
import cristinamastellaro.entities.GaraAtletica;
import cristinamastellaro.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ge");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

//        LocationDAO lDao = new LocationDAO(em);
//        Location location1 = new Location("Campo di Girasoli", "PD");
//        Location location2 = new Location("Stadi odi San Siro", "MI");
//        Location location3 = new Location("Colosseo", "RO");
//        lDao.save(location1);
//        lDao.save(location3);
//        lDao.save(location2);

        PersonaDAO pDao = new PersonaDAO(em);
//        Persona person1 = new Persona("Gino", "Paoli", "gino@paoli", LocalDate.of(1958, 11, 30), Sesso.M, new ArrayList<>());
//        Persona person2 = new Persona("Pina", "Gini", "pina@gini", LocalDate.of(1975, 7, 7), Sesso.F, new ArrayList<>());
//        Persona person3 = new Persona("Sara", "Saretti", "sara@saretti", LocalDate.of(2004, 1, 9), Sesso.F, new ArrayList<>());
//        Persona person4 = new Persona("Carlo", "Sofficini", "carlo@sofficini", LocalDate.of(1940, 12, 31), Sesso.M, new ArrayList<>());
//        Persona person5 = new Persona("Vittorio", "Maniscalco", "vittorio@man", LocalDate.of(2000, 8, 12), Sesso.M, new ArrayList<>());
//        Persona person6 = new Persona("Amanda", "Amandi", "a@A", LocalDate.of(1999, 2, 6), Sesso.F, new ArrayList<>());
//        Persona person7 = new Persona("Agnese", "De Lupi", "ag@del", LocalDate.of(1986, 6, 30), Sesso.F, new ArrayList<>());
//        pDao.save(person1);
//        pDao.save(person2);
//        pDao.save(person3);
//        pDao.save(person4);
//        pDao.save(person5);
//        pDao.save(person6);
//        pDao.save(person7);
//
//        HashSet<Persona> partecipanti1 = new HashSet<>(Arrays.asList(person1, person4, person3));
//        HashSet<Persona> partecipanti2 = new HashSet<>(Arrays.asList(person2, person5, person7));
//        HashSet<Persona> partecipanti3 = new HashSet<>(Arrays.asList(person6, person3, person2));
//
        EventoDAO eventoDao = new EventoDAO(em);
//        Evento evento10 = new Evento("Musica sotto le stelle", LocalDate.now().plusMonths(1), EventType.PUBBLICO, 250, location1);
//        Evento evento20 = new Evento("Passeggiata notturna tra arte e musica", LocalDate.now().plusMonths(4), EventType.PUBBLICO, 10000, location2);
//        Evento evento30 = new Evento("Artisti nel glicine", LocalDate.now().plusMonths(3), EventType.PRIVATO, 150, location1);
//        PartitaCalcio evento1 = new PartitaCalcio(LocalDate.of(2025, 12, 6), EventType.PUBBLICO, location1, "Padova", "Vicenza", "Padova", 2, 0);
//        PartitaCalcio evento2 = new PartitaCalcio(LocalDate.of(2025, 10, 20), EventType.PUBBLICO, location2, "Verona", "Brescia", null, 1, 1);
//        PartitaCalcio evento3 = new PartitaCalcio(LocalDate.of(2025, 11, 8), EventType.PUBBLICO, location2, "Milan", "Juventus", "Juventus", 0, 1);
//        GaraAtletica evento4 = new GaraAtletica(LocalDate.of(2026, 1, 10), EventType.PRIVATO, location3, partecipanti1, person4);
//        GaraAtletica evento5 = new GaraAtletica(LocalDate.of(2025, 12, 20), EventType.PUBBLICO, location1, partecipanti2, person2);
//        GaraAtletica evento6 = new GaraAtletica(LocalDate.of(2025, 10, 10), EventType.PRIVATO, location3, partecipanti3, person2);
//        Concerto evento7 = new Concerto("Beethoven: le migliore sinfonie", LocalDate.of(2025, 10, 7), EventType.PUBBLICO, 600, location1, Genere.CLASSICO, false);
//        Concerto evento8 = new Concerto("Put your boots on", LocalDate.of(2025, 9, 27), EventType.PUBBLICO, 150, location3, Genere.COUNTRY, false);
//        Concerto evento9 = new Concerto("Kiss in concerto: Stick your tongue out", LocalDate.of(2025, 12, 1), EventType.PUBBLICO, 2600, location2, Genere.METAL, true);
//        eventoDao.save(evento10);
//        eventoDao.save(evento20);
//        eventoDao.save(evento30);
//        eventoDao.save(evento1);
//        eventoDao.save(evento2);
//        eventoDao.save(evento3);
//        eventoDao.save(evento4);
//        eventoDao.save(evento5);
//        eventoDao.save(evento6);
//        eventoDao.save(evento7);
//        eventoDao.save(evento8);
//        eventoDao.save(evento9);

//        PartecipazioneDAO partDao = new PartecipazioneDAO(em);
//        Partecipazione part1 = new Partecipazione(person1, evento1, StatoPartecipazione.CONFERMATO);
//        Partecipazione part2 = new Partecipazione(person2, evento1, StatoPartecipazione.DA_CONFERMARE);
//        Partecipazione part3 = new Partecipazione(person4, evento2, StatoPartecipazione.CONFERMATO);
//        Partecipazione part4 = new Partecipazione(person5, evento5, StatoPartecipazione.CONFERMATO);
//        Partecipazione part5 = new Partecipazione(person7, evento4, StatoPartecipazione.DA_CONFERMARE);
//        Partecipazione part6 = new Partecipazione(person3, evento9, StatoPartecipazione.CONFERMATO);
//        Partecipazione part7 = new Partecipazione(person3, evento8, StatoPartecipazione.CONFERMATO);
//        Partecipazione part8 = new Partecipazione(person6, evento3, StatoPartecipazione.CONFERMATO);
//        Partecipazione part9 = new Partecipazione(person4, evento9, StatoPartecipazione.CONFERMATO);
//        partDao.save(part1);
//        partDao.save(part2);
//        partDao.save(part3);
//        partDao.save(part4);
//        partDao.save(part5);
//        partDao.save(part6);
//        partDao.save(part7);
//        partDao.save(part8);
//        partDao.save(part9);

//        System.out.println("I concerti in streaming sono:");
//        List<Concerto> concertiStreaming = eventoDao.getConcertInStreaming();
//        concertiStreaming.forEach(System.out::println);

//        System.out.println("I concerti appartenenti al genere classico sono: ");
//        List<Concerto> concertiClassici = eventoDao.getConcertiPerGenere(Genere.CLASSICO);
//        concertiClassici.forEach(System.out::println);

//        System.out.println("Ecco le partite vinte dalla squadra di casa:");
//        List<PartitaCalcio> partiteVinteDallaCasa = eventoDao.getPartiteVinteInCasa();
//        partiteVinteDallaCasa.forEach(System.out::println);

//        System.out.println("Ecco le partite vinte dal Padova in casa:");
//        List<PartitaCalcio> partiteVinteDallaCasa = eventoDao.getPartiteVinteInCasa("Padova");
//        partiteVinteDallaCasa.forEach(System.out::println);

//        System.out.println("Ecco le partite vinte dalla squadra ospite:");
//        List<PartitaCalcio> partiteVinteInTrasferta = eventoDao.getPartiteVinteInTrasferta("Juventus");
//        partiteVinteInTrasferta.forEach(System.out::println);
//
//        System.out.println("Ecco le partite vinte dalla Juventus in trasferta:");
//        List<PartitaCalcio> partiteVinteDallaTrasferta = eventoDao.getPartiteVinteDallaTrasferta();
//        partiteVinteDallaTrasferta.forEach(System.out::println);

//        System.out.println("Ecco le partite pareggiate:");
//        List<PartitaCalcio> partitePareggiate = eventoDao.getPartitePareggiate();
//        partitePareggiate.forEach(System.out::println);

        Persona winner = pDao.findById("23fa99ce-de85-4139-9a90-4d54e07ef5b2");
        System.out.println("Le gare a cui " + winner.getName() + " ha partecipato sono:");
        List<GaraAtletica> partecipazioni = eventoDao.getGareDiAtleticaPerPartecipante(winner);
        partecipazioni.forEach(System.out::println);
//        System.out.println(eventoDao.getById("9ae8813b-0b3f-4212-899f-1dd4293f234b"));


    }
}
