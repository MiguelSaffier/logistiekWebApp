package sr.unasat.mapper;

import sr.unasat.dto.ProductDTO;
import sr.unasat.entity.Product;

public interface ProductMapper {


    Product toEntity(ProductDTO dto) ;

}
