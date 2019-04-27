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
import com.business.ASSearch.ASSearchImp;
import com.business.ASUser.ASUserImp;
import com.business.businessObjects.Host;
import com.business.businessObjects.Likes;
import com.business.businessObjects.Place;
import com.business.businessObjects.Rating;
import com.business.businessObjects.Traveler;
import com.business.businessObjects.UserHA;
import com.business.enums.CountriesEnum;
import com.business.enums.DurationOfStayEnum;
import com.business.enums.FamilyUnit;
import com.business.enums.InterestsEnum;
import com.business.enums.KnowledgesEnum;
import com.business.transfers.TRating;

public class ASUserImpTestHU34 {
	ASUserImp sauser;
	
	@Test
	public void test() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		UserHA user1, user2;
		user1 = new UserHA("Adri", "Adrian", "adri@gmail.com", 1234, 5, "usuario viajero", false, true);
		user2 = new UserHA("Jose", "j", "j@a", 5678, 2, "usuario anfitrion", true, false);
		
		Likes like1 = new Likes(1, user1, user2);
		Collection<Likes> likes = new ArrayList<Likes>();
		likes.add(like1);
		user1.setLikes(likes);
		user2.setLikes(likes);
		
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
		
		ArrayList<Rating> rates = new ArrayList<Rating>();
		Rating rate = new Rating(1, user1, user2, 4);
		rates.add(rate);
		user2.setRates(rates);
		
		TRating trate = new TRating(user1.getNickname(), user2.getNickname(), 4);
		
		this.sauser.rateUser(trate);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		UserHA user2_update = em.find(UserHA.class, user2.getNickname());
		
		em.close();
		emf.close();
		
		//si da error eliminar el rate de la base de datos y te lo crea el SA directamente
		assertEquals(user2_update.getRating(), 6, 2);
	}

}
