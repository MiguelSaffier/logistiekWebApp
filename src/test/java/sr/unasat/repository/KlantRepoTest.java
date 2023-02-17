package sr.unasat.repository;

import org.junit.jupiter.api.Test;
import sr.unasat.service.KlantService;

import static org.junit.jupiter.api.Assertions.*;

class KlantRepoTest {

    KlantService klantService = new KlantService();

    @Test
    void createThreeKlant() {
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");

        assertEquals(3, klantService.getKlant().size());
        //3 objecten zijn gecreeerd en de getAll method heeft de juiste aantal objecten gevonden
    }

    @Test
    void findOneKlant() {
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");


        assertEquals("3456787", klantService.findKlantByName("Jane", "Watson").getTelefoon());
    }


    @Test
    void findKlantById(){
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");

        assertEquals("686753", klantService.findKlantByid(2).getTelefoon());

    }

    @Test
    void delete() {
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");

        klantService.deleteKlant(2);

        assertEquals(2, klantService.getKlant().size());
    }

    @Test
    void updateTelefoon(){
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");

        klantService.updateTelefoon(2, "777888999");
        assertEquals("777888999", klantService.findKlantByid(2).getTelefoon());
    }

    @Test
    void updateAdres(){
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");

        klantService.updateAdres(2, "surinameweg 2");
        assertEquals("surinameweg 2", klantService.findKlantByid(2).getAdres());
    }

    @Test
    void updateNaam(){
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");

        klantService.updateNaam(2, "Matt", "smith");
        assertEquals("Matt", klantService.findKlantByid(2).getVoornaam());
    }

}