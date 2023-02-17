package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Levering;
import sr.unasat.entity.VoertuigChauffeur;
import sr.unasat.repository.VoertuigChauffeurRepo;

import java.util.List;

public class VoertuigChauffeurService {

    private final VoertuigChauffeurRepo repository;

    public VoertuigChauffeurService() {
        this.repository = new VoertuigChauffeurRepo(JPAConfiguration.getEntityManager());
    }

    public void createVoertuigChauffeurService(Levering levering, int bestellingId){
        repository.CreateVoertuigChauffeur(levering, bestellingId);
    }

    public List<VoertuigChauffeur> getVoertuigChauffeur(Levering levering){
        return repository.getVoertuigChauffeur(levering);
    }

}
