package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.presentation.commands.Command;
import com.presentation.commands.CommandAcceptLike;
import com.presentation.commands.CommandEnum;
import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;

public class FactoryCommandImpTestHU25 {
	private FactoryCommandImp fcommand;
	
	@Test
	public void AcceptLikeTest() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		
		Command command = new CommandAcceptLike();
		Command command_return = this.fcommand.parseCommand(CommandEnum.Commands.CommandAcceptLike);
		
		command.setEventReturn(0);
		
		assertEquals(command.getEventReturn(), command_return.getEventReturn());
	}
	
	@Test
	public void DeclineLikeTest() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		
		Command command = new CommandAcceptLike();
		Command command_return = this.fcommand.parseCommand(CommandEnum.Commands.CommandDeclineLike);
		
		command.setEventReturn(0);
		
		assertEquals(command.getEventReturn(), command_return.getEventReturn());
	}

}
