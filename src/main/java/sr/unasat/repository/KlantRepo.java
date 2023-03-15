package sr.unasat.repository;

import sr.unasat.entity.Klant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class KlantRepo {
    private Klant klant;
    private final EntityManager entityManager;

    public KlantRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Klant> getKlant() {
        String query = "select k from Klant k";
        TypedQuery<Klant> typedQuery = entityManager.createQuery(query, Klant.class);
        return typedQuery.getResultList();
    }

    public Klant createKlant(Klant klant){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return klant;
    }

    public Klant createKlant(String voornaam, String achternaam, String adres, String telefoon){
        klant = new Klant();
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setAdres(adres);
        klant.setTelefoon(telefoon);
        return createKlant(klant);
    }

    public Klant findOneKlant(String voorNaam, String achterNaam) {
        try{
            entityManager.getTransaction().begin();
            String findKlantName = "select k from Klant k where k.voornaam = :voorNaam and k.achternaam = :achterNaam";
            Query query = entityManager.createQuery(findKlantName);
            query.setParameter("voorNaam", voorNaam);
            query.setParameter("achterNaam", achterNaam);
            Object singleResult = query.getSingleResult();
            entityManager.getTransaction().commit();
            return (sr.unasat.entity.Klant) singleResult;}
        catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    public Klant findKlantByid(int id){
            Klant klant = entityManager.find(Klant.class, id);
        if (klant == null) {
            throw new EntityNotFoundException("Can't find klant for ID "
                    + id);
        }
            return klant;
    }

    public Klant updateNaam(int id, String voorNaam, String achterNaam){
        try {
            entityManager.getTransaction().begin();
            klant = findKlantByid(id);
            klant.setVoornaam(voorNaam);
            klant.setAchternaam(achterNaam);
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant;
    }

    public Klant updateTelefoon(int id, String telefoonNummer){
        try {
            entityManager.getTransaction().begin();
            klant = findKlantByid(id);
            klant.setTelefoon(telefoonNummer);
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant;
    }

    public Klant updateAdres(int id, String adres){
        try {
            entityManager.getTransaction().begin();
            klant = findKlantByid(id);
            klant.setAdres(adres);
            entityManager.persist(klant);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return klant;
    }

    public void deleteKlant(int id){
        try {
            entityManager.getTransaction().begin();
            klant = findKlantByid(id);
            entityManager.remove(klant);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }



}
