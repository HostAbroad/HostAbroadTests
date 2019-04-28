package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.ASFactory.ASFactory;
import com.business.ASLikes.ASLikesImp;
import com.business.ASUser.ASUserImp;
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
import com.business.transfers.TLikes;

public class ASLikesImpTestHU23 {
	ASLikesImp sauser;

	@Test
	public void test() {
		this.sauser = (ASLikesImp) ASFactory.getInstance().createASLikes();
		UserHA user1, user2;
		user1 = new UserHA("Adri", "Adrian", "adri@gmail.com", 1234, 5, "usuario viajero", false, true, null);
		user2 = new UserHA("Jose", "j", "j@a", 5678, 2, "usuario anfitrion", true, false, null);
		
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
		
		TLikes tlike = new TLikes(user1.getNickname(), user2.getNickname());
		
		this.sauser.sendLike(tlike);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		Likes like = em.find(Likes.class, 5);
		tr.commit();
		
		em.close();
		emf.close();
		
		ArrayList<Likes> likes = new ArrayList<Likes>();
		likes.add(like);
		
		assertEquals(like.getUserSender().getNickname(), user1.getNickname());
		assertEquals(like.getUserReceiver().getNickname(), user2.getNickname());
	}

}
