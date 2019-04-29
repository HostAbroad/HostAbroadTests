package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.businessObjects.Interest;
import com.business.businessObjects.Traveler;
import com.business.businessObjects.UserHA;
import com.business.enums.CountriesEnum;
import com.business.enums.DurationOfStayEnum;
import com.business.enums.InterestsEnum;
import com.business.enums.KnowledgesEnum;

public class InterestsTestHU32 {

	@Test
	public void test() {
		Interest int1, int2;
		
		UserHA user1, user2;
		user1 = new UserHA("Adri", "Adrian", 5.0, "usuario viajero", "adri@gmail.com", 1234, false, true);
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Austria);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.Chemistry);
		Traveler traveler1 = new Traveler(1, user1, listOfCountries, listOfKnowledges, DurationOfStayEnum.OneToTwoWeeks);
		user1.setTravelerEntity(traveler1);
		user1.setHostEntity(null);
		
		user1.setBirthday("21/6");
		user1.setGender("m");
		user1.setPhoto("foto1");
		
		int1 = new Interest(user1, InterestsEnum.Cars.getString());
		int2 = new Interest(user1, InterestsEnum.Animals.getString());
		ArrayList<Interest> intereses = new ArrayList<Interest>();
		intereses.add(int1);
		intereses.add(int2);
		user1.setInterests(intereses);
		
		/*
		//Para crear los objetos manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(user1);
		em.persist(int1);
		em.persist(int2);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		assertEquals(int1.getUser(), user1);
		assertEquals(int1.getInterest(), "Cars");
		assertEquals(int2.getUser(), user1);
		assertEquals(int2.getInterest(), "Animals");
		
	}

}
