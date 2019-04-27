package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TRating;
import com.presentation.commands.CommandRateUser;
import com.presentation.commands.Pair;

public class CommandRateUserTestHU34 {
	private CommandRateUser command;
	
	@Test
	public void test() {
		this.command = new CommandRateUser();
		
		Pair<Integer, Object>  pair, command_pair;
		TRating trate = new TRating("Adri", "Jose", 4);
		
		command_pair = this.command.execute(trate);
		pair = new Pair(1, true);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
		
	}

}
