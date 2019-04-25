package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.CountriesEnum;
import com.business.DurationOfStayEnum;
import com.business.KnowledgesEnum;
import com.business.TTraveler;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTestEditTraveler {
	private ControllerImp controlador;
	
	@Test
	public void test() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		
		ArrayList<CountriesEnum> listOfCountries = new ArrayList<CountriesEnum>();
		listOfCountries.add(CountriesEnum.Argentina);
		ArrayList<KnowledgesEnum> listOfKnowledges = new ArrayList<KnowledgesEnum>();
		listOfKnowledges.add(KnowledgesEnum.ScrumMaster);
		TTraveler myTraveler = new TTraveler("Adri", listOfCountries, listOfKnowledges, DurationOfStayEnum.Op3);
		
		command_pair = this.controlador.action(Commands.CommandEditTraveler, myTraveler);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, true);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}

}
