package UserProgram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {

    private static EntityManagerFactory entityManagerFactory;

    public static void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close(){
        entityManagerFactory.close();
    }
}
