package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.business.FamilyUnit;
import com.business.TPlace;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTest {
	private ControllerImp controlador;

	@Test
	public void test() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		ArrayList<Date> noAvaliableDates = new ArrayList<Date>();
		noAvaliableDates.add(new Date());
		TPlace myPlace = new TPlace("calle pirata", "pirata", noAvaliableDates, "foto", FamilyUnit.Fam2, "Adri");
		
		command_pair = this.controlador.action(Commands.CommandAddPlace, myPlace);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, true);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}

}
