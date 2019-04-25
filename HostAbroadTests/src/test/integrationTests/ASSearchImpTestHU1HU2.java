package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsoup.select.Evaluator.Matches;
import org.junit.Test;

import com.business.ASFactory.ASFactory;
import com.business.ASSearch.ASSearchImp;
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
import com.business.enums.SearchEnum;
import com.business.transfers.TUser;

public class ASSearchImpTestHU1HU2 {
	private ASSearchImp assearch;

	@Test
	public void searchTest() {
		this.assearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
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
		
		/*
		//Para crear los usuarios manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(like1);
		em.persist(traveler1);
		em.persist(place);
		em.persist(host2);
		em.persist(user1);
		em.persist(user2);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		ArrayList<TUser> lista_usuarios = this.assearch.search();
		ArrayList<UserHA> lista = new ArrayList<UserHA>();
		lista.add(user1);
		lista.add(user2);
		
		for(int i = 0; i < lista_usuarios.size(); i++) {
			assertEquals(lista_usuarios.get(i).getNickname(), lista.get(i).getNickname());
			assertEquals(lista_usuarios.get(i).getFullName(), lista.get(i).getFullName());
			assertEquals(lista_usuarios.get(i).getPassword(), lista.get(i).getPassword().toString());
			assertEquals(lista_usuarios.get(i).getRating(), lista.get(i).getRating(), 2);
			assertEquals(lista_usuarios.get(i).getDescription(), lista.get(i).getDescription());
			assertEquals(lista_usuarios.get(i).getHost(), lista.get(i).getHost());
			assertEquals(lista_usuarios.get(i).getTraveler(), lista.get(i).getTraveler());
			assertEquals(lista_usuarios.get(i).getEmail(), lista.get(i).getEmail());
		}
		
	}
	
	@Test
	public void searchEnumTest() {
		this.assearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
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
		
		SearchEnum seuser1, seuser2;
		seuser1 = SearchEnum.isTraveler;
		seuser2 = SearchEnum.isHost;
		
		ArrayList<SearchEnum> lista_enumerados;
		ArrayList<TUser> lista_usuarios;
		ArrayList<UserHA> lista;
		
		//Busca los viajeros
		lista_enumerados = new ArrayList<SearchEnum>();
		lista_enumerados.add(seuser1);
		lista_usuarios = this.assearch.search(lista_enumerados);
		lista = new ArrayList<UserHA>();
		lista.add(user1);
		
		for(int i = 0; i < lista_usuarios.size(); i++) {
			assertEquals(lista_usuarios.get(i).getNickname(), lista.get(i).getNickname());
			assertEquals(lista_usuarios.get(i).getFullName(), lista.get(i).getFullName());
			assertEquals(lista_usuarios.get(i).getPassword(), lista.get(i).getPassword().toString());
			assertEquals(lista_usuarios.get(i).getRating(), lista.get(i).getRating(), 2);
			assertEquals(lista_usuarios.get(i).getDescription(), lista.get(i).getDescription());
			assertEquals(lista_usuarios.get(i).getHost(), lista.get(i).getHost());
			assertEquals(lista_usuarios.get(i).getTraveler(), lista.get(i).getTraveler());
			assertEquals(lista_usuarios.get(i).getEmail(), lista.get(i).getEmail());
		}
		
		//Busca los anfitriones
		lista_enumerados = new ArrayList<SearchEnum>();
		lista_enumerados.add(seuser2);
		lista_usuarios = this.assearch.search(lista_enumerados);
		lista = new ArrayList<UserHA>();
		lista.add(user2);
		
		for(int i = 0; i < lista_usuarios.size(); i++) {
			assertEquals(lista_usuarios.get(i).getNickname(), lista.get(i).getNickname());
			assertEquals(lista_usuarios.get(i).getFullName(), lista.get(i).getFullName());
			assertEquals(lista_usuarios.get(i).getPassword(), lista.get(i).getPassword().toString());
			assertEquals(lista_usuarios.get(i).getRating(), lista.get(i).getRating(), 2);
			assertEquals(lista_usuarios.get(i).getDescription(), lista.get(i).getDescription());
			assertEquals(lista_usuarios.get(i).getHost(), lista.get(i).getHost());
			assertEquals(lista_usuarios.get(i).getTraveler(), lista.get(i).getTraveler());
			assertEquals(lista_usuarios.get(i).getEmail(), lista.get(i).getEmail());
		}
		
	}

}
