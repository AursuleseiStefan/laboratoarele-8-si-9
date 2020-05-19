package repo;

import entity.Artists;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import util.PersistenceUtil;

public class ArtistRepository {

    public void create(Artists artist) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(artist);
            entityTransaction.commit();//salveaza in baza de date
        } catch (Exception e) {

        } finally {
            entityManager.close();//ichid entitymanagerul
        }
    }

    public Artists findById(int artistId) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Artists artist = entityManager.find(Artists.class, artistId);
        entityManager.persist(artist);
        entityTransaction.commit();

        entityManager.close();
        return artist;

    }

    public List<Artists> findByName(String name) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Artists> artists = entityManager.createNamedQuery("Artists.findByName")
                .setParameter("name", name)
                .getResultList();
//iau un query,ii setez parametrul,si returnez
        entityManager.close();
        return artists;
    }
}
