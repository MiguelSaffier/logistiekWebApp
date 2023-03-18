package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Bestelling;
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

//    public List<BestellingProduct> getProducten() {
//        return repository.getProducten();
//    }

    public List<Bestelling> getBestellingDetail(){
        return repository.getBestellingDetail();
    }

    public List<Bestelling> getBestellingDetail(int id){
        return repository.getBestellingDetail(id);
    }

    public Bestelling createBestelling(int id, int jaar, int maand, int dag) {
        return repository.createBestelling(id, jaar, maand, dag);
    }

    public Bestelling createBestelling(Bestelling bestelling) {
        return repository.createBestelling(bestelling);
    }

    public Bestelling findBestellingById(int id) {
        return repository.findOneBestelling(id);
    }

    public void updateLeveringsDatum(int id, int jaar, int maand, int dag) {
        repository.updateLeveringDatum(id, jaar, maand, dag);
    }

    public void deleteBestelling(int id) {
        repository.deleteBestelling(id);
    }

    public Bestelling updateLeveringDatum(int id, int jaar, int maand, int dag){
        return repository.updateLeveringDatum(id, jaar, maand, dag);
    }

    public Bestelling updateBestelling(int bId, int kId, int jaar, int maand, int dag) {
        return repository.updateBestelling(bId, kId, jaar, maand, dag);
    }

}
