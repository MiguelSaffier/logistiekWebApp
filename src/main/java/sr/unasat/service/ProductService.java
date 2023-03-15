package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.dto.ProductDTO;
import sr.unasat.entity.Product;
import sr.unasat.mapper.ProductDTOMapper;
import sr.unasat.repository.ProductRepo;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepo repository;
    private final ProductDTOMapper productDTOMapper;

    public ProductService(ProductDTOMapper productDTOMapper) {
        this.productDTOMapper = productDTOMapper;
        this.repository = new ProductRepo(JPAConfiguration.getEntityManager());
    }

    public List<ProductDTO> getAllProducts() {
        return repository.getAllProducts().stream().map(productDTOMapper).collect(Collectors.toList());
    }

    public byte[] getProductImage(int id){
        return repository.getProductImage(id);
    }

    public Product createProduct(String naam, double prijs, String adres, String imagePath) {
        return repository.createProduct(naam, prijs, adres, imagePath);
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

    public Product updatePrijs(int id, double prijs) {
        return repository.updatePrijs(id, prijs);
    }

    public Product updateProduct(Product product) {
        return repository.updateProduct(product);
    }

    public Product updateAdres(int id, String adres) {
       return repository.updateAdres(id, adres);
    }

    public void deleteProduct(int id) {
        repository.deleteProduct(id);
    }

    public void deleteProduct(Product product) {
        repository.deleteProduct(product);
    }

    public Product updateImage(int id, String imagePath) {
        return repository.updateImage(id, imagePath);
    }

}
