package sr.unasat.entity;

import jakarta.persistence.*;
@Entity
public class Chauffeur {
    @Id
    @GeneratedValue
    private int id;
    private String voornaam;
    private String achternaam;
    private String telefoon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    @Override
    public String toString() {
        return "Chauffeur " +
                "id = " + id +
                ", voornaam = '" + voornaam + '\'' +
                ", achternaam = '" + achternaam + '\'' +
                ", telefoon = '" + telefoon + '\'' ;
    }
}
