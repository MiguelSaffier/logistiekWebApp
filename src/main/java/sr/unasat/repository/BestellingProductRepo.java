package sr.unasat.repository;

import sr.unasat.entity.Bestelling;
import sr.unasat.entity.BestellingProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sr.unasat.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class BestellingProductRepo {
    private final EntityManager entityManager;

    public BestellingProductRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createBestellingProduct(Bestelling bestelling, List<String> product, List<Integer> amount) {
        ProductService ps = new ProductService();

        for (int i = 0; i < product.size(); i++) {
            BestellingProduct bestellingProduct = new BestellingProduct();
            entityManager.getTransaction().begin();

            bestellingProduct.setBestelling(bestelling);
            bestellingProduct.setProduct(ps.findProductByName(product.get(i)));
            bestellingProduct.setAmount(amount.get(i));

            entityManager.persist(bestellingProduct);
            entityManager.getTransaction().commit();
        }
    }

    public List<BestellingProduct> getBestellingProduct(Bestelling bestelling){
        List<BestellingProduct> bestellingProducts = new ArrayList<>();

        String getproducts = "select b from BestellingProduct b where b.bestelling = :bestelling";
        Query query = entityManager.createQuery(getproducts);
        query.setParameter("bestelling", bestelling);
        List<BestellingProduct> results = query.getResultList();
        return results;
    }

    public List<BestellingProduct> getBestellingProduct(int bestellingid){
        List<BestellingProduct> bestellingProducts = new ArrayList<>();

        String getproducts = "select b from BestellingProduct b where b.bestelling = :bestellingid";
        Query query = entityManager.createQuery(getproducts);
        query.setParameter("bestellingid", bestellingid);
        List<BestellingProduct> results = query.getResultList();
        return results;
    }


}
