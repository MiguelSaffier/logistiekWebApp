package sr.unasat.service;

import sr.unasat.configuration.JPAConfiguration;
import sr.unasat.entity.Klant;
import sr.unasat.repository.KlantRepo;

import java.util.List;

public class KlantService {

    private final KlantRepo repository;

    public KlantService() {
        this.repository = new KlantRepo(JPAConfiguration.getEntityManager());
    }

    public List<Klant> getKlant() {
        return repository.getKlant();
    }

    public Klant createKlant(String voornaam, String achternaam, String adres, String telefoon) {
        return repository.createKlant(voornaam, achternaam, adres, telefoon);
    }

    public Klant findKlantByName(String voorNaam, String achterNaam) {
        return repository.findOneKlant(voorNaam, achterNaam);
    }

    public Klant findKlantByid(int id) {
        return repository.findKlantByid(id);
    }

    public void updateNaam(int id, String voornaam, String achternaam) {
        repository.updateNaam(id, voornaam, achternaam);
    }

    public void updateTelefoon(int id, String telefoon) {
        repository.updateTelefoon(id, telefoon);
    }

    public void updateAdres(int id, String adres) {
        repository.updateAdres(id, adres);
    }

    public void deleteKlant(int id) {
        repository.deleteKlant(id);
    }

}
