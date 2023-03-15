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

    public List<Levering> findLeveringById(int id) {
        return repository.findLeveringById(id);
    }

    public Levering updateLeveringStatus(int id, String status) {
        return repository.updateStatus(id, status);
    }

    public Levering updateTotaleKosten(int id, double totaleKosten) {
        return repository.updateTotaleKosten(id, totaleKosten);
    }

    public void deleteLevering(int id) {
        repository.deleteLevering(id);
    }

}
