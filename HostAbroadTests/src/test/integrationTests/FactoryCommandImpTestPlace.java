package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.presentation.commands.Command;
import com.presentation.commands.CommandAddPlace;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;

public class FactoryCommandImpTestPlace {
	private FactoryCommandImp fcommand;
	
	@Test
	public void test() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		Command command = new CommandAddPlace();
		Command command_return = this.fcommand.parseCommand(Commands.CommandAddPlace);
		
		command.setEventReturn(0);
		
		assertEquals(command.getEventReturn(), command_return.getEventReturn());
	}

}
