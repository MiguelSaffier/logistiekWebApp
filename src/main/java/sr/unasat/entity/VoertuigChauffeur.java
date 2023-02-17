package sr.unasat.entity;

import jakarta.persistence.*;


@Entity
public class VoertuigChauffeur {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Levering levering;

    @ManyToOne(fetch = FetchType.LAZY)
    private Chauffeur chauffeur;

    @ManyToOne(fetch = FetchType.LAZY)
    private VrachtWagen vrachtWagen;

    private double leveringskosten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Levering getLevering() {
        return levering;
    }

    public void setLevering(Levering levering) {
        this.levering = levering;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public VrachtWagen getVrachtWagen() {
        return vrachtWagen;
    }

    public void setVrachtWagen(VrachtWagen vrachtWagen) {
        this.vrachtWagen = vrachtWagen;
    }

    public double getLeveringskosten() {
        return leveringskosten;
    }

    public void setLeveringskosten(double leveringskosten) {
        this.leveringskosten = leveringskosten;
    }

}
