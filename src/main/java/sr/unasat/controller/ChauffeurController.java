package sr.unasat.controller;


import sr.unasat.entity.Chauffeur;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sr.unasat.service.ChauffeurService;

import java.util.List;

@Path("chauffeur")
public class ChauffeurController {

    ChauffeurService chauffeurService = new ChauffeurService();

    @Path("/alle-chauffeurs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chauffeur> alleChauffeurs() {
        return chauffeurService.getChauffeur();
    }


//    @Path("/add")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public DierDto add(DierDto dierDto) { return dierService.createDier(dierDto);
//    }

    //    @Path("/remove")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public int remove(Long lidmaatschapId) {
//        return dierService.deleteDier(lidmaatschapId);
//    }


    //    @Path("/update")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public DierDto update(DierDto dierDto) { return dierService.updateDier(dierDto);
//    }


    //    @Path("/find")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public DierDto findDier(DierDto dierDto) {
//        return dierService.findDierById(dierDto.getId());
//    }
//
//    @Path("/find-dieren-owner")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<DierDto> findDierenOfLid(Long lidId){
//        return dierService.findDierenOfOwnerByOwnerId(lidId);
//    }
}
