package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.factory.Voertuig;
import sr.unasat.repository.VoertuigRepo;

import java.util.List;

public class VoertuigService {

    private final VoertuigRepo repository;

    public VoertuigService() {
        this.repository = new VoertuigRepo(JPAConfiguration.getEntityManager());
    }

    public List<Voertuig> getAllVoertuig(String type) {
        return repository.getVoertuig(type);
    }

    public Voertuig createVoertuig(String voertuigType, String merk, int capaciteit, String kentekenNummer) {
        return repository.createVoertuig(voertuigType, merk, capaciteit, kentekenNummer);
    }

    public Voertuig createVoertuig(String voertuigType, Voertuig voertuig) {
        return repository.createVoertuig(voertuigType, voertuig);
    }

    public Voertuig findVoertuigById(int id){
        return repository.findVoertuigById(id);
    }

    public void deleteVoertuig(int id){
        repository.deleteVoertuig(id);
    }

}
