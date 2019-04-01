package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.business.FamilyUnit;
import com.business.Host;
import com.business.InterestsEnum;
import com.business.Place;
import com.business.TPlace;
import com.business.User;

public class TPlaceTest {
	private TPlace myPlace;

	@Test
	public void test() {
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		this.myPlace = new TPlace("calle piruleta", "dulce", noAvaliableDates, "foto", FamilyUnit.Fam1, "Adri");
		
		TPlace aux = new TPlace(null, null, null, null, null, null);
		
		aux.setAddress("calle piruleta");
		assertEquals(aux.getAddress(), this.myPlace.getAddress());
		
		aux.setDescription("dulce");
		assertEquals(aux.getDescription(), this.myPlace.getDescription());
		
		aux.setNoAvaliableDates(noAvaliableDates);
		assertEquals(aux.getNoAvaliableDates(), this.myPlace.getNoAvaliableDates());
		
		aux.setPhoto("foto");
		assertEquals(aux.getPhoto(), this.myPlace.getPhoto());
		
		aux.setFamilyUnit(FamilyUnit.Fam1);
		assertEquals(aux.getFamilyUnit(), this.myPlace.getFamilyUnit());
		
		aux.setNickname("Adri");
		assertEquals(aux.getNickname(), this.myPlace.getNickname());
		
	}

}
