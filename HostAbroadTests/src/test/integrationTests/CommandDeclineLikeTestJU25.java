package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TMatches;
import com.presentation.commands.CommandAcceptLike;
import com.presentation.commands.CommandDeclineLike;
import com.presentation.commands.Pair;

public class CommandDeclineLikeTestJU25 {
	private CommandDeclineLike command;
	
	@Test
	public void test() {
		this.command = new CommandDeclineLike();
		
		Pair<Integer, Object>  pair, command_pair;
		TMatches tmatch = new TMatches("Adri", "Jose");
		
		command_pair = this.command.execute(tmatch);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, tmatch);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}

}
