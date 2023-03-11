//package sr.unasat.repository;
//
//import sr.unasat.entity.Levering;
//import org.junit.jupiter.api.Test;
//import sr.unasat.service.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//class LeveringRepoTest {
//
//    @Test
//    void createLevering() {
//        ProductService productService = new ProductService();
//        KlantService klantService = new KlantService();
//        BestellingProductService bestellingProductService = new BestellingProductService();
//        BestellingService bestellingService = new BestellingService();
//        LeveringService leveringService = new LeveringService();
//        VoertuigChauffeurService voertuigChauffeurService = new VoertuigChauffeurService();
//        VoertuigService vs = new VoertuigService();
//        ChauffeurService chauffeurService = new ChauffeurService();
//
//        productService.createProduct("Ei", 7.50, "Javaweg 102");
//        productService.createProduct("Brood", 45, "Indra ghandi weg 458");
//        productService.createProduct("MCP Melk", 10, "Veergeetmenietstraat 3");
//        productService.createProduct("Gouda Kaas", 130, "Hindilaan 2");
//
//        klantService.createKlant("Jim", "Kerrie", "nickeriestraat 6", "686753");
//        klantService.createKlant("John", "Smith", "wanicastraat 56", "6665522");
//        klantService.createKlant("Jane", "Watson", "parastraat 5", "3456787");
//
//        vs.createVoertuig("vrachtwagen", "Toyota", 10, "EV 12-23");
//        vs.createVoertuig("vrachtwagen", "Ford", 20, "89-54 AV");
//        vs.createVoertuig("vrachtwagen", "Mercedes", 2, "39-08 CV");
//
//        chauffeurService.createChauffeur("Boef", "Sanger", "8896512");
//        chauffeurService.createChauffeur("Lijpe", "zanger", "8993552");
//        chauffeurService.createChauffeur("Cho", "Zwager", "8656340");
//
//
//        List<String> products = new ArrayList<>();
////        products.add("Gouda Kaas");
//        products.add("Brood");
//        products.add("Ei");
//
//
//        List<Integer> amounts = new ArrayList<>();
//        amounts.add(10);
////        amounts.add(20);
//        amounts.add(1);
//
//        List<Double> leveringsKosten = new ArrayList<>();
//        leveringsKosten.add(1000.0);
//
//        bestellingProductService.createBestellingProduct(bestellingService.createBestelling("Jane", "Watson", 2023, 4, 16), products, amounts);
//
//        Levering levering = leveringService.createLevering(14);
//
//        voertuigChauffeurService.createVoertuigChauffeurService(levering, levering.getBestelling().getId());
////        voertuigChauffeurService.createVoertuigChauffeurService(levering, 14);
//
//
//
//    }
//
//
//    @Test
//    void updateLeveringStatus() {
////        ls.createLevering();
////        ls.createLevering();
////        ls.createLevering();
//
////        ls.updateLeveringStatus(2,"random");
////        assertTrue(ls.findLeveringById(2).getStatus().equals("random"));
//
//    }
//
////    @Test
////    void updateLeveringChauffeur(){
////        ls.createLevering();
////        ls.createLevering();
////        ls.createLevering();
////    }
//
//    @Test
//    void delete() {
////       ls.createLevering();
////        ls.createLevering();
////        ls.createLevering();
//
////        ls.deleteLevering(2);
////
////        assertTrue(ls.getLevering().size() == 2);
//    }
//}