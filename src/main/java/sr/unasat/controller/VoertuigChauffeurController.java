package sr.unasat.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.dto.VoertuigChauffeurDTO;
import sr.unasat.entity.Levering;
import sr.unasat.entity.VoertuigChauffeur;
import sr.unasat.service.LeveringService;
import sr.unasat.service.VoertuigChauffeurService;

import java.util.List;

@Path("/voertuigchauffeur")
public class VoertuigChauffeurController {

    VoertuigChauffeurService voertuigChauffeurService = new VoertuigChauffeurService();
    LeveringService leveringService = new LeveringService();

    @Path("/get_voertuig_chauffeur_detail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VoertuigChauffeur> getFullVoertuigChauffeur() {
        return voertuigChauffeurService.getVoertuigChauffeurDetail();
    }

    @Path("/get_voertuig_chauffeur_detail/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VoertuigChauffeur> findVoertuigChauffeur(@PathParam("id") int id) {
        return voertuigChauffeurService.findVoertuigChauffeur(id);
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(VoertuigChauffeurDTO voertuigChauffeurDTO) {
        Levering levering = leveringService.findOneLeveringById(voertuigChauffeurDTO.getLeveringId());
        voertuigChauffeurService.createVoertuigChauffeurService(levering, voertuigChauffeurDTO.getBestellingId());
    }

    @Path("/updateLeveringKosten")
    @PUT
    public Response updateLeveringKosten(@QueryParam("id") int id,
                                            @QueryParam("kosten") double kosten) {
        VoertuigChauffeur voertuigChauffeur = voertuigChauffeurService.updateLeveringskosten(id, kosten);
        if (voertuigChauffeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.noContent().build();
        }
    }

}
