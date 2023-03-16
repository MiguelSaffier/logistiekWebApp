package sr.unasat.dto;

public class VoertuigChauffeurDTO {

    private int leveringId;
    private int bestellingId;

    public int getLeveringId() {
        return leveringId;
    }

    public void setLeveringId(int leveringId) {
        this.leveringId = leveringId;
    }

    public int getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }
}
