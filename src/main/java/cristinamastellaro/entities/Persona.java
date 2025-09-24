package cristinamastellaro.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "people")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Sesso sex;
    @OneToMany(mappedBy = "person")
    private List<Partecipazione> eventPartecipation;

    public Persona() {
    }

    public Persona(String name, String surname, String email, LocalDate birthday, Sesso sex) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.eventPartecipation = new ArrayList<>();
    }

    public Persona(String name, String surname, String email, LocalDate birthday, Sesso sex, List<Partecipazione> eventPartecipation) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.eventPartecipation = eventPartecipation;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sesso getSex() {
        return sex;
    }

    public void setSex(Sesso sex) {
        this.sex = sex;
    }

    public List<Partecipazione> getEventPartecipation() {
        return eventPartecipation;
    }

    public void setEventPartecipation(List<Partecipazione> eventPartecipation) {
        this.eventPartecipation = eventPartecipation;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
