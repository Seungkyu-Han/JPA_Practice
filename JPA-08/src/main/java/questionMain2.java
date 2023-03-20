import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class questionMain2 {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            question2 question1 = new question2("1", "문제1", List.of(new choice("1", false),
                    new choice("2", true)));
            entityManager.persist(question1);
            entityTransaction.commit();
        }catch (Exception ignored){

        }

        try{
            question2 question2 = entityManager.find(question2.class,"1");
            for(choice choice : question2.getChoiceList()){
                System.out.println(choice.getInput() + ", " + choice.getText());
            }
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
