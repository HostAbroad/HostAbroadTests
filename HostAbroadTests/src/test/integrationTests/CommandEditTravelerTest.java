package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.CountriesEnum;
import com.business.DurationOfStayEnum;
import com.business.KnowledgesEnum;
import com.business.TTraveler;
import com.presentation.commands.CommandEditTraveler;
import com.presentation.commands.Pair;

public class CommandEditTravelerTest {
	private CommandEditTraveler command;
	
	@Test
	public void test() {
		this.command = new CommandEditTraveler();
		Pair<Integer, Object>  pair, command_pair;
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Israel);
		listOfCountries.add(CountriesEnum.Denmark);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.ProfesionalDelLOl);
		
		TTraveler myTraveler = new TTraveler("Adri", listOfCountries, listOfKnowledges, DurationOfStayEnum.Op4);
		
		command_pair = this.command.execute(myTraveler);
		
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, true);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	
	}

}
