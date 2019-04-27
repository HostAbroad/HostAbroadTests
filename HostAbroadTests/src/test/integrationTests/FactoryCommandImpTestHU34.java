package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.presentation.commands.Command;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.CommandRateUser;
import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;

public class FactoryCommandImpTestHU34 {
	private FactoryCommandImp fcommand;

	@Test
	public void test() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		
		Command command = new CommandRateUser();
		Command command_return = this.fcommand.parseCommand(Commands.CommandRateUser);
		
		command.setEventReturn(0);
		
		assertEquals(command.getEventReturn(), command_return.getEventReturn());
	}

}
