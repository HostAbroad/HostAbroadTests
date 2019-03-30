package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.InterestsEnum;
import com.business.THost;
import com.presentation.commands.CommandEditHost;
import com.presentation.commands.Pair;

public class CommandEditHostTest {
private CommandEditHost command;

	@Test
	public void executeTest() {
		this.command = new CommandEditHost();
		Pair<Integer, Object>  pair, command_pair;
		
		ArrayList<InterestsEnum> intereses = new ArrayList<InterestsEnum>();
		intereses.add(InterestsEnum.Int3);
		intereses.add(InterestsEnum.Int1);
		THost new_host = new THost("Adri", intereses);
		
		command_pair = this.command.execute(new_host);
		//este par significa que la modificacion se ha realizado correctamente
		pair = new Pair(1, true);
		
		assertEquals(command_pair.getLeft(), pair.getLeft());
		assertEquals(command_pair.getRight(), pair.getRight());
	}

}
