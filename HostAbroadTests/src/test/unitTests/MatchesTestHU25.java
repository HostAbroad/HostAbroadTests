package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.businessObjects.Matches;
import com.business.businessObjects.User;

public class MatchesTestHU25 {
	Matches myMatch;
	
	@Test
	public void test() {
		User sender, receiver;
		sender = new User("Adri", "Adrian", "adri@gmail.com", 1234, 5, "pruebas hu25", false, true);
		receiver = new User("Jose", "j", "j@a", 5678, 2, "este se modifica", true, false);

		Matches aux;
		this.myMatch = new Matches(1, sender, receiver);
		aux = new Matches(2, receiver, sender);
		
		aux.setUserOne(sender);
		assertEquals(aux.getUserOne(), this.myMatch.getUserOne());
		
		aux.setUserTwo(receiver);
		assertEquals(aux.getUserTwo(), this.myMatch.getUserTwo());
	}

}
