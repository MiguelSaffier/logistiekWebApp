package sr.unasat.repository;

import jakarta.persistence.EntityNotFoundException;
import sr.unasat.entity.*;
import sr.unasat.service.LeveringService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

import static sr.unasat.strategy.LeveringStrategy.*;

public class VoertuigChauffeurRepo {

    private LeveringService ls = new LeveringService();

    private final EntityManager entityManager;

    public VoertuigChauffeurRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void CreateVoertuigChauffeur(Levering levering, int bestellingId) {

        List<VrachtWagen> vrachtWagenList = setJuisteVoertuig(bestellingId);
        List<Chauffeur> chauffeurList = setJuisteChauffeur(vrachtWagenList);

        for (int i = 0; i < vrachtWagenList.size(); i++) {
            VoertuigChauffeur voertuigChauffeur = new VoertuigChauffeur();
            entityManager.getTransaction().begin();

            voertuigChauffeur.setLevering(levering);
            voertuigChauffeur.setChauffeur(chauffeurList.get(i));
            voertuigChauffeur.setLeveringskosten(1000.0);   //hardcoded, een heel grove schatting,
            //dit zou afhankelijk moeten zijn van afstand
            //maar afstand is geen variabel in deze,
            //kan veranderd worden met een update indien nodig
            voertuigChauffeur.setVrachtWagen(vrachtWagenList.get(i));
            entityManager.persist(voertuigChauffeur);
            entityManager.getTransaction().commit();
        }
        ls.updateTotaleKosten(levering.getId(), setKosten(bestellingId, levering));
    }

    public List<VoertuigChauffeur> getVoertuigChauffeur(Levering levering) {
        String findAllKosten = "select v from VoertuigChauffeur v where v.levering = :levering";
        Query query = entityManager.createQuery(findAllKosten);
        query.setParameter("levering", levering);
        List<VoertuigChauffeur> results = query.getResultList();
        return results;
    }

    public List<VoertuigChauffeur> getVoertuigChauffeur(int id) {
        String findAllKosten = "select v from VoertuigChauffeur v where v.levering.id = :id";
        Query query = entityManager.createQuery(findAllKosten);
        query.setParameter("id", id);
        List<VoertuigChauffeur> results = query.getResultList();
        return results;
    }

    public List<VoertuigChauffeur> getVoertuigChauffeurDetail() {
        String findLeveringDetail = "select vc.id, l.id, l.status, l.totaleKosten, l.bestelling.id  , c.id, c.voornaam, c.achternaam,v.id,  v.merk, v.kentekenNummer, v.capaciteit, vc.leveringskosten " +
                "from VoertuigChauffeur vc " +
                "inner join Chauffeur c on vc.chauffeur.id = c.id " +
                "inner join VrachtWagen v on vc.vrachtWagen.id = v.id " +
                "inner join Levering  l on vc.levering.id = l.id";
        Query query = entityManager.createQuery(findLeveringDetail);
        List<VoertuigChauffeur> results = query.getResultList();
        return results;
    }

    public List<VoertuigChauffeur> findVoertuigChauffeur(int id) {
        String findAllKosten = "select vc.id, l.id, l.status, l.totaleKosten, l.bestelling.id  , c.id, c.voornaam, c.achternaam,v.id,  v.merk, v.kentekenNummer, v.capaciteit, vc.leveringskosten " +
                "from VoertuigChauffeur vc " +
                "inner join Chauffeur c on vc.chauffeur.id = c.id " +
                "inner join VrachtWagen v on vc.vrachtWagen.id = v.id " +
                "inner join Levering  l on vc.levering.id = l.id " +
                "where vc.levering.id = :id";
        Query query = entityManager.createQuery(findAllKosten);
        query.setParameter("id", id);
        List<VoertuigChauffeur> results = query.getResultList();
        return results;
    }


    public VoertuigChauffeur findVoertuigChauffeurByid(int id) {
        VoertuigChauffeur voertuigChauffeur = entityManager.find(VoertuigChauffeur.class, id);
        if (voertuigChauffeur == null) {
            throw new EntityNotFoundException("Can't find klant for ID "
                    + id);
        }
        return voertuigChauffeur;
    }


    public VoertuigChauffeur updateLeveringskosten(int id, double kosten) {
        VoertuigChauffeur voertuigChauffeur = new VoertuigChauffeur();
        try {
            entityManager.getTransaction().begin();
            voertuigChauffeur = findVoertuigChauffeurByid(id);
            voertuigChauffeur.setLeveringskosten(kosten);
            entityManager.persist(voertuigChauffeur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        Levering levering = voertuigChauffeur.getLevering();
        int bestellingId = levering.getBestelling().getId();

        ls.updateTotaleKosten(levering.getId(), setKosten(bestellingId, levering));
        return voertuigChauffeur;
    }

    public void deleteVoertuigChauffeur(int id) {
        try {
            entityManager.getTransaction().begin();
            List<VoertuigChauffeur> voertuigChauffeurList = getVoertuigChauffeur(id);
            for (int i = 0; i < voertuigChauffeurList.size(); i++) {
                entityManager.remove(voertuigChauffeurList.get(i));
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
