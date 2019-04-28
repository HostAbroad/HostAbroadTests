package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.transfers.TUser;

public class TUserTestHU31 {
	private TUser myUser;

	@Test
	public void test() {
		this.myUser = new TUser("Adri", "Adrian", "adri1", "adri@gmail.com", "usuario viajero", "foto1", "m", 5, false, true, null, null, null, null);
		
		TUser aux = new TUser("Jose", "j", "j1", "j@a", "usuario anfitrion", "foto2", "f",  2, true, false, null, null, null, null);
		
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
		
		aux.setDescription("usuario viajero");
		assertEquals(aux.getDescription(), this.myUser.getDescription());
		
		aux.setHost(false);
		assertEquals(aux.getHost(), this.myUser.getHost());
		
		aux.setTraveler(true);
		assertEquals(aux.getTraveler(), this.myUser.getTraveler());
		
		aux.setPhoto("foto1");
		assertEquals(aux.getPhoto(), this.myUser.getPhoto());
		
		aux.setGender("m");
		assertEquals(aux.getGender(), this.myUser.getGender());
		
	}

}
