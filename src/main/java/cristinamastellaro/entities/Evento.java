package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventType tipoEvento;
    @Column(name = "max_num_partecipanti")
    private int maxNumPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

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