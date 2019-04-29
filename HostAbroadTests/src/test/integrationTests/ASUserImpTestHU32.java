package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;
import com.business.businessObjects.Interest;
import com.business.enums.InterestsEnum;
import com.business.transfers.TUser;

public class ASUserImpTestHU32 {
	private ASUserImp sauser;

	@Test
	public void test() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		TUser user = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5.0, "usuario viajero", false, true);
		user.setBrthday("21/9");
		user.setGender("m");
		user.setPhoto("foto1");
		
		TreeSet<InterestsEnum> intereses = new TreeSet<InterestsEnum>();
		intereses.add(InterestsEnum.Cars);
		user.setInterests(intereses);
		
		this.sauser.modifyInterests(user);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		Interest interes = em.find(Interest.class, user);
		tr.commit();
		
		em.close();
		emf.close();
		
		assertEquals(interes.getUser(), user);
		assertEquals(interes.getInterest(), "Cars");
	}

}
