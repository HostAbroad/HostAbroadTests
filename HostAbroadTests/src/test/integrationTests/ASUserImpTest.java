package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.FamilyUnit;
import com.business.Host;
import com.business.Place;
import com.business.TPlace;
import com.business.User;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;

public class ASUserImpTest {
	private ASUserImp sauser;
	
	@Test
	public void test() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		TPlace myPlace = new TPlace("calle piruleta", "dulce", noAvaliableDates, "foto", FamilyUnit.Fam1, "Adri");
		
		this.sauser.addPlace(myPlace);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		Place place = em.find(Place.class, myPlace.getAddress());
		Host host = em.find(User.class, myPlace.getNickname()).getHostEntity();
		
		em.close();
		emfactory.close();
		
		assertEquals(place.getAddress(), myPlace.getAddress());
		assertEquals(place.getDescription(), myPlace.getDescription());
		assertEquals(place.getNoAvaliableDates(), myPlace.getNoAvaliableDates());
		assertEquals(place.getPhoto(), myPlace.getPhoto());
		assertEquals(place.isFamilyUnit(), myPlace.getFamilyUnit());
		assertEquals(place.getHost(), host);
	
	}

}
