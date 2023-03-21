import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class book_main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Map<String, String> props1 = new HashMap<>();
        Map<String, String> props2 = new HashMap<>();

        props1.put("name1", "value1");
        props1.put("name2", "value2");
        book book1 = new book("1", "이름", "내용", props1);
        book book2;

        try{
            entityTransaction.begin();
            entityManager.persist(book1);
            entityTransaction.commit();
        }catch(NullPointerException exception){
            throw new NullPointerException();
        }

        try{
            book2 = entityManager.find(book.class, "1");
        }catch(NullPointerException exception){
            throw new NullPointerException();
        }

        System.out.println("book: " + book2);
        System.out.println("props: " + book2.getProps());
    }
}
