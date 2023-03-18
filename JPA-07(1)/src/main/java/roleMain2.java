import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Set;

public class roleMain2{
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            information info1 = new information("per1", "info1");
            information info2 = new information("per2", "info2");
            job2 jobA = new job2("1", "안녕", Set.of(info1, info2));
            entityManager.persist(jobA);
            entityTransaction.commit();
        }catch(Exception ignored){

        }

        try{
            job2 jobB = entityManager.find(job2.class, "1");
            for(information info : jobB.getInformationSet()){
                System.out.println(info.getInfo() + info.getPermission());
            }
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}