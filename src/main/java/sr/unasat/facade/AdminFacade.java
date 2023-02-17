//package sr.unasat.facade;
//
//import sr.unasat.Helper.sr.unasat.Helper;
//import sr.unasat.entity.*;
//import sr.unasat.factory.Voertuig;
//import sr.unasat.service.*;
//
//import java.util.List;
//
//
//public class AdminFacade {
//    KlantService ks = new KlantService();
//    BestellingService bs = new BestellingService();
//    ChauffeurService cs = new ChauffeurService();
//    LeveringService ls = new LeveringService();
//    ProductService ps = new ProductService();
//    VoertuigService vs = new VoertuigService();
//    BestellingProductService bps = new BestellingProductService();
//
//
//    public void welcome() {
//        System.out.println("Welcome to the logistics admin.");
//        System.out.println();
//    }
//
//    public void menuOptions() {
//        System.out.println("Menu: ");
//
//        System.out.print("[Bestelling] (B)");
//        System.out.print(" [Klant] (K)");
//        System.out.print(" [Chauffeur] (C)");
//        System.out.print(" [Product] (P)");
//        System.out.print(" [Levering] (L)");
//        System.out.print(" [Vrachtwagen] (V)");
//        System.out.print(" (Exit)");
//    }
//
//    public void nieuwKlant() {
//        System.out.println("voornaam: ");
//        String voorNaam = sr.unasat.Helper.scanstring();
//        System.out.println("achternaam: ");
//        String achterNaam = sr.unasat.Helper.scanstring();
//        System.out.println("adres: ");
//        String adres = sr.unasat.Helper.scanstring();
//        System.out.println("telefoon nummer: ");
//        String telefoon = sr.unasat.Helper.scanstring();
//
//        ks.createKlant(voorNaam, achterNaam, adres, telefoon);
//        System.out.println("Klant succesvol toegevoegd");
//    }
//
//    public void lijstKlanten() {
//        for (Klant k :
//                ks.getKlant()) {
//            System.out.println(k);
//        }
//    }
//
//    public void zoekOneKlant() {
//        System.out.println("voornaam: ");
//        String voorNaam = sr.unasat.Helper.scanstring();
//        System.out.println("achternaam: ");
//        String achterNaam = sr.unasat.Helper.scanstring();
//        System.out.println(ks.findKlantByName(voorNaam, achterNaam));
//    }
//
//    public void deleteKlant() {
//        System.out.println("klant ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        ks.deleteKlant(id);
//        System.out.println("klant met ID " + id + " verwijderd");
//    }
//
//    public void updateKlantNaam() {
//        System.out.println("klant ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("voornaam: ");
//        String voorNaam = sr.unasat.Helper.scanstring();
//        System.out.println("achternaam: ");
//        String achterNaam = sr.unasat.Helper.scanstring();
//
//        ks.updateNaam(id, voorNaam, achterNaam);
//
//        System.out.println("klant met ID " + id + " updated");
//    }
//
//    public void updateKlantAdres() {
//        System.out.println("klant ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("adres: ");
//        String adres = sr.unasat.Helper.scanstring();
//
//        ks.updateAdres(id, adres);
//
//        System.out.println("klant met ID " + id + " updated");
//    }
//
//    public void updateKlantTelefoon() {
//        System.out.println("klant ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("telefoon nummer: ");
//        String telefoon = sr.unasat.Helper.scanstring();
//        ks.updateAdres(id, telefoon);
//        System.out.println("klant met ID " + id + " updated");
//    }
//
//    public void lijstBestelling() {
//        for (Bestelling b : bs.getBestelling()
//        ) {
//            System.out.println(b);
//        }
//    }
//
//    public void lijstBestellingProducten() {
//        System.out.println("Bestelling ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        for (BestellingProduct bp : bs.findBestellingById(id).getProducten()
//        ) {
//            System.out.println(bp);
//        }
//    }
//
//
//    public void nieuwBestelling() {
//        System.out.println("Klant voornaam: ");
//        String voornaam = sr.unasat.Helper.scanstring();
//        System.out.println("Klant achternaam: ");
//        String achternaam = sr.unasat.Helper.scanstring();
//        System.out.println("jaar: ");
//        int jaar = sr.unasat.Helper.scanInt();
//        System.out.println("maand: ");
//        int maand = sr.unasat.Helper.scanInt();
//        System.out.println("dag: ");
//        int dag = sr.unasat.Helper.scanInt();
//
//        List<String> p = sr.unasat.Helper.scanStringList();
//        List<Integer> a = sr.unasat.Helper.scanIntList();
//
//        bps.createBestellingProduct(bs.createBestelling(voornaam, achternaam, jaar, maand, dag), p, a);
//
//        System.out.println("Bestelling succesvol toegevoegd");
//    }
//
//    public void zoekOneBestelling() {
//        System.out.println("Bestelling ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        System.out.println(bs.findBestellingById(id));
//    }
//
////    public void updateLeveringKosten() {
////        System.out.println("Bestelling ID: ");
////        int id = sr.unasat.Helper.scanInt();
////        System.out.println("leveringskosten: ");
////        double leveringskosten = sr.unasat.Helper.scandouble();
////        bs.updateLeveringskosten(id, leveringskosten);
////        System.out.println("Bestelling met ID " + id + " updated");
////    }
//
//    public void updateLeveringDatum() {
//        System.out.println("Bestelling ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("jaar: ");
//        int jaar = sr.unasat.Helper.scanInt();
//        System.out.println("maand: ");
//        int maand = sr.unasat.Helper.scanInt();
//        System.out.println("dag: ");
//        int dag = sr.unasat.Helper.scanInt();
//        bs.updateLeveringsDatum(id, jaar, maand, dag);
//        System.out.println("Bestelling met ID " + id + " updated");
//    }
//
//    public void deleteBestelling() {
//        System.out.println("Bestelling ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        bs.deleteBestelling(id);
//        System.out.println("Bestelling met ID " + id + " verwijderd");
//    }
//
//    public void lijstChauffeur() {
//        for (Chauffeur c :
//                cs.getChauffeur()) {
//            System.out.println(c);
//        }
//    }
//
//    public void nieuwChauffeur() {
//        System.out.println("voornaam: ");
//        String voornaam = sr.unasat.Helper.scanstring();
//        System.out.println("achternaam: ");
//        String achternaam = sr.unasat.Helper.scanstring();
//        System.out.println("telefoon nummer: ");
//        String telefoon = sr.unasat.Helper.scanstring();
//
//        cs.createChauffeur(voornaam, achternaam, telefoon);
//        System.out.println("Chauffeur succesvol toegevoegd");
//    }
//
//    public void zoekChauffeurBijNaam() {
//        System.out.println("voornaam: ");
//        String voornaam = sr.unasat.Helper.scanstring();
//        System.out.println("achternaam: ");
//        String achternaam = sr.unasat.Helper.scanstring();
//
//        System.out.println(cs.findChauffeurByName(voornaam, achternaam));
//    }
//
//    public void zoekChauffeurBijId() {
//        System.out.println("chauffeur ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        System.out.println(cs.findChauffeurById(id));
//    }
//
//    public void updateChauffeurNaam() {
//        System.out.println("chauffeur ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("voornaam: ");
//        String voornaam = sr.unasat.Helper.scanstring();
//        System.out.println("achternaam: ");
//        String achternaam = sr.unasat.Helper.scanstring();
//
//        cs.updateNaam(id, voornaam, achternaam);
//        System.out.println("Chauffeur met ID " + id + " updated");
//    }
//
//    public void updateChauffeurTelefoon() {
//        System.out.println("chauffeur ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("telefoon nummer: ");
//        String telefoon = sr.unasat.Helper.scanstring();
//
//        cs.updateTelefoon(id, telefoon);
//        System.out.println("Chauffeur met ID " + id + " updated");
//    }
//
//    public void deleteChauffeur() {
//        System.out.println("chauffeur ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        cs.deleteChauffeur(id);
//        System.out.println("Chauffeur met ID " + id + " verwijderd");
//    }
//
//    public void nieuwLevering() {
//        System.out.println("levering ID: ");
//        int id = sr.unasat.Helper.scanInt();
////        System.out.println("voornaam: ");
////        String voornaam = sr.unasat.Helper.scanstring();
////        System.out.println("achternaam: ");
////        String achternaam = sr.unasat.Helper.scanstring();
//
//        ls.createLevering(id);
//        System.out.println("Levering succesvol toegevoegd");
//    }
//
//    public void lijstLevering() {
//        for (Levering l :
//                ls.getLevering()) {
//            System.out.println(l);
//        }
//    }
//
//    public void deleteLevering() {
//        System.out.println("levering ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        ls.deleteLevering(id);
//        System.out.println("Levering met ID " + id + " verwijderd");
//    }
//
//    public void zoekLevering() {
//        System.out.println("levering ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        ls.findLeveringById(id);
//    }
//
//    public void updateStatus() {
//        System.out.println("levering ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("nieuw status: ");
//        String status = sr.unasat.Helper.scanstring();
//
//        ls.updateLeveringStatus(id, status);
//        System.out.println("Levering met ID " + id + " updated");
//    }
//
//    public void updateLeveringChauffeur() {
//        System.out.println("levering ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        System.out.println("error: function not ready");
////        ls.updateLeveringChauffeur();
////        System.out.println("Levering met ID " + id + " updated");
//    }
//
//    public void nieuwProduct() {
//        System.out.println("product naam: ");
//        String naam = sr.unasat.Helper.scanstring();
//        System.out.println("prijs: ");
//        double prijs = sr.unasat.Helper.scandouble();
//        System.out.println("adres: ");
//        String adres = sr.unasat.Helper.scanstring();
//
//        ps.createProduct(naam, prijs, adres);
//        System.out.println("Product succesvol toegevoegd");
//    }
//
//    public void deleteProduct() {
//        System.out.println("product ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        ps.deleteProduct(id);
//        System.out.println("Product met ID " + id + " verwijderd");
//    }
//
//    public void lijstProduct() {
//        for (Product p :
//                ps.getAllProducts()) {
//            System.out.println(p);
//        }
//    }
//
//    public void updatePrijs() {
//        System.out.println("product ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("prijs: ");
//        double prijs = sr.unasat.Helper.scandouble();
//
//        ps.updatePrijs(id, prijs);
//        System.out.println("Product met ID " + id + " updated");
//    }
//
//    public void updateAdres() {
//        System.out.println("product ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        System.out.println("adres: ");
//        String adres = sr.unasat.Helper.scanstring();
//
//        ps.updateAdres(id, adres);
//        System.out.println("Product met ID " + id + " updated");
//    }
//
//    public void zoekOneProduct() {
//        System.out.println("product naam: ");
//        String naam = sr.unasat.Helper.scanstring();
//
//        System.out.println(ps.findProductByName(naam));
//    }
//
//    public void nieuwVoertuig() {
//        System.out.println("type (vrachtwagen of anders): ");
//        String type = sr.unasat.Helper.scanstring();
//        System.out.println("merk: ");
//        String merk = sr.unasat.Helper.scanstring();
//        System.out.println("capaciteit: ");
//        int capaciteit = sr.unasat.Helper.scanInt();
//        System.out.println("kenteken nummer: ");
//        String kenteken = sr.unasat.Helper.scanstring();
//
//        vs.createVoertuig(type, merk, capaciteit, kenteken);
//        System.out.println("Voertuig succesvol toegevoegd");
//    }
//
//    public void deleteVoertuig() {
//        System.out.println("voertuig ID: ");
//        int id = sr.unasat.Helper.scanInt();
//        vs.deleteVoertuig(id);
//        System.out.println("Voertuig met ID " + id + " verwijderd");
//    }
//
//    public void lijstVoertuig() {
//        String type = sr.unasat.Helper.scanstring();
//        for (Voertuig v :
//                vs.getAllVoertuig(type)) {
//            System.out.println(v);
//        }
//    }
//
//    public void zoekOneVoertuig() {
//        System.out.println("voertuig ID: ");
//        int id = sr.unasat.Helper.scanInt();
//
//        System.out.println(vs.findVoertuigById(id));
//    }
//
////    public void subMenuVoertuig() {
////        System.out.println("Functies: ");
////        System.out.print("(add)");
////        System.out.print(" (delete)");
////        System.out.print(" (lijst voertuig)");
////        System.out.print(" (zoek voertuig)");
////        System.out.println(" (back)");
////
////        String menu = sr.unasat.Helper.scanstring();
////        switch (menu.toLowerCase()) {
////            case "add" -> {
////                nieuwVoertuig();
////                subMenuVoertuig();
////            }
////            case "delete" -> {
////                deleteVoertuig();
////                subMenuVoertuig();
////            }
////            case "lijst voertuig" -> {
////                lijstVoertuig();
////                subMenuVoertuig();
////            }
////            case "zoek voertuig" -> {
////                zoekOneVoertuig();
////                subMenuVoertuig();
////            }
////            case "back" -> menu();
////            default -> {
////                System.out.println("Invalid input. Try again.");
////                subMenuVoertuig();
////            }
////        }
////    }
//
//    public void subMenuProduct() {
//        System.out.println("Functies: ");
//        System.out.print("(add)");
//        System.out.print(" (delete)");
//        System.out.print(" (lijst product)");
//        System.out.print(" (update prijs)");
//        System.out.print(" (update adres)");
//        System.out.print(" (zoek product)");
//        System.out.println(" (back)");
//
//        String menu = sr.unasat.Helper.scanstring();
//        switch (menu.toLowerCase()) {
//            case "add" -> {
//                nieuwProduct();
//                subMenuProduct();
//            }
//            case "delete" -> {
//                deleteProduct();
//                subMenuProduct();
//            }
//            case "lijst product" -> {
//                lijstProduct();
//                subMenuProduct();
//            }
//            case "update prijs" -> {
//                updatePrijs();
//                subMenuKlant();
//            }
//            case "update adres" -> {
//                updateAdres();
//                subMenuProduct();
//            }
//            case "zoek product" -> {
//                zoekOneProduct();
//                subMenuProduct();
//            }
//            case "back" -> menu();
//            default -> {
//                System.out.println("Invalid input. Try again.");
//                subMenuProduct();
//            }
//        }
//    }
//
//    public void subMenuLevering() {
//        System.out.println("Functies: ");
//        System.out.print("(add)");
//        System.out.print(" (delete)");
//        System.out.print(" (lijst levering)");
//        System.out.print(" (update status)");
//        System.out.print(" (update chauffeur)");
//        System.out.print(" (zoek levering)");
//        System.out.println(" (back)");
//
//        String menu = sr.unasat.Helper.scanstring();
//        switch (menu.toLowerCase()) {
//            case "add" -> {
//                nieuwLevering();
//                subMenuLevering();
//            }
//            case "delete" -> {
//                deleteLevering();
//                subMenuLevering();
//            }
//            case "lijst levering" -> {
//                lijstLevering();
//                subMenuLevering();
//            }
//            case "update status" -> {
//                updateStatus();
//                subMenuLevering();
//            }
//            case "update chauffeur" -> {
//                updateLeveringChauffeur();
//                subMenuLevering();
//            }
//            case "zoek levering" -> {
//                zoekLevering();
//                subMenuLevering();
//            }
//            case "back" -> menu();
//            default -> {
//                System.out.println("Invalid input. Try again.");
//                subMenuLevering();
//            }
//        }
//    }
//
//    public void subMenuKlant() {
//        System.out.println("Functies: ");
//        System.out.print("(add)");
//        System.out.print(" (delete)");
//        System.out.print(" (lijst Klant)");
//        System.out.print(" (update Telefoon)");
//        System.out.print(" (update naam)");
//        System.out.print(" (update adres)");
//        System.out.print(" (zoek klant)");
//        System.out.println(" (back)");
//
//        String menu = sr.unasat.Helper.scanstring();
//        switch (menu.toLowerCase()) {
//            case "add" -> {
//                nieuwKlant();
//                subMenuKlant();
//            }
//            case "delete" -> {
//                deleteKlant();
//                subMenuKlant();
//            }
//            case "lijst klant" -> {
//                lijstKlanten();
//                subMenuKlant();
//            }
//            case "update telefoon" -> {
//                updateKlantTelefoon();
//                subMenuKlant();
//            }
//            case "update naam" -> {
//                updateKlantNaam();
//                subMenuKlant();
//            }
//            case "update adres" -> {
//                updateKlantAdres();
//                subMenuKlant();
//            }
//            case "zoek klant" -> {
//                zoekOneKlant();
//                subMenuKlant();
//            }
//            case "back" -> menu();
//            default -> {
//                System.out.println("Invalid input. Try again.");
//                subMenuKlant();
//            }
//        }
//    }
//
//    public void subMenuBestelling() {
//        System.out.println("Functies: ");
//        System.out.print("(add)");
//        System.out.print(" (delete)");
//        System.out.print(" (lijst Bestelling)");
//        System.out.print(" (lijst Bestelling producten)");
//        System.out.print(" (update leveringsdatum)");
//        System.out.print(" (zoek Bestelling)");
//        System.out.println(" (back)");
//
//        String menu = sr.unasat.Helper.scanstring();
//        switch (menu.toLowerCase()) {
//            case "add" -> {
//                nieuwBestelling();
//                subMenuBestelling();
//            }
//            case "delete" -> {
//                deleteBestelling();
//                subMenuBestelling();
//            }
//            case "lijst bestelling" -> {
//                lijstBestelling();
//                subMenuBestelling();
//            }
//            case "update leveringsdatum" -> {
//                updateLeveringDatum();
//                subMenuBestelling();
//            }
//            case "bestelling producten" -> {
//                lijstBestellingProducten();
//                subMenuBestelling();
//            }
//            case "zoek bestelling" -> {
//                zoekOneBestelling();
//                subMenuBestelling();
//            }
//            case "back" -> menu();
//            default -> {
//                System.out.println("Invalid input. Try again.");
//                subMenuBestelling();
//            }
//        }
//    }
//
//    public void subMenuChauffeur() {
//        System.out.println("Functies: ");
//        System.out.print("(add)");
//        System.out.print(" (delete)");
//        System.out.print(" (lijst Chauffeur)");
//        System.out.print(" (update naam)");
//        System.out.print(" (update telefoon)");
//        System.out.print(" (zoek chauffeur bij naam)");
//        System.out.print(" (zoek chauffeur bij id)");
//        System.out.println(" (back)");
//
//        String menu = sr.unasat.Helper.scanstring();
//        switch (menu.toLowerCase()) {
//            case "add" -> {
//                nieuwChauffeur();
//                subMenuChauffeur();
//            }
//            case "delete" -> {
//                deleteChauffeur();
//                subMenuChauffeur();
//            }
//            case "lijst chauffeur" -> {
//                lijstChauffeur();
//                subMenuChauffeur();
//            }
//            case "update naam" -> {
//                updateChauffeurNaam();
//                subMenuChauffeur();
//            }
//            case "update telefoon" -> {
//                updateChauffeurTelefoon();
//                subMenuChauffeur();
//            }
//            case "zoek chauffeur bij naam" -> {
//                zoekChauffeurBijNaam();
//                subMenuChauffeur();
//            }
//            case "zoek chauffeur bij id" -> {
//                zoekChauffeurBijId();
//                subMenuChauffeur();
//            }
//            case "back" -> menu();
//            default -> {
//                System.out.println("Invalid input. Try again.");
//                subMenuChauffeur();
//            }
//        }
//    }
//
//    public void menu() {
//        menuOptions();
//        System.out.println();
//        String menu = sr.unasat.Helper.scanstring();
//        switch (menu.toUpperCase()) {
//            case "K" -> subMenuKlant();
//            case "B" -> subMenuBestelling();
//            case "C" -> subMenuChauffeur();
//            case "L" -> subMenuLevering();
//            case "V" -> subMenuVoertuig();
//            case "P" -> subMenuProduct();
//            case "EXIT" -> System.out.println("End Of Program");
//            default -> {
//                System.out.println("Invalid input. Try again.");
//                menu();
//            }
//        }
//    }
//
//}
