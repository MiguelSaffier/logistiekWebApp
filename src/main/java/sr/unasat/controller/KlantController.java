package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.entity.Klant;
import sr.unasat.service.KlantService;

import java.util.List;

@Path("/klant")
public class KlantController {

    KlantService klantService = new KlantService();

    @Path("/get_klanten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klant> getKlanten() {
        return klantService.getKlant();
    }


    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Klant add(@FormParam("firstName") String firstName,
                     @FormParam("lastName") String lastName,
                     @FormParam("address") String address,
                     @FormParam("phoneNumber") String phoneNumber) {
        return klantService.createKlant(firstName, lastName, address, phoneNumber);
    }

//    @Path("/add")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Klant add(Klant klant) {
//        return klantService.createKlant(klant);
//    }

    @Path("/remove/{id}")
    @DELETE
    public Response remove(@PathParam("id") int id) {
        klantService.deleteKlant(id);
        return Response.noContent().build();
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateKlant(@FormParam("id") int id,
                                @FormParam("firstName") String firstName,
                                @FormParam("lastName") String lastName,
                                @FormParam("address") String address,
                                @FormParam("phoneNumber") String phoneNumber) {
        Klant klant = klantService.updateKlant(id, firstName, lastName, address, phoneNumber);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }

    @Path("/updateName")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateName(@QueryParam("id") int id,
                               @QueryParam("firstName") String firstName,
                               @QueryParam("lastName") String lastName) {
        Klant klant = klantService.updateNaam(id, firstName, lastName);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }

    @Path("/updatePhone")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePhone(@QueryParam("id") int id,
                                @QueryParam("phoneNumber") String phoneNumber) {
        Klant klant = klantService.updateTelefoon(id, phoneNumber);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }

    @Path("/updateAdres")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdres(@QueryParam("id") int id,
                                @QueryParam("adres") String adres) {
        Klant klant = klantService.updateAdres(id, adres);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKlantById(@PathParam("id") int id) {
        Klant klant = klantService.findKlantByid(id);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }


    @Path("/findByName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByFullName(@QueryParam("firstName") String firstName,
                                      @QueryParam("lastName") String lastName) {
        Klant klant = klantService.findKlantByName(firstName, lastName);
        if (klant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(klant).build();
        }
    }


}
