package sr.unasat.dto;

import java.util.List;

public class BestellingDTO {

    private int id;
    private List<String> product;
    private List<Integer> amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public void setAmount(List<Integer> amount) {
        this.amount = amount;
    }
}
