package sr.unasat.entity;


import sr.unasat.factory.Voertuig;

import jakarta.persistence.*;


@Entity
public class VrachtWagen implements Voertuig {
    @Id
    @GeneratedValue
    private int id;
    private String merk;
    private int capaciteit;
    private String kentekenNummer;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getMerk() {
        return merk;
    }

    @Override
    public void setMerk(String merk) {
        this.merk = merk;
    }

    @Override
    public int getCapaciteit() {
        return capaciteit;
    }

    @Override
    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    @Override
    public String getKentekenNummer() {
        return kentekenNummer;
    }

    @Override
    public void setKentekenNummer(String kentekenNummer) {
        this.kentekenNummer = kentekenNummer;
    }


    @Override
    public String toString() {
        return "VrachtWagen " +
                "id = " + id +
                ", merk = '" + merk + '\'' +
                ", capaciteit = " + capaciteit +
                ", kentekenNummer = '" + kentekenNummer + '\'';
    }
}
