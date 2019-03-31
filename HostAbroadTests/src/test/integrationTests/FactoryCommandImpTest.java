package integrationTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.presentation.commands.*;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.controller.FactoryCommand;
import com.presentation.controller.FactoryCommandImp;

public class FactoryCommandImpTest {
	private FactoryCommandImp fcommand;
	
	@Test
	public void test() {
		this.fcommand = (FactoryCommandImp) FactoryCommand.getInstance();
		
		Command cst = new CommandSearchTraveler();
		Command cst_return = this.fcommand.parseCommand(Commands.CommandSearchTraveler);
		
		cst.setEventReturn(0);
		
		assertEquals(cst.getEventReturn(), cst_return.getEventReturn());
	}

}
