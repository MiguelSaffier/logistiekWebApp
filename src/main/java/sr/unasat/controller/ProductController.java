package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sr.unasat.dto.ProductDTO;
import sr.unasat.entity.Product;
import sr.unasat.mapper.ProductDTOMapper;
import sr.unasat.service.ProductService;

import java.util.List;

@Path("/product")
public class ProductController {

    ProductDTOMapper productDTOMapper = new ProductDTOMapper();
    ProductService productService = new ProductService(productDTOMapper);

    @Path("/get_producten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> beschikbareProducten() {
        return productService.getAllProducts();
    }


    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product add(Product product) {
        return productService.createProduct(product);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(Product product) {
        productService.deleteProduct(product);
    }


    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product update(Product product) {
        return productService.updateProduct(product);
    }

    @Path("/find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product findDier(Product product) {
        return productService.findProductById(product.getId());
    }


}
