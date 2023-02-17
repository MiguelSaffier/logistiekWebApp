package sr.unasat.entity;

import jakarta.persistence.*;

@Entity
public class Levering {
    @Id
    @GeneratedValue
    private int id;

    private String status;

    private double totaleKosten;

    @OneToOne(fetch = FetchType.EAGER)
    private Bestelling bestelling;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public double getTotaleKosten() {
        return totaleKosten;
    }

    public void setTotaleKosten(double totaleKosten) {
        this.totaleKosten = totaleKosten;
    }

    @Override
    public String toString() {
        return "Levering " +
                "id = " + id +
                ", status = '" + status + '\'' +
                ", totaleKosten = " + totaleKosten +
                ", bestelling = " + bestelling;
    }


}
