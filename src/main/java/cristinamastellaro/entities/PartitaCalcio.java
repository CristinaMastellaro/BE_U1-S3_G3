package cristinamastellaro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("football_matches")
@Table(name = "football_matches")
public class PartitaCalcio extends Evento {
    @Column(name = "home_team")
    private String squadraCasa;
    @Column(name = "away_team")
    private String squadraOspite;
    @Column(name = "winner_team")
    private String squadraVincente;
    @Column(name = "home_goals")
    private int golSCasa;
    @Column(name = "away_goals")
    private int golSOspite;

    public PartitaCalcio() {
    }

    public PartitaCalcio(LocalDate dataEvento, EventType tipoEvento, Location location, String sCasa, String sOspite, String sVincente, int golCasa, int golOspite) {
        super("Partita " + sCasa + " " + sOspite, dataEvento, tipoEvento, 1500, location);
        this.squadraCasa = sCasa;
        this.squadraOspite = sOspite;
        this.squadraVincente = sVincente;
        this.golSCasa = golCasa;
        this.golSOspite = golOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSCasa() {
        return golSCasa;
    }

    public void setGolSCasa(int golSCasa) {
        this.golSCasa = golSCasa;
    }

    public int getGolSOspite() {
        return golSOspite;
    }

    public void setGolSOspite(int golSOspite) {
        this.golSOspite = golSOspite;
    }

    @Override
    public String toString() {
        return "PartitaCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSCasa=" + golSCasa +
                ", golSOspite=" + golSOspite +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", maxNumPartecipanti=" + maxNumPartecipanti +
                ", location=" + location +
                '}';
    }
}
