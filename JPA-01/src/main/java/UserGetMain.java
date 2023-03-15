import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

public class UserGetMain {
    public static void main(String[] args) {

        String find_id = "hello@gmail.com";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            User user = entityManager.find(User.class, find_id);
            if (user == null) System.out.println("User 없음");
            else {
                System.out.printf("\n\nemail : %s, name = %s, createDate = %s\n\n\n", user.getEmail(), user.getName(), user.getCreate_date());
            }
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }finally {
            entityManager.close();
        }
        entityManager.close();
    }
}
