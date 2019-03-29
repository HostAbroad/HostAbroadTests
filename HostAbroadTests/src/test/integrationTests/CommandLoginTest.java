package integrationTests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.presentation.commands.CommandLogin;
import com.presentation.commands.Pair;

public class CommandLoginTest {
	private CommandLogin command;

	@Test
	public void executeTest() {
		this.command = new CommandLogin();
		
		Pair<Integer, Object> pair, command_pair;
		TUser original = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", false, true);
		TUser returned;
		
		pair = new Pair(1, original);
		command_pair = this.command.execute(original);
		
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
