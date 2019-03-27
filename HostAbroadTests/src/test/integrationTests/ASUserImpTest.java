package integrationTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.business.TUser;
import com.business.User;
import com.business.ASFactory.ASFactory;
import com.business.ASUser.*;

public class ASUserImpTest {
	private ASUserImp asUser;
	
	@SuppressWarnings("deprecation")
	@Test
	public void searchHostTest() { 
		
		TUser transfer = new TUser("Prueba", 5, "pruebas para crear user", true, false);

		this.asUser = (ASUserImp) ASFactory.getInstance().createASUser();
		boolean resultTransfer = this.asUser.createUser(transfer);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		String consultaCrear = "SELECT * FROM User user WHERE user.nickname = :nickname";
		Query query = em.createQuery(consultaCrear);
		query.setParameter("nickname", transfer.getNickname());

		User user = null;
		
		try {
			user =  (User) query.getSingleResult();
		}
		catch (NoResultException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		if(resultTransfer) { 
			//Para comprobar usuario creado comprobamos que los datos de la bbdd son los mismos que los del transfer
			
			assertEquals(transfer.getNickname(), user.getNickname());
			assertEquals(transfer.getDescription(), user.getDescription());
			assertEquals(transfer.getRating(), user.getRating(), 0);
			assertEquals(transfer.getHost(), user.getHost());
			assertEquals(transfer.getTraveler(), user.getTraveler());
			
			//borramos este  usuario de la bbdd si lo hemos creado para poder hacer las pruebas de nuevo
			/*String consultaBorrar = "DELETE FROM User WHERE user.nickname = :nickname";
			query = em.createQuery(consultaBorrar);
			query.setParameter("nickname", transfer.getNickname());*/
		}
		else { 
			//Para comprobar que el usuario no se ha creado comprobamos que los datos del que tiene ese nick
			//en la bbdd no son los que tenemos en el transfer
			
			assertNotEquals(transfer.getNickname(), user.getNickname());
			assertNotEquals(transfer.getDescription(), user.getDescription());
			assertNotEquals(transfer.getRating(), user.getRating(), 0);
			assertNotEquals(transfer.getHost(), user.getHost());
			assertNotEquals(transfer.getTraveler(), user.getTraveler());
			
		}
		
		
		em.close();
		emf.close();
		
	}
}
