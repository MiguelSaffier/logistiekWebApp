package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Klant;
import sr.unasat.repository.KlantRepo;

import java.util.List;

public class KlantService {

    private final KlantRepo repository;

    public KlantService() {;
        this.repository = new KlantRepo(JPAConfiguration.getEntityManager());
    }

    public List<Klant> getKlant() {
        return repository.getKlant();
    }

//    public List<KlantDTO> getKlant() {
//        return repository.getKlant().stream().map(klantDTOMapper).collect(Collectors.toList());
//    }

    public Klant createKlant(String voornaam, String achternaam, String adres, String telefoon) {
        return repository.createKlant(voornaam, achternaam, adres, telefoon);
    }
    public Klant createKlant(Klant klant) {
        return repository.createKlant(klant);
    }

    public Klant findKlantByName(String voorNaam, String achterNaam) {
        return repository.findOneKlant(voorNaam, achterNaam);
    }

    public Klant findKlantByid(int id) {
        return repository.findKlantByid(id);
    }

    public Klant updateNaam(int id, String voornaam, String achternaam) {
        return repository.updateNaam(id, voornaam, achternaam);
    }

    public Klant updateTelefoon(int id, String telefoon) {
        return repository.updateTelefoon(id, telefoon);
    }

    public Klant updateAdres(int id, String adres) {
         return repository.updateAdres(id, adres);
    }

    public void deleteKlant(int id) {
        repository.deleteKlant(id);
    }

    public Klant updateKlant(int id, String voornaam, String achternaam, String adres, String telefoon){
        return repository.updateKlant(id, voornaam, achternaam, adres, telefoon);
    }

}
