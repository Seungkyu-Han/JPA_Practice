import jakarta.persistence.*;
import jpabasic.reserve.domain.User;
import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {
        //persistence.xml 파일에 정의한 영속 단위 기준으로 초기화
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabegin");

        //EntityManager 를 생성
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //EntityTransaction 구함
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            //Transaction 을 시작


            transaction.begin();
            User user = new User("hello@gmail.com", "hello", LocalDateTime.now());
            entityManager.persist(user);

            //Transaction 을 커밋, 이 시점에 INSERT 쿼리를 실행
            transaction.commit();
        } catch(Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        //팩토리를 닫음, 사용한 자원 반환
        entityManagerFactory.close();
    }
}
