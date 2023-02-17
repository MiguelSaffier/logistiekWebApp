package sr.unasat.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sr.unasat.service.VoertuigService;

class VoertuigRepoTest {
    VoertuigService vs = new VoertuigService();

    @Test
    void createThreeRecords() {
        vs.createVoertuig("vrachtwagen", "Toyota", 10, "EV 12-23");
        vs.createVoertuig("vrachtwagen", "Ford", 20, "89-54 AV");
        vs.createVoertuig("vrachtwagen", "Mercedes", 2, "39-08 CV");

        Assertions.assertEquals(3, vs.getAllVoertuig("Vrachtwagen").size());
        //3 objecten zijn gecreëerd en de getAll method heeft de juiste aantal objecten gevonden
    }

    @Test
    void findVoertuig() {
        vs.createVoertuig("vrachtwagen", "Toyota", 10, "EV 12-23");
        vs.createVoertuig("vrachtwagen", "Ford", 20, "89-54 AV");
        vs.createVoertuig("vrachtwagen", "Mercedes", 2, "39-08 CV");

        Assertions.assertEquals(10, vs.findVoertuigById(1).getCapaciteit());
    }

    @Test
    void delete() {
        vs.createVoertuig("vrachtwagen", "Toyota", 10, "EV 12-23");
        vs.createVoertuig("vrachtwagen", "Ford", 20, "89-54 AV");
        vs.createVoertuig("vrachtwagen", "Mercedes", 2, "39-08 CV");

        vs.deleteVoertuig(2);
        Assertions.assertEquals(2, vs.getAllVoertuig("vrachtwagen").size());

    }
}