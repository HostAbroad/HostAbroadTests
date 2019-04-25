package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.Host;
import com.business.InterestsEnum;
import com.business.User;

public class HostTest {
	private Host myHost;

	@Test
	public void test() {
		ArrayList<InterestsEnum> intereses = new ArrayList<InterestsEnum>();
		intereses.add(InterestsEnum.Int2);
		User myUser = new User("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", true, false);
		this.myHost = new Host(1, myUser, intereses);
		
		User aux_user = new User("Jose", "j", "j@a", "j1", 2, "este se modifica", false, true);
		Host aux_host = new Host(2, aux_user, null);
		
		aux_host.setId(1);
		assertEquals(this.myHost.getId(), aux_host.getId());
		
		aux_host.setListOfInterests(intereses);
		assertEquals(this.myHost.getListOfInterests(), aux_host.getListOfInterests());
		
		aux_host.setUser(myUser);
		assertEquals(this.myHost.getUser(), aux_host.getUser());
		
		/*
		//Para crear un nuevo usuario manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(this.myHost);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
	}

}
