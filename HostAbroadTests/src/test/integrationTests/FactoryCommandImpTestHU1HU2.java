package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.presentation.commands.Command;
import com.presentation.commands.CommandEnum;
import com.presentation.commands.CommandSearch;
import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;

public class FactoryCommandImpTestHU1HU2 {
	private FactoryCommandImp fcommand;
	
	@Test
	public void test() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		
		Command command = new CommandSearch();
		Command command_return = this.fcommand.parseCommand(CommandEnum.Commands.CommandSearch);
		
		command.setEventReturn(0);
		
		assertEquals(command.getEventReturn(), command_return.getEventReturn());
	}
	
}

