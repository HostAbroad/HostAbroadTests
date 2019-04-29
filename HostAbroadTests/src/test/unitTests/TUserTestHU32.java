package unitTests;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import com.business.enums.InterestsEnum;
import com.business.transfers.TUser;

public class TUserTestHU32 {

	@Test
	public void test() {
		TUser user = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5.0, "usuario viajero", false, true);
		user.setBrthday("21/9");
		user.setGender("m");
		user.setPhoto("foto1");
		
		TreeSet<InterestsEnum> intereses = new TreeSet<InterestsEnum>();
		intereses.add(InterestsEnum.Cars);
		intereses.add(InterestsEnum.Animals);
		user.setInterests(intereses);
		
		assertEquals(user.getInterests(), intereses);
	}

}
