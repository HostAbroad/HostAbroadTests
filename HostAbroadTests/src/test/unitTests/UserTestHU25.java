package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.businessObjects.Likes;
import com.business.businessObjects.Matches;
import com.business.businessObjects.Traveler;
import com.business.businessObjects.User;
import com.business.enums.CountriesEnum;
import com.business.enums.DurationOfStayEnum;
import com.business.enums.KnowledgesEnum;

public class UserTestHU25 {
	private User myUser;
	
	@Test
	public void test() {
		User aux;
		this.myUser = new User("Adri", "Adrian", "adri@gmail.com", 1234, 5, "pruebas hu25", false, true);
		aux = new User("Jose", "j", "j@a", 5678, 2, "este se modifica", true, false, null, null, null, null);
		
		Collection<Matches> matches = new ArrayList<Matches>();
		Matches match1 = new Matches(1, this.myUser, aux);
		matches.add(match1);
		this.myUser.setMatches(matches);
		
		Likes like1 = new Likes(1, this.myUser, aux);
		Collection<Likes> likes = new ArrayList<Likes>();
		likes.add(like1);
		this.myUser.setLikes(likes);
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Austria);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.Chemistry);
		Traveler traveler1 = new Traveler(1, this.myUser, listOfCountries, listOfKnowledges, DurationOfStayEnum.OneToTwoWeeks);
		this.myUser.setTravelerEntity(traveler1);
		this.myUser.setHostEntity(null);
		
		/*
		//Para crear un nuevo usuario manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(aux);
		em.persist(like1);
		em.persist(match1);
		em.persist(traveler1);
		em.persist(this.myUser);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		aux.setNickname("Adri");
		assertEquals(aux.getNickname(), this.myUser.getNickname());
		
		aux.setFullName("Adrian");
		assertEquals(aux.getFullName(), this.myUser.getFullName());
		
		aux.setEmail("adri@gmail.com");
		assertEquals(aux.getEmail(), this.myUser.getEmail());
		
		aux.setPassword(1234);
		assertEquals(aux.getPassword(), this.myUser.getPassword());
		
		aux.setRating(5);
		assertEquals(aux.getRating(), this.myUser.getRating(), 2);
		
		aux.setDescription("pruebas hu25");
		assertEquals(aux.getDescription(), this.myUser.getDescription());
		
		aux.setHost(false);
		assertEquals(aux.getHost(), this.myUser.getHost());
		
		aux.setTraveler(true);
		assertEquals(aux.getTraveler(), this.myUser.getTraveler());
		
		aux.setTravelerEntity(traveler1);
		assertEquals(aux.getTravelerEntity(), this.myUser.getTravelerEntity());
		
		aux.setMatches(matches);
		assertEquals(aux.getMatches(), this.myUser.getMatches());
		
		aux.setLikes(likes);
		assertEquals(aux.getLikes(), this.myUser.getLikes());
	}

}
