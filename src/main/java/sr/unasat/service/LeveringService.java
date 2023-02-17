package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Levering;
import sr.unasat.repository.LeveringRepo;

import java.util.List;

public class LeveringService {

    private final LeveringRepo repository;

    public LeveringService() {
        this.repository = new LeveringRepo(JPAConfiguration.getEntityManager());
    }

    public List<Levering> getLevering() {
        return repository.getLevering();
    }

    public Levering createLevering(int bestellingId) {
        return repository.createLevering(bestellingId);
    }

    public void findLeveringById(int id) {
        repository.findOneLeveringById(id);
    }

    public void updateLeveringStatus(int id, String status) {
        repository.updateStatus(id, status);
    }

    public void updateTotaleKosten(int id, double totaleKosten) {
        repository.updateTotaleKosten(id, totaleKosten);
    }

    public void deleteLevering(int id) {
        repository.deleteLevering(id);
    }

}
