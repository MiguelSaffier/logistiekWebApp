package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Product;
import sr.unasat.repository.ProductRepo;

import java.util.List;

public class ProductService {

    private final ProductRepo repository;

    public ProductService() {
        this.repository = new ProductRepo(JPAConfiguration.getEntityManager());
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public Product createProduct(String naam, double prijs, String adres) {
        return repository.createProduct(naam, prijs, adres);
    }

    public Product createProduct(Product product) {
        return repository.createProduct(product);
    }

    public Product findProductByName(String productName) {
        return repository.findOneProduct(productName);
    }

    public Product findProductById(int id) {
        return repository.findOneProductbyId(id);
    }

    public void updatePrijs(int id, double prijs) {
        repository.updatePrijs(id, prijs);
    }

    public Product updateProduct(Product product) {
        return repository.updateProduct(product);
    }

    public void updateAdres(int id, String adres) {
        repository.updateAdres(id, adres);
    }

    public void deleteProduct(int id) {
        repository.deleteProduct(id);
    }

    public void deleteProduct(Product product) {
        repository.deleteProduct(product);
    }

//    public void deleteProduct(Product product) {
//        sr.unasat.repository.deleteProduct(product.getId());
//    }

//    3 delete scenarios, welke is beter? welke is sneller?

}
