package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TUser;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;

public class ASUserImpTest {
	private ASUserImp sauser;

	@Test
	public void loginUserTest() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		//Necesario poner estos datos en tu bbdd antes de probar el test
		TUser original = new TUser("Prueba", "PruebaFull", "ivan@ucm.es", "1234", 5, "pruebas para login", true, false);
		TUser returned;
		
		returned = this.sauser.loginUser(original);
		
		if(returned != null) {
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

}
