package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.TUser;

public class TUserTestPlace {
	private TUser myUser;

	@Test
	public void test() {
		TUser aux;
		this.myUser = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", true, false);
		
		aux = new TUser("Jose", "j", "j@a", "j1", 2, "este se modifica", true, false);
		
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
		
		aux.setHost(true);
		assertEquals(aux.getHost(), this.myUser.getHost());
		
		aux.setTraveler(false);
		assertEquals(aux.getTraveler(), this.myUser.getTraveler());
	}
}
