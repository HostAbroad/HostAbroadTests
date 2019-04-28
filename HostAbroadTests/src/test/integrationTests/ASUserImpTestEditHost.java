package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.businessObjects.*;
import com.business.enums.InterestsEnum;
import com.business.transfers.THost;
import com.business.ASFactory.ASFactory;
import com.business.ASSearch.ASSearchImp;
import com.business.ASUser.ASUserImp;

public class ASUserImpTestEditHost {
private ASUserImp sauser;
private ASSearchImp sasearch;

	@Test
	public void editHostInformationTest() {
		this.sauser = (ASUserImp) ASFactory.getInstance().createASUser();
		this.sasearch = (ASSearchImp) ASFactory.getInstance().createASSearch();
		
		ArrayList<InterestsEnum> intereses = new ArrayList<InterestsEnum>();
		intereses.add(InterestsEnum.Animals);
		THost myHost = new THost("Adri", intereses);
		Host new_host = new Host(intereses);
		
		this.sauser.editHostInformation(myHost);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		UserHA user = em.find(UserHA.class, myHost.getNickname());
		
		em.close();
		emfactory.close();
		
		Host host = user.getHostEntity();
		
		assertEquals(host.getListOfInterests(), new_host.getListOfInterests());
	}

}
