package sr.unasat.repository;

import org.junit.jupiter.api.Test;
import sr.unasat.mapper.ProductDTOMapper;
import sr.unasat.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    ProductDTOMapper productDTOMapper = new ProductDTOMapper();
    ProductService productService = new ProductService(productDTOMapper);


//    @Test
//    void createMultipleRecords() {
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//
//        assertEquals(productService.getAllProducts().size(), 4);
//    }

//    @Test
//    void findOneRecord() {
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//
//        assertEquals(7.5, productService.findProductByName("ei").getPrijs());
//    }

//    @Test
//    void findOneRecordbyId() {
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//
//        assertEquals(7.5, productService.findProductById(3).getPrijs());
//    }
//
//    @Test
//    void updatePrijs() {
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//
//        productService.updatePrijs(2, 200);
//        assertEquals(200, productService.findProductById(2).getPrijs());
//    }
//
//    @Test
//    void updateAdres() {
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//
//        productService.updateAdres(2, "wanicaweg200");
//        assertEquals("wanicaweg200", productService.findProductById(2).getAdres());
//    }
//
//    @Test
//    void delete() {
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//
//        productService.deleteProduct(2);
//
//        assertEquals(3, productService.getAllProducts().size());
//    }


    @Test
    void getAllProducten(){
        assertEquals(1, productService.getAllProducts().size());
    }

}