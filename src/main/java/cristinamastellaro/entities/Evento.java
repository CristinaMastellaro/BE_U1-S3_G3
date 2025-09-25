package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "event_type")

@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT pc FROM PartitaCalcio pc WHERE pc.squadraVincente = pc.squadraCasa AND :squadra = pc.squadraCasa")
@NamedQuery(name = "getPartiteVinteDallaCasa", query = "SELECT pc FROM PartitaCalcio pc WHERE pc.squadraVincente = pc.squadraCasa")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT pc FROM PartitaCalcio pc WHERE pc.squadraVincente = pc.squadraOspite AND :ospite = pc.squadraOspite")
@NamedQuery(name = "getPartiteVinteDallaTrasferta", query = "SELECT pc FROM PartitaCalcio pc WHERE pc.squadraVincente = pc.squadraOspite")
public class Evento {
    @Id
    @GeneratedValue
    protected UUID id;
    @Column(nullable = false)
    protected String titolo;
    @Column(name = "data_evento")
    protected LocalDate dataEvento;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    protected EventType tipoEvento;
    @Column(name = "max_num_partecipanti")
    protected int maxNumPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id")
    protected Location location;

    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, EventType tipoEvento, int maxNumPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.maxNumPartecipanti = maxNumPartecipanti;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public EventType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMaxNumPartecipanti() {
        return maxNumPartecipanti;
    }

    public void setMaxNumPartecipanti(int maxNumPartecipanti) {
        this.maxNumPartecipanti = maxNumPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", maxNumPartecipanti=" + maxNumPartecipanti +
                '}';
    }
}