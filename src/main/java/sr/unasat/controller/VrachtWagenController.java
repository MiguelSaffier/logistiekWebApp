package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.factory.Voertuig;
import sr.unasat.service.VoertuigService;

import java.util.List;

@Path("/vrachtwagen")
public class VrachtWagenController {

    VoertuigService voertuigService = new VoertuigService();

    @Path("/get_vrachtwagen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voertuig> alleVoertuigen() {
        return voertuigService.getAllVoertuig("vrachtwagen");
    }


    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Voertuig add(@FormParam("merk") String merk,
                        @FormParam("capaciteit") int capaciteit,
                        @FormParam("kentekenNummer") String kentekenNummer) {
        return voertuigService.createVoertuig("vrachtwagen", merk, capaciteit, kentekenNummer);
    }


    @Path("/remove/{id}")
    @DELETE
    public Response remove(@PathParam("id") int id) {
        voertuigService.deleteVoertuig(id);
        return Response.noContent().build();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKlantById(@PathParam("id") int id) {
        Voertuig voertuig = voertuigService.findVoertuigById(id);
        if (voertuig == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(voertuig).build();
        }
    }
}
