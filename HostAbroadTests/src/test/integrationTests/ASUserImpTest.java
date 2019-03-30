package integrationTests;

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
import com.business.TTraveler;
import com.business.Traveler;
import com.business.User;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;

public class ASUserImpTest {
	private ASUserImp sauser;
	
	@Test
	public void editTravelerInformationest() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Argentina);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.ScrumMaster);
		
		TTraveler myTraveler = new TTraveler("Adri", listOfCountries, listOfKnowledges, DurationOfStayEnum.Op4);
		TTraveler new_traveler = new TTraveler();
		new_traveler.setDurationOfStay(DurationOfStayEnum.Op4);
		new_traveler.setListOfCountries(listOfCountries);
		new_traveler.setListOfKnowledges(listOfKnowledges);
		
		this.sauser.editTravelerInformation(myTraveler);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		User user = em.find(User.class, myTraveler.getNickname());
		
		em.close();
		emfactory.close();
		
		Traveler traveler = user.getTravelerEntity();
		
		assertEquals(traveler.getDurationOfStay(), new_traveler.getDurationOfStay());
		assertEquals(traveler.getListOfCountries(), new_traveler.getListOfCountries());
		assertEquals(traveler.getListOfKnowledges(), new_traveler.getListOfKnowledges());
		
	}

}
