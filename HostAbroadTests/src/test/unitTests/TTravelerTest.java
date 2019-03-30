package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.CountriesEnum;
import com.business.DurationOfStayEnum;
import com.business.KnowledgesEnum;
import com.business.TTraveler;
import com.business.Traveler;

public class TTravelerTest {
	private TTraveler mytraveler;
	
	@Test
	public void test() {
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Brazil);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.ProfesionalDelLOl);
		this.mytraveler = new TTraveler("Adri", listOfCountries, listOfKnowledges, DurationOfStayEnum.Op2);
		
		TTraveler aux_traveler = new TTraveler("Jose", null, null, null);
		
		aux_traveler.setNickname("Adri");
		assertEquals(aux_traveler.getNickname(), this.mytraveler.getNickname());
		
		aux_traveler.setListOfCountries(listOfCountries);
		assertEquals(aux_traveler.getListOfCountries(), this.mytraveler.getListOfCountries());
		
		aux_traveler.setListOfKnowledges(listOfKnowledges);
		assertEquals(aux_traveler.getListOfKnowledges(), this.mytraveler.getListOfKnowledges());
		
		aux_traveler.setDurationOfStay(DurationOfStayEnum.Op2);
		assertEquals(aux_traveler.getDurationOfStay(), this.mytraveler.getDurationOfStay());
		
	}

}
