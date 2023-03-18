import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Set;

public class roleMain{
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            job job1 = new job("1", "안녕", Set.of("11", "22"));
            entityManager.persist(job1);
            entityTransaction.commit();
        }catch(Exception ignored){

        }

        try{
            job job2 = entityManager.find(job.class, "1");
            for(String perm : job2.getPermissions()){
                System.out.println(perm);
            }
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}