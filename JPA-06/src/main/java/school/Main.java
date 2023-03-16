package school;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            info firstInfo1 = new info("aaa", "bbb");
            info firstInfo2 = new info("ccc", "ddd");
            school firstSchool = new school(firstInfo1, firstInfo2);
            entityManager.persist(firstSchool);
            entityTransaction.commit();
        }catch(Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        try{
            entityTransaction.begin();
            school secondSchool = entityManager.find(school.class, "aaa");
            System.out.println(secondSchool);
        }catch(Exception exception){

        }finally {
            entityManager.close();
        }
    }
}
