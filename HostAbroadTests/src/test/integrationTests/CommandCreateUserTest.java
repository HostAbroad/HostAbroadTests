package integrationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.presentation.commands.CommandCreateUser;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;
import com.presentation.controller.FactoryCommand;

public class CommandCreateUserTest {

	private CommandCreateUser command;
	
	@Test
	public void createUserTest() { 
		
		//Introducir usuario nuevo
		TUser transfer = new TUser("Prueba14", 5, "pruebas para crear user", true, false);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		
		this.command = (CommandCreateUser) FactoryCommand.getInstance().parseCommand(Commands.CommandCreateUser);
		Pair<Integer,Object> result = this.command.execute(transfer);
		
		User user = em.find(User.class,transfer.getNickname());
		
		if((boolean) result.getRight()) { 
			//Para comprobar usuario creado comprobamos que los datos de la bbdd son los mismos que los del transfer
			
			assertEquals(transfer.getNickname(), user.getNickname());
			assertEquals(transfer.getDescription(), user.getDescription());
			assertEquals(transfer.getRating(), user.getRating(), 0);
			assertEquals(transfer.getHost(), user.getHost());
			assertEquals(transfer.getTraveler(), user.getTraveler());
			assertSame(result.getLeft(), 1);
		}
		else { 
			//Para comprobar que el usuario no se ha creado comprobamos que el nickname que llega de la bbdd
			//es el mismo que intentamos introducir
			
			assertEquals(transfer.getNickname(), user.getNickname());
			assertSame(result.getLeft(), 0);
		}
		
		
		em.close();
		emf.close();
		
	}
}
