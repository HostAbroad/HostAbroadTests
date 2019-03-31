package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.TUser;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;

public class ASUserImpTest {
	private ASUserImp sauser;

	@Test
	public void loginUserTest() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		TUser original = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", false, true);
		TUser returned;
		
		returned = this.sauser.loginUser(original);
		
		assertEquals(original.getNickname(), returned.getNickname());
		assertEquals(original.getFullName(), returned.getFullName());
		assertEquals(original.getEmail(), returned.getEmail());
		assertEquals(original.getPassword(), returned.getPassword());
		assertEquals(original.getRating(), returned.getRating(), 2);
		assertEquals(original.getDescription(), returned.getDescription());
		assertEquals(original.getHost(), returned.getHost());
		assertEquals(original.getTraveler(), returned.getTraveler());
	}

}
