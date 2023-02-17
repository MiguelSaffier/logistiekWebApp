package sr.unasat.dto;

public class VrachtWagenDTO {

    private int id;
    private String merk;
    private int capaciteit;
    private String kentekenNummer;

    public VrachtWagenDTO(int id, String merk, int capaciteit, String kentekenNummer) {
        this.id = id;
        this.merk = merk;
        this.capaciteit = capaciteit;
        this.kentekenNummer = kentekenNummer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public String getKentekenNummer() {
        return kentekenNummer;
    }

    public void setKentekenNummer(String kentekenNummer) {
        this.kentekenNummer = kentekenNummer;
    }
}
