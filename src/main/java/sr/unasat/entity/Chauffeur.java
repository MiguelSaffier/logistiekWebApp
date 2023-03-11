package sr.unasat.entity;

import jakarta.persistence.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Entity
public class Chauffeur {
    @Id
    @GeneratedValue
    private int id;
    private String voornaam;
    private String achternaam;
    private String telefoon;
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(String imagePath) {
        byte[] imageData;
        try {
            imageData = Files.readAllBytes(Paths.get(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.image = imageData;
    }

    @Override
    public String toString() {
        return "Chauffeur " +
                "id = " + id +
                ", voornaam = '" + voornaam + '\'' +
                ", achternaam = '" + achternaam + '\'' +
                ", telefoon = '" + telefoon + '\'' ;
    }
}
