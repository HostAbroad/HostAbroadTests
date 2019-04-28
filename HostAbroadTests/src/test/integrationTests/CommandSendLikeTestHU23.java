package integrationTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TLikes;
import com.presentation.commands.CommandSendLike;
import com.presentation.commands.Pair;

public class CommandSendLikeTestHU23 {
	private CommandSendLike command;

	@Test
	public void test() {
		this.command = new CommandSendLike();
		
		Pair<Integer, Object>  pair, command_pair;
		TLikes tlike = new TLikes("Adri", "Jose");
		
		command_pair = this.command.execute(tlike);
		pair = new Pair(1, true);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
	}

}
