package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TUser;
import com.presentation.commands.Pair;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTestHU31 {
	private ControllerImp controlador;

	@Test
	public void test() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		TUser user = new TUser("Adri", "Adrian45678", "adri1", "adri@gmail.com", "usuario viajero pero no mucho", "foto5", "perro", null, 5, false, true, null, null, null, null);
		
		command_pair = this.controlador.action(Commands.CommandModifyBasicInformation, user);
		pair = new Pair(1, true);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
	}

}
