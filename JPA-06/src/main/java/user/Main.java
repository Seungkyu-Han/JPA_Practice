package user;

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
            school school1 = new school("abc", "def", "ghi");
            user user1 = new user("hello@gmail.com", "hi", school1);
            entityManager.persist(user1);
            entityTransaction.commit();
        }catch(Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        try{
            entityTransaction.begin();
            user user2 = entityManager.find(user.class, "hello@gmail.com");
            System.out.println(user2);
        }catch(Exception exception){

        }finally {
            entityManager.close();
        }
    }
}
