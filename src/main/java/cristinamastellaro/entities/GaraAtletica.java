package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("athletics_competitions")
@Table(name = "athletics_competitions")
public class GaraAtletica extends Evento {

    @Column(name = "athletes")
    @ManyToMany
    @JoinTable(name = "gara_atletica_atleti",
            joinColumns = @JoinColumn(name = "athlete_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Persona> atleti = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "winner")
    private Persona vincitore;

    public GaraAtletica() {
    }

    ;

    public GaraAtletica(LocalDate dataEvento, EventType tipoEvento, Location location, Set<Persona> atleti, Persona vincitore) {
        super("Gara di atletica a " + location, dataEvento, tipoEvento, 1500, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", maxNumPartecipanti=" + maxNumPartecipanti +
                ", location=" + location +
                '}';
    }
}
