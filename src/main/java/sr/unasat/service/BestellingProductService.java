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

    public List<BestellingProduct> getBestellingProduct(int id){
        return repository.getBestellingProduct(id);
    }

//    public List<BestellingProduct> getAllBestellingProduct(){
//        return repository.getAllBestellingProduct();
//    }

    public void deleteBestellingProduct(int id){
        repository.deleteBestellingProduct(id);
    }

    public BestellingProduct updateBestellingProduct(int id, String product, int amount){
        return repository.updateBestellingProduct(id, product, amount);
    }

    public  List<BestellingProduct> getFullBestellingProducten() {
        return repository.getAllBestellingProductenDetail();
    }

    public List<BestellingProduct> getFullBestellingProductById(int bestellingid) {
        return repository.getFullBestellingProductById(bestellingid);
    }

    public BestellingProduct findBestellingProductByid(int id) {
        return (BestellingProduct) repository.getBestellingProductById(id);
    }

}
