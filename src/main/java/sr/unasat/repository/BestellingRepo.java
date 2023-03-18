package sr.unasat.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.unasat.entity.Bestelling;
import sr.unasat.service.KlantService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public List<Bestelling> getBestellingDetail(){
        String findBestelling = "select b.id as id, b.bestellingDatum as bestellingDatum, k.id, k.voornaam, k.achternaam, b.leveringDatum, k.telefoon from Bestelling b inner join Klant k on b.klant.id = k.id";
        Query query = entityManager.createQuery(findBestelling);
        Object singleResult = query.getResultList();
        return (List<Bestelling>) singleResult;
    }

    public List<Bestelling> getBestellingDetail(int id){
        String findOneBestelling = "select b.id, b.bestellingDatum, k.id, k.voornaam, k.achternaam, b.leveringDatum, k.telefoon from Bestelling b inner join Klant k on b.klant.id = k.id where b.id = :id";
        Query query = entityManager.createQuery(findOneBestelling);
        query.setParameter("id", id);
        Object singleResult = query.getResultList();
        return (List<Bestelling>) singleResult;
    }

//    public List<BestellingProduct> getProducten() {
//        return bestelling.getProducten();
//    }

    public Bestelling createBestelling(Bestelling bestelling) {
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

    public Bestelling createBestelling(int id, int jaar, int maand, int dag) {
        bestelling = new Bestelling();
        KlantService ks = new KlantService();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        bestelling.setBestellingDatum(LocalDate.now().format(formatter));
        bestelling.setLeveringDatum(LocalDate.of(jaar, maand, dag).format(formatter));
        bestelling.setKlant(ks.findKlantByid(id));

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

    public Bestelling updateLeveringDatum(int id, int jaar, int maand, int dag) {

        try {
            entityManager.getTransaction().begin();
            bestelling = findOneBestelling(id);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            bestelling.setLeveringDatum(LocalDate.of(jaar, maand, dag).format(formatter));
            entityManager.persist(bestelling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return bestelling;
    }

    public Bestelling updateBestelling(int bestellingId, int klantId, int jaar, int maand, int dag) {
        KlantService ks = new KlantService();
        try {
            entityManager.getTransaction().begin();
            bestelling = findOneBestelling(bestellingId);
            bestelling.setKlant(ks.findKlantByid(klantId));
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            bestelling.setLeveringDatum(LocalDate.of(jaar, maand, dag).format(formatter));
            entityManager.persist(bestelling);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return bestelling;
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
