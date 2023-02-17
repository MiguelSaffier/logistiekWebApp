package sr.unasat.PostMan;

import sr.unasat.entity.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/product")
public class ProductController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> fetchAll(){
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setAdres("WanicaStraat 50G");
        product.setPrijs(10);
        product.setNaam("Ei");
        productList.add(product);
        return productList;
    }

}
