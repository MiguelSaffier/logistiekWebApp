package sr.unasat.repository;

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

    public List<VoertuigChauffeur> getVoertuigChauffeur(Levering levering){
        String findAllKosten = "select v from VoertuigChauffeur v where v.levering = :levering";
        Query query = entityManager.createQuery(findAllKosten);
        query.setParameter("levering", levering);
        List<VoertuigChauffeur> results = query.getResultList();
        return results;
    }

}
