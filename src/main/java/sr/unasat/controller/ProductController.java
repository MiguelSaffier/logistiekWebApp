package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

    @Path("/get_product_image/{id}")
    @GET
    @Produces("image/jpeg")
    public byte[] getProductImage(@PathParam("id") int id) {
        return productService.getProductImage(id);
    }


    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product add(Product product){
        return productService.createProduct(product);
    }

    @Path("/remove/{id}")
    @DELETE
    public Response remove(@PathParam("id") int id) {
        productService.deleteProduct(id);
        return Response.noContent().build();
    }


    @Path("/updatePrice")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrice(@QueryParam("id") int id,
                               @QueryParam("price") double price) {
        Product product = productService.updatePrijs(id, price);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(product).build();
        }
    }

    @PUT
    @Path("/updateImage/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateImagePath(@PathParam("id") int id, String imagePath) {
        Product product = productService.updateImage(id, imagePath);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(product).build();
        }
    }

    @Path("/updateAdres")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdres(@QueryParam("id") int id,
                               @QueryParam("adres") String adres) {
        Product product = productService.updateAdres(id, adres );
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(product).build();
        }
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProductById(@PathParam("id") int id) {
        Product product = productService.findProductById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(product).build();
        }
    }


    @Path("/findByName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByFullName(@QueryParam("productName") String productName) {
        Product product = productService.findProductByName(productName);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(product).build();
        }
    }

}
