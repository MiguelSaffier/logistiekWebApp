package sr.unasat.controller;


import sr.unasat.entity.Bestelling;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sr.unasat.service.BestellingService;

import java.util.List;

@Path("bestelling")
public class BestellingController {


    BestellingService bestellingService = new BestellingService();

    @Path("/alle-bestellingen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bestelling> alleBestellingen() {
        return bestellingService.getBestelling();
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
