package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.businessObjects.Host;
import com.business.businessObjects.Likes;
import com.business.businessObjects.Place;
import com.business.businessObjects.Traveler;
import com.business.businessObjects.UserHA;
import com.business.enums.CountriesEnum;
import com.business.enums.DurationOfStayEnum;
import com.business.enums.FamilyUnit;
import com.business.enums.InterestsEnum;
import com.business.enums.KnowledgesEnum;
public class UserHATestHU31 {

	@Test
	public void test() {
		
		UserHA user1, user2;
		user1 = new UserHA("Adri", "Adrian", "adri@gmail.com", 1234, 5.0, "usuario viajero", "foto1", "m", null, false, true, null, null, null, null, null, null, null);
		user2 = new UserHA("Jose", "j", "j@a", 5678, 2, "usuario anfitrion", "foto2", "f", null, true, false, null, null, null, null, null, null, null);
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Austria);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.Chemistry);
		Traveler traveler1 = new Traveler(1, user1, listOfCountries, listOfKnowledges, DurationOfStayEnum.OneToTwoWeeks);
		user1.setTravelerEntity(traveler1);
		user1.setHostEntity(null);
		
		ArrayList<InterestsEnum> intereses = new ArrayList<InterestsEnum>();
		intereses.add(InterestsEnum.Music);
		Host host2 = new Host(1, user2, intereses);
		
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		Place place = new Place("calle piruleta", "dulce", noAvaliableDates, "foto", FamilyUnit.Alone, host2);
		ArrayList<Place> places = new ArrayList<Place>();
		places.add(place);
		host2.setPlaces(places);
		user2.setHostEntity(host2);
		user2.setTravelerEntity(null);
		
		/*
		//Para crear los objetos manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(traveler1);
		em.persist(place);
		em.persist(host2);
		em.persist(user1);
		em.persist(user2);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		assertEquals(user1.getTravelerEntity(), traveler1);
		assertEquals(user1.getLikes(), null);
		assertEquals(user1.getHostEntity(), null);
		assertEquals(user2.getHostEntity(), host2);
		assertEquals(user2.getTravelerEntity(), null);
}

}
