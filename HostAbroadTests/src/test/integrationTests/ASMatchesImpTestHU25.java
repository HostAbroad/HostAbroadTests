package integrationTests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.business.ASFactory.ASFactory;
import com.business.ASMatches.ASMatchesImp;
import com.business.businessObjects.Matches;
import com.business.transfers.TMatches;

public class ASMatchesImpTestHU25 {
	private ASMatchesImp asmatches;
	
	@Test
	public void acceptLikeTest() {
		this.asmatches = (ASMatchesImp) ASFactory.getInstance().createASMatches();
		
		TMatches tmatch = new TMatches("Adri", "Jose");
		boolean result = true;
		
		boolean asresult = this.asmatches.acceptLike(tmatch);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		//en el segundo parametro poner el id del match de la base de datos, ya que tmatch no tiene un atributo que sea el id
		Matches match = em.find(Matches.class, 2);
		
		em.close();
		emfactory.close();
		
		assertEquals(result, asresult);
		assertEquals(tmatch.getUserOne(), match.getUserOne().getNickname());
		assertEquals(tmatch.getUserTwo(), match.getUserTwo().getNickname());
	
	}
	
	@Test
	public void declineLikeTest() {
		this.asmatches = (ASMatchesImp) ASFactory.getInstance().createASMatches();
		
		TMatches tmatch = new TMatches("Adri", "Jose");
		boolean result = true;
		
		boolean asresult = this.asmatches.acceptLike(tmatch);
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emfactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		//en el segundo parametro poner el id del match de la base de datos, ya que tmatch no tiene un atributo que sea el id
		Matches match = em.find(Matches.class, 2);
		
		em.close();
		emfactory.close();
		
		assertEquals(result, asresult);
		assertEquals(tmatch.getUserOne(), match.getUserOne().getNickname());
		assertEquals(tmatch.getUserTwo(), match.getUserTwo().getNickname());
	}

}
