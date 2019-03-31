package systemAcceptanceTests.seleniumgluecode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.User;

public class DataBaseHelper {


    public static void clearDataBase(String dataBaseToDelete) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String query = "delete from HOSTABROAD." + dataBaseToDelete;
        em.createNativeQuery(query).executeUpdate();
        //don't know if it is needed
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public static void clearDataBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String query = "delete from HOSTABROAD.Place";
        em.createNativeQuery(query).executeUpdate();
        query = "delete from HOSTABROAD.Host";
        em.createNativeQuery(query).executeUpdate();
        query = "delete from HOSTABROAD.Traveler";
        em.createNativeQuery(query).executeUpdate();
        query = "delete from HOSTABROAD.Likes";
        em.createNativeQuery(query).executeUpdate();
        query = "delete from HOSTABROAD.User";
        em.createNativeQuery(query).executeUpdate();
        //don't know if it is needed
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}