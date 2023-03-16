package UserProgram;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserService {

    public void CreateUser(User user){
        EntityManager entityManager = EMF.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        }catch(Exception exception){
            entityTransaction.rollback();
            throw exception;
        } finally {
            entityManager.close();
        }
    }

    public User ReadUser(String email){
        EntityManager entityManager = EMF.getEntityManager();
        try{
            User user = entityManager.find(User.class, email);
            if(user == null) throw new NullPointerException();
            else return user;
        }finally{
            entityManager.close();
        }
    }

    public void UpdateUser(String email, String name){
        EntityManager entityManager = EMF.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            User user = entityManager.find(User.class, email);
            if(user == null) throw new NullPointerException();
            user.setName(name);
            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
            throw exception;
        }finally {
            entityManager.close();
        }
    }

    public void DeleteUser(String email){
        EntityManager entityManager = EMF.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            User user = entityManager.find(User.class, email);
            if (user == null) throw new NullPointerException();
            entityManager.remove(user);
            entityTransaction.commit();
        }catch(Exception exception){
            entityTransaction.rollback();
            throw exception;
        }finally {
            entityManager.close();
        }
    }
}
