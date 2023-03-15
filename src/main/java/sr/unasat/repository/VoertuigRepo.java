package sr.unasat.repository;

import sr.unasat.entity.VrachtWagen;
import sr.unasat.factory.Voertuig;
import sr.unasat.factory.VoertuigFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VoertuigRepo {

    private final VoertuigFactory voertuigFactory = new VoertuigFactory();
    private Voertuig voertuig;
    private final EntityManager entityManager;

    public VoertuigRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Voertuig> getVoertuig(String type) {
        try {
            if (type.equalsIgnoreCase("Vrachtwagen")) {
                String query = "select v from VrachtWagen v";
                TypedQuery<Voertuig> typedQuery = entityManager.createQuery(query, Voertuig.class);
                return typedQuery.getResultList();
            }
        } catch (Exception e) {
            System.out.println(type + " Bestaat niet!");
        }
        return null;
    }


    private Voertuig createVoertuig(Voertuig voertuig) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(voertuig);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return voertuig;
    }

    public Voertuig createVoertuig(String voertuigType, String merk, int capaciteit, String kentekenNummer) {
        voertuig = voertuigFactory.getInstance(voertuigType);
        voertuig.setMerk(merk);
        voertuig.setCapaciteit(capaciteit);
        voertuig.setKentekenNummer(kentekenNummer);
        return createVoertuig(voertuig);
    }

    public Voertuig createVoertuig(String voertuigType, Voertuig voertuig1) {
        voertuig1 = voertuigFactory.getInstance(voertuigType);
        return createVoertuig(voertuig1);
    }


    public Voertuig findVoertuigById(int id){
        return entityManager.find(VrachtWagen.class, id);
    }

    public void deleteVoertuig(int id){
        try {
            entityManager.getTransaction().begin();
            voertuig = findVoertuigById(id);
            entityManager.remove(voertuig);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


}
