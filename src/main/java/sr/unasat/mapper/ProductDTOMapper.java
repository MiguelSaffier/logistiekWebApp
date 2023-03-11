package sr.unasat.mapper;

import sr.unasat.dto.ProductDTO;
import sr.unasat.entity.Product;

import java.util.function.Function;

public class ProductDTOMapper implements Function<Product, ProductDTO> {

    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(product.getId(), product.getNaam(), product.getPrijs(), product.getAdres(), product.getImage());
    }
}
