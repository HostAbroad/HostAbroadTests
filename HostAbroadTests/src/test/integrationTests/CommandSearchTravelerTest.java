package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.presentation.commands.CommandSearchTraveler;
import com.presentation.commands.Pair;

public class CommandSearchTravelerTest {
	private CommandSearchTraveler cst;

	@Test
	public void test() {
		this.cst = new CommandSearchTraveler();
		
		Pair<Integer, Object> pair, command_pair;
		ArrayList<User> original_list = new ArrayList<User>();
		ArrayList<TUser> command_list;
		User yo = new User("Adri", 4, "pruebas para buscar un viajero", false, true);
		
		//Para crear un nuevo host en la base de datos manualmente
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tr = em.getTransaction();
//		tr.begin();
//		
//		em.persist(yo);
//		tr.commit();
//		
//		em.close();
//		emf.close();
		
		//añadir todos los hosts que haya en nuestra aplicacion
		original_list.add(yo);
		
		pair = new Pair(1, original_list);
		//da igual lo que pases como transfer ya que esta funcion no lo utiliza
		command_pair = this.cst.execute(0);
		command_list = (ArrayList<TUser>) command_pair.getRight();
		
		assertEquals(pair.getLeft(), command_pair.getLeft());
		for(int i = 0; i < original_list.size(); i++) {
			assertEquals(command_list.get(i).getNickname(), original_list.get(i).getNickname());
			assertEquals(command_list.get(i).getDescription(), original_list.get(i).getDescription());
			assertEquals(command_list.get(i).getRating(), original_list.get(i).getRating(), 2);
			assertEquals(command_list.get(i).getHost(), original_list.get(i).getHost());
			assertEquals(command_list.get(i).getTraveler(), original_list.get(i).getTraveler());
		}
	}

}
