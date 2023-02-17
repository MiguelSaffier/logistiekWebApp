package sr.unasat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Klant implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String voornaam;
    private String achternaam;
    private String adres;
    private String telefoon;

    @OneToMany(mappedBy = "klant" )
    private List<Bestelling> bestelling;

    public int getId() {
        return id;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    @Override
    public String toString() {
        return "Klant " +
                "id = " + id +
                ", voornaam = '" + voornaam + '\'' +
                ", achternaam = '" + achternaam + '\'' +
                ", adres = '" + adres + '\'' +
                ", telefoon = '" + telefoon + '\'';
    }
}
