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

    public Chauffeur createChauffeur(String voornaam, String achternaam, String telefoon, String imagePath) {
        return repository.createChauffeur(voornaam, achternaam, telefoon, imagePath);
    }

    public Chauffeur createChauffeur(Chauffeur chauffeur) {
        return repository.createChauffeur(chauffeur);
    }

    public Chauffeur findChauffeurByName(String voorNaam, String achterNaam) {
        return repository.findOneChauffeur(voorNaam, achterNaam);
    }

    public Chauffeur findChauffeurById(int id){
        return repository.findChauffeurById(id);
    }

    public Chauffeur updateNaam(int id, String voornaam, String achternaam){
       return repository.updateNaam(id, voornaam, achternaam);
    }

    public Chauffeur updateTelefoon(int id, String telefoon){
        return repository.updateTelefoon(id, telefoon);
    }

    public void deleteChauffeur(int id){
        repository.deleteChauffeur(id);
    }

    public byte[] findChauffeurImage(int id){
        return repository.findChauffeurImage(id);
    }

    public Chauffeur updateChauffeur(int id, String voornaam, String achternaam, String telefoon, String imagePath){
        return repository.updateChauffeur(id, voornaam, achternaam, telefoon, imagePath);
    }

}
