package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Persona person;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Evento event;
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione state;

    public Partecipazione() {
    }

    public Partecipazione(Persona person, Evento event, StatoPartecipazione state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public StatoPartecipazione getState() {
        return state;
    }

    public void setState(StatoPartecipazione state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", state=" + state +
                '}';
    }
}
