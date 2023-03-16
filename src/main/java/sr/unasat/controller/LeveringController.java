package sr.unasat.controller;

import jakarta.ws.rs.core.Response;
import sr.unasat.entity.Levering;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sr.unasat.service.LeveringService;
import sr.unasat.service.VoertuigChauffeurService;

import java.util.List;

@Path("/levering")
public class LeveringController {

    LeveringService leveringService = new LeveringService();
    VoertuigChauffeurService voertuigChauffeurService = new VoertuigChauffeurService();

    @Path("/get_leveringen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Levering> alleLeveringen() {
        return leveringService.getLevering();
    }

    @Path("/add/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Levering add(@PathParam("id") int id) {
        return leveringService.createLevering(id);
    }

    @Path("/remove/{id}")
    @DELETE
    public Response remove(@PathParam("id") int id) {
        voertuigChauffeurService.deleteVoertuigChauffeur(id);
        leveringService.deleteLevering(id);
        return Response.noContent().build();
    }


    @Path("/updateStatus")
    @PUT
    public Response updateStatus(@QueryParam("id") int id,
                                 @QueryParam("status") String status) {
        Levering levering = leveringService.updateLeveringStatus(id, status);
        if (levering == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }

    @Path("/updateKosten")
    @PUT
    public Response updateTotaleKosten(@QueryParam("id") int id,
                                       @QueryParam("kosten") double kosten) {
        Levering levering = leveringService.updateTotaleKosten(id, kosten);
        if (levering == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Levering> findLevering(@PathParam("id") int id) {
        return leveringService.findLeveringById(id);
    }

}
