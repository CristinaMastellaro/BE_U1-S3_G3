package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concerts")
@Table(name = "concerts")
public class Concerto extends Evento {

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean streaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, EventType tipoEvento, int maxNumPartecipanti, Location location, Genere genere, boolean streaming) {
        super(titolo, dataEvento, tipoEvento, maxNumPartecipanti, location);
        this.genere = genere;
        this.streaming = streaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", streaming=" + streaming +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", maxNumPartecipanti=" + maxNumPartecipanti +
                ", location=" + location +
                '}';
    }
}
