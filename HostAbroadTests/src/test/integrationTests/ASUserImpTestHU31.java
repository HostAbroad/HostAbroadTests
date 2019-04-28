package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.ASFactory.ASFactory;
import com.business.ASUser.ASUserImp;
import com.business.businessObjects.Host;
import com.business.businessObjects.Place;
import com.business.businessObjects.Traveler;
import com.business.businessObjects.UserHA;
import com.business.enums.CountriesEnum;
import com.business.enums.DurationOfStayEnum;
import com.business.enums.FamilyUnit;
import com.business.enums.InterestsEnum;
import com.business.enums.KnowledgesEnum;
import com.business.transfers.TUser;


public class ASUserImpTestHU31 {
	private ASUserImp sauser;

	@Test
	public void test() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		
		TUser user = new TUser("Adri", "Adrian45678", "adri1", "adri@gmail.com", "usuario viajero pero no mucho", "foto5", "perro", 5, false, true, null, null, null, null);
		
		this.sauser.modifyInformation(user);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		UserHA mofificado = em.find(UserHA.class, user.getNickname());
		tr.commit();
		
		em.close();
		emf.close();
		
		assertEquals(mofificado.getNickname(), user.getNickname());
		assertEquals(mofificado.getFullName(), user.getFullName());
		assertEquals(mofificado.getEmail(), user.getEmail());
		assertEquals(mofificado.getDescription(), user.getDescription());
		assertEquals(mofificado.getPhoto(), user.getPhoto());
		assertEquals(mofificado.getGender(), user.getGender());
	}

}
