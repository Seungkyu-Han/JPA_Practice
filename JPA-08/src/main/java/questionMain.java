import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class questionMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            question question1 = new question("1", "문제1", List.of("1번", "2번", "3번", "4번", "5번"));
            entityManager.persist(question1);
            entityTransaction.commit();
        }catch (Exception ignored){

        }

        try{
            question question2 = entityManager.find(question.class,"1");
            for(String choice : question2.getChoices()){
                System.out.println(choice);
            }
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
