package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.dto.BestellingDTO;
import sr.unasat.entity.Bestelling;
import sr.unasat.entity.BestellingProduct;
import sr.unasat.service.BestellingProductService;
import sr.unasat.service.BestellingService;

import java.util.List;

@Path("/bestellingproduct")
public class BestellingProductController {

    BestellingProductService bestellingProductService = new BestellingProductService();
    BestellingService bestellingService = new BestellingService();

    @Path("/get_bestelling_detail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BestellingProduct> getFullBestellingProduct() {
        return bestellingProductService.getFullBestellingProducten();
    }

    @Path("/get_bestelling_product/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBestellingProductById(@PathParam("id") int id) {
        List<BestellingProduct> bestellingProduct = bestellingProductService.getBestellingProduct(id);
        if (bestellingProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(bestellingProduct).build();
        }
    }

    @Path("/get_bestelling_detail/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BestellingProduct> getFullBestellingProductById(@PathParam("id") int id) {
        return bestellingProductService.getFullBestellingProductById(id);
    }


    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(BestellingDTO bestellingDTO) {
        Bestelling bestelling = bestellingService.findBestellingById(bestellingDTO.getId());
        bestellingProductService.createBestellingProduct(bestelling, bestellingDTO.getProduct(), bestellingDTO.getAmount());
    }


    @Path("/updateBestellingProduct")
    @PUT
    public Response updateBestellingProduct(@QueryParam("id") int id,
                                @QueryParam("product") String product,
                                @QueryParam("amount") int amount) {
        BestellingProduct bestellingProduct = bestellingProductService.updateBestellingProduct(id, product, amount);
        if (bestellingProduct == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }



}
