package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.businessObjects.Host;
import com.business.businessObjects.Place;
import com.business.businessObjects.UserHA;
import com.business.enums.FamilyUnit;
import com.business.enums.InterestsEnum;



public class PlaceTest {
	private Place myPlace;
	
	@Test
	public void test() {
		UserHA myUser = new UserHA("Adri", "Adrian", "adri@gmail.com", 1234, 5, "pruebas para login", true, false);
		
		ArrayList<InterestsEnum> intereses = new ArrayList<InterestsEnum>();
		intereses.add(InterestsEnum.Arts);
		Host myHost = new Host(1, myUser, intereses);
		
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		this.myPlace = new Place("calle piruleta", "dulce", noAvaliableDates, "foto", FamilyUnit.Alone, myHost);
		
		Place aux = new Place(null, null, null, null, null, null);
		
		aux.setAddress("calle piruleta");
		assertEquals(aux.getAddress(), this.myPlace.getAddress());
		
		aux.setDescription("dulce");
		assertEquals(aux.getDescription(), this.myPlace.getDescription());
		
		aux.setNoAvaliableDates(noAvaliableDates);
		assertEquals(aux.getNoAvaliableDates(), this.myPlace.getNoAvaliableDates());
		
		aux.setPhoto("foto");
		assertEquals(aux.getPhoto(), this.myPlace.getPhoto());
		
		aux.setFamilyUnit(FamilyUnit.Alone);
		assertEquals(aux.isFamilyUnit(), this.myPlace.isFamilyUnit());
		
		aux.setHost(myHost);
		assertEquals(aux.getHost(), this.myPlace.getHost());
		
		/*
		//Para crearlo manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(this.myPlace);
		em.persist(myHost);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
	}

}
