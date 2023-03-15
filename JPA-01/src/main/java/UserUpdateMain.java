import jakarta.persistence.*;
import jpabasic.reserve.domain.User;
import java.time.LocalDateTime;

public class UserUpdateMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            User user = entityManager.find(User.class, "hello@gmail.com");
            if(user == null) System.out.println("User 없음");
            else user.setName("hi");

            //수정도 커밋 시점에 update 쿼리를 실행
            transaction.commit();
        } catch(Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManager.close();
    }
}
