package sr.unasat.controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.unasat.entity.Chauffeur;
import sr.unasat.service.ChauffeurService;

import java.util.List;

@Path("/chauffeur")
public class ChauffeurController {

    ChauffeurService chauffeurService = new ChauffeurService();

    @Path("/get_chauffeurs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chauffeur> alleChauffeurs() {
        return chauffeurService.getChauffeur();
    }


    @Path("/get_chauffeur_image/{id}")
    @GET
    @Produces("image/jpeg")
    public byte[] getChauffeurImage(@PathParam("id") int id) {
        return chauffeurService.findChauffeurImage(id);
    }

//    @Path("/add")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Chauffeur add(Chauffeur chauffeur) {
//        return chauffeurService.createChauffeur(chauffeur);
//    }

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Chauffeur add(@FormParam("voornaam") String voornaam,
                         @FormParam("achternaam") String achternaam,
                         @FormParam("telefoon") String telefoon,
                         @FormParam("image") String image) {
        return chauffeurService.createChauffeur(voornaam, achternaam, telefoon, image);
    }


    @Path("/remove/{id}")
    @DELETE
    public Response remove(@PathParam("id") int id) {
        chauffeurService.deleteChauffeur(id);
        return Response.noContent().build();
    }


    @Path("/updateName")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateName(@QueryParam("id") int id,
                               @QueryParam("firstName") String firstName,
                               @QueryParam("lastName") String lastName) {
        Chauffeur chauffeur = chauffeurService.updateNaam(id, firstName, lastName);
        if (chauffeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(chauffeur).build();
        }
    }

    @Path("/updatePhone")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePhone(@QueryParam("id") int id,
                                @QueryParam("phoneNumber") String phoneNumber) {
        Chauffeur chauffeur = chauffeurService.updateTelefoon(id, phoneNumber);
        if (chauffeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(chauffeur).build();
        }
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("id") int id,
                           @FormParam("voornaam") String voornaam,
                           @FormParam("achternaam") String achternaam,
                           @FormParam("telefoon") String telefoon,
                           @FormParam("image") String image) {
        Chauffeur chauffeur = chauffeurService.updateChauffeur(id, voornaam, achternaam, telefoon, image);
        if (chauffeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(chauffeur).build();
        }
    }


    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findChauffeurById(@PathParam("id") int id) {
        Chauffeur chauffeur = chauffeurService.findChauffeurById(id);
        if (chauffeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(chauffeur).build();
        }
    }

    @Path("/findByName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChauffeurByFullName(@QueryParam("firstName") String firstName,
                                           @QueryParam("lastName") String lastName) {
        Chauffeur chauffeur = chauffeurService.findChauffeurByName(firstName, lastName);
        if (chauffeur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(chauffeur).build();
        }
    }
}
