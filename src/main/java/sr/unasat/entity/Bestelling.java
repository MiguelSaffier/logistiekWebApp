package sr.unasat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue
    private int id;

    private String bestellingDatum;

    private String leveringDatum;

    @ManyToOne
    private Klant klant;

//    @OneToMany(mappedBy = "bestelling")
//    private List<BestellingProduct> producten = new ArrayList<>();

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

    public String getLeveringDatum() {
        return leveringDatum;
    }

    public void setLeveringDatum(String leveringDatum) {
        this.leveringDatum = leveringDatum;
    }

    public String getBestellingDatum() {
        return bestellingDatum;
    }

    public void setBestellingDatum(String bestellingDatum) {
        this.bestellingDatum = bestellingDatum;
    }

//    public List<BestellingProduct> getProducten() {
//        return producten;
//    }
//
//    public void setProducten(List<BestellingProduct> producten) {
//        this.producten = producten;
//    }

    @Override
    public String toString() {
        return "Bestelling: " +
                "id = " + id +
                ", bestellingDatum = " + bestellingDatum +
                ", leveringDatum = " + leveringDatum +
                ", klant = " + klant;
    }
}
