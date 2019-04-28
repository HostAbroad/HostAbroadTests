package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TLikes;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTestHU23 {
	private ControllerImp controlador;

	@Test
	public void test() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		TLikes tlike = new TLikes("Adri", "Jose");
		
		command_pair = this.controlador.action(Commands.CommandSendLike, tlike);
		pair = new Pair(1, true);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
	}

}
