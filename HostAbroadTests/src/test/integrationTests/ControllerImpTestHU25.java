package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TMatches;
import com.presentation.commands.CommandEnum;
import com.presentation.commands.Pair;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTestHU25 {
	private ControllerImp controlador;

	@Test
	public void AcceptLiketest() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		TMatches tmatch = new TMatches("Adri", "Jose");
		
		command_pair = this.controlador.action(CommandEnum.Commands.CommandAcceptLike, tmatch);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, tmatch);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}
	
	@Test
	public void DeclineLiketest() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		TMatches tmatch = new TMatches("Adri", "Jose");
		
		command_pair = this.controlador.action(CommandEnum.Commands.CommandDeclineLike, tmatch);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, tmatch);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}

}
