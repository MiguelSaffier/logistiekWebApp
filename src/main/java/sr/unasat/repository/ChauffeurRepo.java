package sr.unasat.repository;

import sr.unasat.entity.Chauffeur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ChauffeurRepo {
    private Chauffeur chauffeur;

    private final EntityManager entityManager;

    public ChauffeurRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Chauffeur> getChauffeur() {
        String query = "select c from Chauffeur c";
        TypedQuery<Chauffeur> typedQuery = entityManager.createQuery(query, Chauffeur.class);
        return typedQuery.getResultList();
    }

    private Chauffeur createChauffeur(Chauffeur chauffeur) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(chauffeur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return chauffeur;
    }

    public Chauffeur createChauffeur(String voornaam, String achternaam, String telefoon, String imagePath) {
        chauffeur = new Chauffeur();
        chauffeur.setVoornaam(voornaam);
        chauffeur.setAchternaam(achternaam);
        chauffeur.setTelefoon(telefoon);
        chauffeur.setImage(imagePath);
        return createChauffeur(chauffeur);
    }

    public Chauffeur findOneChauffeur(String voorNaam, String achterNaam) {
            String findChauffeurName = "select c from Chauffeur c where c.voornaam = :voorNaam and c.achternaam = :achterNaam";
            Query query = entityManager.createQuery(findChauffeurName);
            query.setParameter("voorNaam", voorNaam);
            query.setParameter("achterNaam", achterNaam);
            Object singleResult = query.getSingleResult();
            return (sr.unasat.entity.Chauffeur) singleResult;
    }

    public Chauffeur findChauffeurById(int id) {
        Chauffeur chauffeur = entityManager.find(Chauffeur.class, id);
        if (chauffeur == null) {
            throw new EntityNotFoundException("Can't find chauffeur for ID "
                    + id);
        }
        return chauffeur;
    }

    public Chauffeur updateNaam(int id, String voorNaam, String achterNaam) {
        try {
            entityManager.getTransaction().begin();
            chauffeur = findChauffeurById(id);
            chauffeur.setVoornaam(voorNaam);
            chauffeur.setAchternaam(achterNaam);
            entityManager.persist(chauffeur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    public Chauffeur updateTelefoon(int id, String telefoonNummer) {
        try {
            entityManager.getTransaction().begin();
            chauffeur = findChauffeurById(id);
            chauffeur.setTelefoon(telefoonNummer);
            entityManager.persist(chauffeur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    public void deleteChauffeur(int id) {
        try {
            entityManager.getTransaction().begin();
            chauffeur = findChauffeurById(id);
            entityManager.remove(chauffeur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
