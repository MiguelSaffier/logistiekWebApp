package sr.unasat.repository;

import sr.unasat.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProductRepo {

    private Product product;

    private final EntityManager entityManager;

    public ProductRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getAllProducts() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        return typedQuery.getResultList();
    }

    public byte[] getProductImage(int id) {
     return findOneProductbyId(id).getImage();
    }

    public Product createProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }

    public Product createProduct(String naam, double prijs, String adres, String imagePath) {
        product = new Product();
        product.setNaam(naam);
        product.setPrijs(prijs);
        product.setAdres(adres);
        product.setImage(imagePath);
        return createProduct(product);
    }

    public Product findOneProduct(String productName) {
            String findProductName = "select p from Product p where p.naam = :productName";
            Query query = entityManager.createQuery(findProductName);
            query.setParameter("productName", productName);
            Object singleResult = query.getSingleResult();
            return (Product) singleResult;
    }

    public Product findOneProductbyId(int id) {
        Product product = entityManager.find(Product.class, id);
        if (product == null) {
            throw new EntityNotFoundException("Can't find product for ID "
                    + id);
        }
        return product;
    }

    public Product updatePrijs(int id, double prijs) {
        try {
            entityManager.getTransaction().begin();
            product = findOneProductbyId(id);
            product.setPrijs(prijs);
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }

    public Product updateImage(int id, String imagePath) {
        try {
            entityManager.getTransaction().begin();
            product = findOneProductbyId(id);
            product.setImage(imagePath);
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }

    public Product updateProduct(Product product){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }

    public Product updateAdres(int id, String adres) {
        try {
            entityManager.getTransaction().begin();
            product = findOneProductbyId(id);
            product.setAdres(adres);
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }

    public void deleteProduct(int id) {
        try {
            entityManager.getTransaction().begin();
            product = findOneProductbyId(id);
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public Product updateProduct(int id, String naam, double prijs, String adres, String imagePath) {
        try {
            entityManager.getTransaction().begin();
            product = findOneProductbyId(id);
            product.setPrijs(prijs);
            product.setNaam(naam);
            product.setAdres(adres);
            product.setImage(imagePath);
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }
}
