package sr.unasat.entity;

import jakarta.persistence.*;

@Entity
public class BestellingProduct {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bestelling bestelling;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BestellingProduct " +
                "id = " + id +
                ", bestelling = " + bestelling +
                ", product = " + product +
                ", amount = " + amount;
    }
}
