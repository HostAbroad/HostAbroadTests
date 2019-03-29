package integrationTests;

import static org.junit.Assert.assertEquals;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import com.business.TUser;
import com.business.User;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.*;

public class ASUserImpTest {
	private ASUserImp asUser;
	
	@Test
	public void createUserTest() { 
		
		//Introducir usuario nuevo
		TUser transfer = new TUser("Prueba13", 5, "pruebas para crear user", true, false);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		
		this.asUser = (ASUserImp) ASFactory.getInstance().createASUser();
		boolean resultTransfer = this.asUser.createUser(transfer);
		
		User user = em.find(User.class,transfer.getNickname());
		
		if(resultTransfer) { 
			//Para comprobar usuario creado comprobamos que los datos de la bbdd son los mismos que los del transfer
			
			assertEquals(transfer.getNickname(), user.getNickname());
			assertEquals(transfer.getDescription(), user.getDescription());
			assertEquals(transfer.getRating(), user.getRating(), 0);
			assertEquals(transfer.getHost(), user.getHost());
			assertEquals(transfer.getTraveler(), user.getTraveler());
			
		}
		else { 
			//Para comprobar que el usuario no se ha creado comprobamos que el nickname que llega de la bbdd
			//es el mismo que intentamos introducir
			
			assertEquals(transfer.getNickname(), user.getNickname());
		}
		
		
		em.close();
		emf.close();
		
	}
}
