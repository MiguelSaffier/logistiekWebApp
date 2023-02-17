package sr.unasat.repository;

import org.junit.jupiter.api.Test;
import sr.unasat.service.BestellingProductService;
import sr.unasat.service.BestellingService;
import sr.unasat.service.KlantService;
import sr.unasat.service.ProductService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BestellingRepoTest {

    BestellingService bestellingService = new BestellingService();
    ProductService productService = new ProductService();
    KlantService klantService = new KlantService();
    BestellingProductService bestellingProductService = new BestellingProductService();

    @Test
    void createOneBestelling() {
        productService.createProduct("Ei", 7.50, "Javaweg 102");
        productService.createProduct("Brood", 45, "Indra ghandi weg 458");

        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");

        List<String> producten = new ArrayList<>();
        producten.add("Brood");

        List<Integer> hoeveelheid = new ArrayList<>();
        hoeveelheid.add(4);

        bestellingProductService.createBestellingProduct(bestellingService.createBestelling("Jane", "Watson", 2023, 4, 16), producten, hoeveelheid);

        assertEquals(bestellingService.getBestelling().size(), 1);
    }

    @Test
    void createBestellingThreeProducts() {
        productService.createProduct("Ei", 7.50, "Javaweg 102");
        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");

        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");

        List<String> products = new ArrayList<>();
        products.add("Gouda Kaas");
        products.add("Brood");
        products.add("Ei");


        List<Integer> amounts = new ArrayList<>();
        amounts.add(10);
        amounts.add(20);
        amounts.add(1);

        bestellingProductService.createBestellingProduct(bestellingService.createBestelling("Jane", "Watson", 2023, 4, 16), products, amounts);
    }

    @Test
    void findOneBestelling() {
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");

        bestellingService.createBestelling("jim", "kerrie", 2023, 2, 1);
        bestellingService.createBestelling("John", "Smith", 2023, 2, 2);
        bestellingService.createBestelling("Jane", "Watson", 2023, 2, 3);

        assertEquals("John", bestellingService.findBestellingById(5).getKlant().getVoornaam());
    }

//    @Test
//    void updateLeveringKosten() {
//        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
//        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
//        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
//
//        bestellingService.createBestelling("jim", "kerrie", 2000, 2023, 2, 1);
//        bestellingService.createBestelling("John", "Smith", 3000, 2023, 2, 2);
//        bestellingService.createBestelling("Jane", "Watson", 4000, 2023, 2, 3);
//
//        bestellingService.updateLeveringskosten(5, 6000);
//
//        assertEquals(6000, bestellingService.findBestellingById(5).getLeveringskosten());
//    }

    @Test
    void updateLeveringDatum() {
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");

        bestellingService.createBestelling("jim", "kerrie", 2023, 2, 1);
        bestellingService.createBestelling("John", "Smith",  2023, 2, 2);
        bestellingService.createBestelling("Jane", "Watson",  2023, 2, 3);

        bestellingService.updateLeveringsDatum(5, 2023, 5, 6);

        GregorianCalendar g = new GregorianCalendar(2023, Calendar.JUNE, 6);

        assertEquals(bestellingService.findBestellingById(5).getLeveringDatum(), g);
    }


    @Test
    void deleteBestelling() {
        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");

        bestellingService.createBestelling("jim", "kerrie",2023, 2, 1);
        bestellingService.createBestelling("John", "Smith",2023, 2, 2);
        bestellingService.createBestelling("Jane", "Watson", 2023, 2, 3);

        bestellingService.deleteBestelling(5);

        assertEquals(2, bestellingService.getBestelling().size());
    }


}