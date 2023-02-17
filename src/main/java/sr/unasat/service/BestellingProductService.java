package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Bestelling;
import sr.unasat.entity.BestellingProduct;
import sr.unasat.repository.BestellingProductRepo;

import java.util.List;

public class BestellingProductService {

    private final BestellingProductRepo repository;

    public BestellingProductService() {
        this.repository = new BestellingProductRepo(JPAConfiguration.getEntityManager());
    }

    public void createBestellingProduct(Bestelling bestelling, List<String> product, List<Integer> amount){
        repository.createBestellingProduct(bestelling, product, amount);
    }

    public List<BestellingProduct> getBestellingProduct(Bestelling bestelling){
        return repository.getBestellingProduct(bestelling);
    }

}
