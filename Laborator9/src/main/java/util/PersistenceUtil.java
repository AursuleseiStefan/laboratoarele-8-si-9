package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceUtil {
    private static EntityManagerFactory factory;
    private PersistenceUtil(){}
    public static EntityManagerFactory getEntityManagerFactory()
    {
        if(factory==null)
            factory=Persistence.createEntityManagerFactory("MusicAlbumsPU");
        return factory;
    }
    public static void closeFactory()
    {
        if(factory.isOpen() || factory!=null)
            factory.close();
            
    }
}
