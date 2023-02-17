package sr.unasat.dto;

public class KlantDTO {

    private int id;
    private String voornaam;
    private String achternaam;
    private String adres;
    private String telefoon;

    public KlantDTO(int id, String voornaam, String achternaam, String adres, String telefoon) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.telefoon = telefoon;
    }

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
}
