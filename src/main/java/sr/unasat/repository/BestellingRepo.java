package sr.unasat.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import sr.unasat.entity.Bestelling;
import sr.unasat.entity.BestellingProduct;
import sr.unasat.service.KlantService;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

public class BestellingRepo {

    private Bestelling bestelling;

    private final EntityManager entityManager;

    public BestellingRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Bestelling> getBestelling() {
        String query = "select b from Bestelling b";
        TypedQuery<Bestelling> typedQuery = entityManager.createQuery(query, Bestelling.class);
        return typedQuery.getResultList();
    }

    public List<BestellingProduct> getProducten() {
        return bestelling.getProducten();
    }

    private Bestelling createBestelling(Bestelling bestelling) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bestelling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return bestelling;
    }

    public Bestelling createBestelling(String voorNaam, String achterNaam, int jaar, int maand, int dag ) {
        bestelling = new Bestelling();
        KlantService ks = new KlantService();

        bestelling.setBestellingDatum(LocalDate.now());
        bestelling.setLeveringDatum(new GregorianCalendar(jaar, maand, dag));
        bestelling.setKlant(ks.findKlantByName(voorNaam, achterNaam));

        return createBestelling(bestelling);
    }

    public Bestelling findOneBestelling(int id) {
        Bestelling bestelling = entityManager.find(Bestelling.class, id);
        if (bestelling == null) {
            throw new EntityNotFoundException("Can't find bestelling for ID "
                    + id);
        }
        return bestelling;
    }

//    public Bestelling updateLeveringKosten(int id, double leveringKosten) {
//        try {
//            entityManager.getTransaction().begin();
//            bestelling = findOneBestelling(id);
//            bestelling.setLeveringskosten(leveringKosten);
//            entityManager.persist(bestelling);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        return null;
//    }

    public Bestelling updateLeveringDatum(int id, int jaar, int maand, int dag) {

        try {
            entityManager.getTransaction().begin();
            bestelling = findOneBestelling(id);
            bestelling.setLeveringDatum(new GregorianCalendar(jaar, maand, dag));
            entityManager.persist(bestelling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    public void deleteBestelling(int id) {
        try {
            entityManager.getTransaction().begin();
            bestelling = findOneBestelling(id);
            entityManager.remove(bestelling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
