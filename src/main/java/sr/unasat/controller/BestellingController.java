package sr.unasat.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.entity.Bestelling;
import sr.unasat.service.BestellingProductService;
import sr.unasat.service.BestellingService;

import java.util.List;

@Path("/bestelling")
public class BestellingController {


    BestellingService bestellingService = new BestellingService();
    BestellingProductService bestellingProductService = new BestellingProductService();

    @Path("/get_bestellingen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bestelling> alleBestellingen() {
        return bestellingService.getBestellingDetail();
    }

    @Path("/get_bestelling/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bestelling> allBestellingDetail(@PathParam("id") int id){return bestellingService.getBestellingDetail(id);}

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Bestelling add(@QueryParam("klantId") int id,
                          @QueryParam("year") int jaar,
                          @QueryParam("month") int maand,
                          @QueryParam("day") int dag) {
        return bestellingService.createBestelling(id, jaar, maand, dag);
    }


    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBestellingById(@PathParam("id") int id) {
        Bestelling bestelling = bestellingService.findBestellingById(id);
        if (bestelling == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(bestelling).build();
        }
    }

    @Path("/remove/{id}")
    @DELETE
    public Response remove(@PathParam("id") int id) {
        bestellingProductService.deleteBestellingProduct(id);
        bestellingService.deleteBestelling(id);
        return Response.noContent().build();
    }


    @Path("/updateLeveringDatum")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLeveringDatum(@QueryParam("id") int id,
                                        @QueryParam("jaar") int jaar,
                                        @QueryParam("maand") int maand,
                                        @QueryParam("dag") int dag) {
        Bestelling bestelling = bestellingService.updateLeveringDatum(id, jaar, maand, dag);
        if (bestelling == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(bestelling).build();
        }
    }

}
