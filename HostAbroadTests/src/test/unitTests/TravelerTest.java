package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.CountriesEnum;
import com.business.DurationOfStayEnum;
import com.business.KnowledgesEnum;
import com.business.Traveler;
import com.business.User;

public class TravelerTest {
	private Traveler mytraveler;
	
	@Test
	public void test() {
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Brazil);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.ProfesionalDelLOl);
		User myUser = new User("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", false, true);
		this.mytraveler = new Traveler(1, myUser, listOfCountries, listOfKnowledges, DurationOfStayEnum.Op2);
		
		User aux_user = new User("Jose", "j", "j@a", "j1", 2, "este se modifica", false, true);
		Traveler aux_traveler = new Traveler(2, aux_user, null, null, null);
		
		aux_traveler.setId(1);
		assertEquals(aux_traveler.getId(), this.mytraveler.getId());
		
		aux_traveler.setListOfCountries(listOfCountries);
		assertEquals(aux_traveler.getListOfCountries(), this.mytraveler.getListOfCountries());
		
		aux_traveler.setListOfKnowledges(listOfKnowledges);
		assertEquals(aux_traveler.getListOfKnowledges(), this.mytraveler.getListOfKnowledges());
		
		aux_traveler.setDurationOfStay(DurationOfStayEnum.Op2);
		assertEquals(aux_traveler.getDurationOfStay(), this.mytraveler.getDurationOfStay());
		
		/*
		//Para crear un nuevo usuario manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(this.mytraveler);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
	}

}
