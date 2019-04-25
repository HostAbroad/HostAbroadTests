package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.transfers.TUser;

public class TUserTestHU25 {
	private TUser myUser;

	@Test
	public void test() {
		ArrayList<Integer> likes = new ArrayList<Integer>();
		likes.add(1);
		ArrayList<Integer> matches = new ArrayList<Integer>();
		likes.add(1);
		
		TUser aux;
		aux = new TUser("Jose", "j", "j@a", "j1", 2, "este se modifica", true, false, null, null);
		
		this.myUser = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", false, true, likes, matches);
		
		aux.setNickname("Adri");
		assertEquals(aux.getNickname(), this.myUser.getNickname());
		
		aux.setFullName("Adrian");
		assertEquals(aux.getFullName(), this.myUser.getFullName());
		
		aux.setEmail("adri@gmail.com");
		assertEquals(aux.getEmail(), this.myUser.getEmail());
		
		aux.setPassword("adri1");
		assertEquals(aux.getPassword(), this.myUser.getPassword());
		
		aux.setRating(5);
		assertEquals(aux.getRating(), this.myUser.getRating(), 2);
		
		aux.setDescription("pruebas para login");
		assertEquals(aux.getDescription(), this.myUser.getDescription());
		
		aux.setHost(false);
		assertEquals(aux.getHost(), this.myUser.getHost());
		
		aux.setTraveler(true);
		assertEquals(aux.getTraveler(), this.myUser.getTraveler());
		
		aux.setMatches(matches);
		assertEquals(aux.getMatches(), this.myUser.getMatches());
		
		aux.setLikes(likes);
		assertEquals(aux.getLikes(), this.myUser.getLikes());
	}
}
