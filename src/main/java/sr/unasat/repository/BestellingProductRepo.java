package sr.unasat.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import sr.unasat.entity.Bestelling;
import sr.unasat.entity.BestellingProduct;
import sr.unasat.mapper.ProductDTOMapper;
import sr.unasat.service.ProductService;

import java.util.List;

public class BestellingProductRepo {
    private final EntityManager entityManager;
    private final ProductDTOMapper productDTOMapper = new ProductDTOMapper();

    public BestellingProductRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<BestellingProduct> getBestellingProduct(Bestelling bestelling) {
        String getproducts = "select b from BestellingProduct b where b.bestelling = :bestelling";
        Query query = entityManager.createQuery(getproducts);
        query.setParameter("bestelling", bestelling);
        List<BestellingProduct> results = query.getResultList();
        return results;
    }
    public void createBestellingProduct(Bestelling bestelling, List<String> product, List<Integer> amount) {
        ProductService ps = new ProductService(productDTOMapper);

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

//    public List<BestellingProduct> getAllBestellingProduct() {
//        String query = "select b from BestellingProduct b";
//        TypedQuery<BestellingProduct> typedQuery = entityManager.createQuery(query, BestellingProduct.class);
//        return typedQuery.getResultList();
//    }

    public List<BestellingProduct> getAllBestellingProductenDetail() {
        String getBestellingDetail = "select bp.id, b.bestellingDatum, k.voornaam, k.achternaam, k.telefoon, b.id, b.leveringDatum, bp.product.naam, bp.amount " +
                "from BestellingProduct bp " +
                "inner join Bestelling b on bp.bestelling.id = b.id " +
                "inner join Klant k on b.klant.id = k.id";
        Query query = entityManager.createQuery(getBestellingDetail);
        Object singleResult = query.getResultList();
        return (List<BestellingProduct>) singleResult;
    }

    public List<BestellingProduct> getFullBestellingProductById(int bestellingid) {
        String findBestelling = "select bp.id, b.bestellingDatum, k.voornaam, k.achternaam, k.telefoon, b.id, b.leveringDatum, bp.product.naam, bp.amount " +
                "from BestellingProduct bp " +
                "inner join Bestelling b on bp.bestelling.id = b.id " +
                "inner join Klant k on b.klant.id = k.id " +
                "where b.id = :bestellingid";
        Query query = entityManager.createQuery(findBestelling);
        query.setParameter("bestellingid", bestellingid);
        Object bList = query.getResultList();
        return (List<BestellingProduct>) bList;
    }

    public List<BestellingProduct> getBestellingProduct(int bestellingid) {
        String getproducts = "select b from BestellingProduct b where b.bestelling.id = :bestellingid";
        Query query = entityManager.createQuery(getproducts);
        query.setParameter("bestellingid", bestellingid);
        List<BestellingProduct> results = query.getResultList();
        return results;
    }

    public List<BestellingProduct> getBestellingProductById(int bestellingid) {
        String getproducts = "select b from BestellingProduct b where b.id = :bestellingid";
        Query query = entityManager.createQuery(getproducts);
        query.setParameter("bestellingid", bestellingid);
        List<BestellingProduct> results = query.getResultList();
        return results;
    }

    public BestellingProduct findBestellingProductByid(int id) {
        BestellingProduct bestellingProduct = entityManager.find(BestellingProduct.class, id);
        if (bestellingProduct == null) {
            throw new EntityNotFoundException("Can't find BestellingProduct for ID "
                    + id);
        }
        return bestellingProduct;
    }

    public void deleteBestellingProduct(int id) {
        try {
            entityManager.getTransaction().begin();
            List<BestellingProduct> bestellingProductList = getBestellingProduct(id);
            for (int i = 0; i < bestellingProductList.size(); i++) {
                entityManager.remove(bestellingProductList.get(i));
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }



    public BestellingProduct updateBestellingProduct(int id, String product, int amount) {
        try {
            entityManager.getTransaction().begin();
            BestellingProduct bestellingProduct = findBestellingProductByid(id);
            ProductService productService = new ProductService(productDTOMapper);
            bestellingProduct.setProduct(productService.findProductByName(product));
            bestellingProduct.setAmount(amount);
            entityManager.persist(bestellingProduct);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

}
