package systemAcceptanceTests.seleniumgluecode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.User;

public class FindUserHelper {


    public static void clearDataBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String query = "delete from hostabroad.USER";
        em.createNativeQuery(query).executeUpdate();
        //don't know if it is needed
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}