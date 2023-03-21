import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class book_main2 {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Map<String, PropValue> Propvalues = new HashMap<>();

        PropValue propValue1 = new PropValue("value1", true);
        PropValue propValue2 = new PropValue("value2", true);

        Propvalues.put("String1", propValue1);
        Propvalues.put("String2", propValue2);

        book2 book1 = new book2("id1", "title1", "content1", Propvalues);
        book2 book2;

        try{
            entityTransaction.begin();
            entityManager.persist(book1);
            entityTransaction.commit();
        }catch (NullPointerException exception){
            throw new NullPointerException();
        }

        try{
            book2 = entityManager.find(book2.class, "id1");
            System.out.println(book2);
        }catch(NullPointerException exception){
            throw new NullPointerException();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();

    }
}
