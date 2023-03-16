package sr.unasat.strategy;

import sr.unasat.entity.Bestelling;
import sr.unasat.entity.Chauffeur;
import sr.unasat.entity.Levering;
import sr.unasat.entity.VrachtWagen;
import sr.unasat.factory.Voertuig;
import sr.unasat.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeveringStrategy {
    private static BestellingService bs;
    private static Bestelling b;
    private static VoertuigService vs;

    public static String setLeveringStatus(int bestellingId) {
        bs = new BestellingService();
        b = bs.findBestellingById(bestellingId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (LocalDate.parse(b.getLeveringDatum(), formatter).isAfter(LocalDate.now())) {
            return ("Levering datum gemist.");
        } else {
            return ("Onvoltooid");
        }
    }

    public static List<VrachtWagen> setJuisteVoertuig(int bestellingId) {
        BestellingProductService bps = new BestellingProductService();
        bs = new BestellingService();
        vs = new VoertuigService();
        b = new Bestelling();
        List<Voertuig> voertuigList = new ArrayList<>(vs.getAllVoertuig("vrachtwagen"));
        List<VrachtWagen> vrachtWagenList = new ArrayList<>();
        b = bs.findBestellingById(bestellingId);

        //Latere aanpassingen, als er geen voertuigen beschikbaar zijn, add null. Voertuig toevoegen met een update.

        int amount;
        for (int i = 0; i < bps.getBestellingProduct(b).size(); i++) {
            amount = bps.getBestellingProduct(b).get(i).getAmount();
            if (amount <= 2) {
                for (int j = 0; j < voertuigList.size(); j++) {
                    if (voertuigList.get(j).getCapaciteit() == 2) {
                        vrachtWagenList.add((VrachtWagen) voertuigList.get(j));
                        voertuigList.remove(voertuigList.get(j));
                        break;
                    }
                }
            } else if (amount <= 4 && amount > 2) {
                for (int j = 0; j < voertuigList.size(); j++) {
                    if (voertuigList.get(j).getCapaciteit() == 4) {
                        vrachtWagenList.add((VrachtWagen) voertuigList.get(j));
                        voertuigList.remove(voertuigList.get(j));
                        break;
                    }
                }
            } else if (amount <= 10 && amount > 4) {
                for (int j = 0; j < voertuigList.size(); j++) {
                    if (voertuigList.get(j).getCapaciteit() == 10) {
                        vrachtWagenList.add((VrachtWagen) voertuigList.get(j));
                        voertuigList.remove(voertuigList.get(j));
                        break;
                    }
                }
            } else if (amount > 10) {
                for (int j = 0; j < voertuigList.size(); j++) {
                    if (voertuigList.get(j).getCapaciteit() == 10) {
                        vrachtWagenList.add((VrachtWagen) voertuigList.get(j));
                        voertuigList.remove(voertuigList.get(j));
                        break;
                    }
                }
            }
        }
        return vrachtWagenList;
    }

    public static double setKosten(int bestellingId, Levering levering) {
        BestellingProductService bps = new BestellingProductService();
        b = new Bestelling();
        bs = new BestellingService();
        b = bs.findBestellingById(bestellingId);
        VoertuigChauffeurService voertuigChauffeurService = new VoertuigChauffeurService();
        int size = voertuigChauffeurService.getVoertuigChauffeur(levering).size();

        double totaleKosten = 0;
        for (int i = 0; i < bps.getBestellingProduct(b).size(); i++) {
            int amount = bps.getBestellingProduct(b).get(i).getAmount();
            double prijs = bps.getBestellingProduct(b).get(i).getProduct().getPrijs();
            totaleKosten += (amount * prijs);
        }

        for (int i = 0; i < size; i++) {
            double leveringsKosten = voertuigChauffeurService.getVoertuigChauffeur(levering).get(i).getLeveringskosten();
            totaleKosten += leveringsKosten;
        }

        return totaleKosten;
    }

    public static List<Chauffeur> setJuisteChauffeur(List<VrachtWagen> vrachtWagenList) {
        ChauffeurService chauffeurService = new ChauffeurService();
        return getRandomChauffeurs(chauffeurService.getChauffeur(), vrachtWagenList.size());
    }

    private static List<Chauffeur> getRandomChauffeurs(List<Chauffeur> chauffeurs, int size) {
        List<Chauffeur> randomChauffeurs = new ArrayList<>();
        List<Chauffeur> copy = new ArrayList<>(chauffeurs);
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int randomIndex = rand.nextInt(copy.size());
            randomChauffeurs.add(copy.get(randomIndex));
            copy.remove(randomIndex);
        }
        return randomChauffeurs;
    }
}
