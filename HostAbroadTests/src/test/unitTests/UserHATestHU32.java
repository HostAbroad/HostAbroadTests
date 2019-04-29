package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.businessObjects.Interest;
import com.business.businessObjects.Traveler;
import com.business.businessObjects.UserHA;
import com.business.enums.CountriesEnum;
import com.business.enums.DurationOfStayEnum;
import com.business.enums.InterestsEnum;
import com.business.enums.KnowledgesEnum;

public class UserHATestHU32 {

	@Test
	public void test() {
		UserHA user1, user2;
		user1 = new UserHA("Adri", "Adrian", 5.0, "usuario viajero", "adri@gmail.com", 1234, false, true);
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Austria);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.Chemistry);
		Traveler traveler1 = new Traveler(1, user1, listOfCountries, listOfKnowledges, DurationOfStayEnum.OneToTwoWeeks);
		user1.setTravelerEntity(traveler1);
		user1.setHostEntity(null);
		
		user1.setBirthday("21/6");
		user1.setGender("m");
		user1.setPhoto("foto1");
		
		Interest int1, int2;
		int1 = new Interest(user1, InterestsEnum.Cars.getString());
		int2 = new Interest(user1, InterestsEnum.Animals.getString());
		ArrayList<Interest> intereses = new ArrayList<Interest>();
		intereses.add(int1);
		intereses.add(int2);
		user1.setInterests(intereses);
		
		assertEquals(user1.getInterests(), intereses);
	}

}
