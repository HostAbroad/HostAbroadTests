package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.business.businessObjects.*;
import com.business.enums.FamilyUnit;
import com.business.transfers.TPlace;
import com.presentation.commands.CommandAddPlace;
import com.presentation.commands.Pair;

public class CommandAddPlaceTest {
	private CommandAddPlace command;
	
	@Test
	public void test() {
		this.command = new CommandAddPlace();
		Pair<Integer, Object>  pair, command_pair;
		
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		TPlace myPlace = new TPlace("calle pirata", "pirata", noAvaliableDates, "foto", FamilyUnit.Alone, "Adri");
		
		command_pair = this.command.execute(myPlace);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, true);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}

}
