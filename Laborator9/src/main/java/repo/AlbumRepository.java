package repo;

import entity.Albums;
import entity.Artists;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import util.PersistenceUtil;

public class AlbumRepository {

    public void create(Albums album) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(album);
            entityTransaction.commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }
    }

    public Albums findById(int albumsId) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Albums album = entityManager.find(Albums.class, albumsId);
        entityManager.persist(album);
        entityTransaction.commit();

        entityManager.close();
        return album;
    }

    public List<Albums> findByName(String name) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Albums> albums = entityManager.createNamedQuery("Albums.findByName")
                .setParameter("name", name)
                .getResultList();

        entityManager.close();
        return albums;
    }
    public List<Albums> findByArtist(int artistId)
    {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Albums> albums = entityManager.createNamedQuery("Albums.findByArtistId")
                .setParameter("artistId", artistId)
                .getResultList();

        entityManager.close();
        return albums;
    }
}
