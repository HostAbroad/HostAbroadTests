package integrationTests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.CommandLogin;
import com.presentation.commands.Pair;
import com.presentation.controller.FactoryCommand;

public class CommandLoginTest {
	private CommandLogin command;

	@Test
	public void executeTest() {
		
		Pair<Integer, Object> pair, command_pair;
		TUser original = new TUser("Prueba", "PruebaFull", "ivan@ucm.es", "1234", 5, "pruebas para login", true, false);
		TUser returned;
		
		pair = new Pair(1, original);
		command_pair = FactoryCommand.getInstance().parseCommand(Commands.CommandLogin).execute(original);
		
		assertEquals(pair.getLeft(), command_pair.getLeft());
		returned = (TUser) command_pair.getRight();
		
		assertEquals(original.getNickname(), returned.getNickname());
		assertEquals(original.getFullName(), returned.getFullName());
		assertEquals(original.getEmail(), returned.getEmail());
		assertEquals(original.getPassword(), returned.getPassword());
		assertEquals(original.getRating(), returned.getRating(), 2);
		assertEquals(original.getDescription(), returned.getDescription());
		assertEquals(original.getHost(), returned.getHost());
		assertEquals(original.getTraveler(), returned.getTraveler());
		
	}

}
