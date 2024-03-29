package sr.unasat.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Entity
@NaturalIdCache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @NaturalId
    private String naam;

    private double prijs;   //prijs per cub
    private String adres;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] image;


//    @OneToMany(mappedBy = "product")
//    private List<BestellingProduct> bestellingen = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

//    public List<BestellingProduct> getBestellingen() {
//        return bestellingen;
//    }

//    public void setBestellingen(List<BestellingProduct> bestellingen) {
//        this.bestellingen = bestellingen;
//    }

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
        return "Product " +
                "id = " + id +
                ", naam = '" + naam + '\'' +
                ", prijs = " + prijs +
                ", adres = '" + adres + '\'';
    }

}
