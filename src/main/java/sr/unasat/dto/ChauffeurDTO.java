package sr.unasat.dto;

public class ChauffeurDTO {

    private int id;
    private String voornaam;
    private String achternaam;
    private String telefoon;

    public ChauffeurDTO(int id, String voornaam, String achternaam, String telefoon) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
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

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }
}
