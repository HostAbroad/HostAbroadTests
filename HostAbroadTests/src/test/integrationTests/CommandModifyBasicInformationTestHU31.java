package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TUser;
import com.presentation.commands.CommandModifyBasicInformation;
import com.presentation.commands.Pair;

public class CommandModifyBasicInformationTestHU31 {
	CommandModifyBasicInformation command;

	@Test
	public void test() {
		this.command = new CommandModifyBasicInformation();
		
		Pair<Integer, Object>  pair, command_pair;
		TUser tuser = new TUser("Adri", "Adrian", "adri1", "adri@gmail.com", "usuario viajero", "foto1", "m", null, 5, false, true, null, null, null, null);
				
		command_pair = this.command.execute(tuser);
		pair = new Pair(1, true);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
	}

}
