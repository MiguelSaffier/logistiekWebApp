package sr.unasat.repository;

import sr.unasat.entity.Levering;
import sr.unasat.service.BestellingService;
import sr.unasat.strategy.LeveringStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LeveringRepo {

    private Levering levering;

    private final EntityManager entityManager;

    public LeveringRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Levering> getLevering() {
        String query = "select l from Levering l";
        TypedQuery<Levering> typedQuery = entityManager.createQuery(query, Levering.class);
        return typedQuery.getResultList();
    }

    private Levering createLevering(Levering levering) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(levering);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return levering;
    }

    public Levering createLevering(int bestellingId) {
        levering = new Levering();
        BestellingService bs = new BestellingService();

        levering.setStatus(LeveringStrategy.setLeveringStatus(bestellingId));
        levering.setBestelling(bs.findBestellingById(bestellingId));

        return createLevering(levering);
    }

    public Levering updateStatus(int id, String status){
        try {
            entityManager.getTransaction().begin();
             levering = findOneLeveringById(id);
             levering.setStatus(status);
            entityManager.persist(levering);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return levering;
    }

    public Levering updateTotaleKosten(int id, double totaleKosten){
        try {
            entityManager.getTransaction().begin();
            levering = findOneLeveringById(id);
            levering.setTotaleKosten(totaleKosten);
            entityManager.persist(levering);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return levering;

    }

    public Levering findOneLeveringById(int id){
            Levering levering = entityManager.find(Levering.class, id);
        if (levering == null) {
            throw new EntityNotFoundException("Can't find levering for ID "
                    + id);
        }
            return levering;

    }

    public void deleteLevering(int id){
        try {
            entityManager.getTransaction().begin();
            levering = findOneLeveringById(id);
            entityManager.remove(levering);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
