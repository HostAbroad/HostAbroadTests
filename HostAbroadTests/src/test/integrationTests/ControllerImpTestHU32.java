package integrationTests;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import com.business.enums.InterestsEnum;
import com.business.transfers.TUser;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTestHU32 {
	private ControllerImp controlador;

	@Test
	public void test() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		
		TUser user = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5.0, "usuario viajero", false, true);
		user.setBrthday("21/9");
		user.setGender("m");
		user.setPhoto("foto1");
		
		TreeSet<InterestsEnum> intereses = new TreeSet<InterestsEnum>();
		intereses.add(InterestsEnum.Cars);
		intereses.add(InterestsEnum.Animals);
		user.setInterests(intereses);
		
		command_pair = this.controlador.action(Commands.CommandModifyInterests, user);
		pair = new Pair(1, null);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
	}

}
