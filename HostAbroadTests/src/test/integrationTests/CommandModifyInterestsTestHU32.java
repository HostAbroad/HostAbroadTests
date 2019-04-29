package integrationTests;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

import com.business.enums.InterestsEnum;
import com.business.transfers.TUser;
import com.presentation.commands.CommandModifyInterests;
import com.presentation.commands.Pair;

public class CommandModifyInterestsTestHU32 {
	private CommandModifyInterests command;

	@Test
	public void test() {
		this.command = new CommandModifyInterests();
		
		Pair<Integer, Object>  pair, command_pair;
		
		TUser user = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5.0, "usuario viajero", false, true);
		user.setBrthday("21/9");
		user.setGender("m");
		user.setPhoto("foto1");
		
		TreeSet<InterestsEnum> intereses = new TreeSet<InterestsEnum>();
		intereses.add(InterestsEnum.Cars);
		intereses.add(InterestsEnum.Animals);
		user.setInterests(intereses);		
		command_pair = this.command.execute(user);
		pair = new Pair(1, true);
		
		assertEquals(pair.getRight(), command_pair.getRight());
		assertEquals(pair.getLeft(), command_pair.getLeft());
	}

}
