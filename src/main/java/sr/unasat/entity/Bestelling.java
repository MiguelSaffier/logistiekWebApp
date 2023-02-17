package sr.unasat.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate bestellingDatum;

    @Temporal(TemporalType.DATE)
    private Calendar leveringDatum;

    @ManyToOne
    private Klant klant;

    @OneToMany(mappedBy = "bestelling")
    private List<BestellingProduct> producten = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Calendar getLeveringDatum() {
        return leveringDatum;
    }

    public void setLeveringDatum(Calendar leveringDatum) {
        this.leveringDatum = leveringDatum;
    }

    public LocalDate getBestellingDatum() {
        return bestellingDatum;
    }

    public void setBestellingDatum(LocalDate bestellingDatum) {
        this.bestellingDatum = bestellingDatum;
    }

    public List<BestellingProduct> getProducten() {
        return producten;
    }

    public void setProducten(List<BestellingProduct> producten) {
        this.producten = producten;
    }

    @Override
    public String toString() {
        return "Bestelling: " +
                "id = " + id +
                ", bestellingDatum = " + bestellingDatum +
                ", leveringDatum = " + leveringDatum +
                ", klant = " + klant;
    }
}
