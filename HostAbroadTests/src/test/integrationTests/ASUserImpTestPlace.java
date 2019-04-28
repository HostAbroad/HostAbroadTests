package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.businessObjects.*;
import com.business.enums.FamilyUnit;
import com.business.transfers.TPlace;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;

public class ASUserImpTestPlace {
	private ASUserImp sauser;
	
	@Test
	public void test() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		TPlace myPlace = new TPlace("calle piruleta", "dulce", noAvaliableDates, "foto", FamilyUnit.Alone, "Adri");
		
		this.sauser.addPlace(myPlace);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		Place place = em.find(Place.class, myPlace.getAddress());
		Host host = em.find(UserHA.class, myPlace.getNickname()).getHostEntity();
		
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
