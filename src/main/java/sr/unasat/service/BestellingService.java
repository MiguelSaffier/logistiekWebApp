package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Bestelling;
import sr.unasat.entity.BestellingProduct;
import sr.unasat.repository.BestellingRepo;

import java.util.List;

public class BestellingService {

    private final BestellingRepo repository;

    public BestellingService() {
        this.repository = new BestellingRepo(JPAConfiguration.getEntityManager());
    }

    public List<Bestelling> getBestelling() {
        return repository.getBestelling();
    }

    public List<BestellingProduct> getProducten() {
        return repository.getProducten();
    }

    public Bestelling createBestelling(String voorNaam, String achterNaam, int jaar, int maand, int dag) {
        return repository.createBestelling(voorNaam, achterNaam, jaar, maand, dag);
    }

    public Bestelling findBestellingById(int id) {
        return repository.findOneBestelling(id);
    }

//    public void updateLeveringskosten(int id, double leveringKosten) {
//        sr.unasat.repository.updateLeveringKosten(id, leveringKosten);
//    }

    public void updateLeveringsDatum(int id, int jaar, int maand, int dag) {
        repository.updateLeveringDatum(id, jaar, maand, dag);
    }

    public void deleteBestelling(int id) {
        repository.deleteBestelling(id);
    }

}
