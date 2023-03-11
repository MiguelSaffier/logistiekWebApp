package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Chauffeur;
import sr.unasat.repository.ChauffeurRepo;

import java.util.List;


public class ChauffeurService {

    private final ChauffeurRepo repository;

    public ChauffeurService() {
        this.repository = new ChauffeurRepo(JPAConfiguration.getEntityManager());
    }

    public List<Chauffeur> getChauffeur() {
        return repository.getChauffeur();
    }

    public void createChauffeur(String voornaam, String achternaam, String telefoon, String imagePath) {
        repository.createChauffeur(voornaam, achternaam, telefoon, imagePath);
    }

    public Chauffeur findChauffeurByName(String voorNaam, String achterNaam) {
        return repository.findOneChauffeur(voorNaam, achterNaam);
    }

    public Chauffeur findChauffeurById(int id){
        return repository.findChauffeurById(id);
    }

    public void updateNaam(int id, String voornaam, String achternaam){
        repository.updateNaam(id, voornaam, achternaam);
    }

    public void updateTelefoon(int id, String telefoon){
        repository.updateTelefoon(id, telefoon);
    }

    public void deleteChauffeur(int id){
        repository.deleteChauffeur(id);
    }

}
