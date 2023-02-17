package sr.unasat.dto;

public class ProductDTO {

        private int id;
        private String naam;
        private double prijs;
        private String adres;

    public ProductDTO(int id, String naam, double prijs, String adres) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.adres = adres;
    }

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
}
