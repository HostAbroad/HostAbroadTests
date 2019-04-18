package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.businessObjects.Matches;
import com.business.transfers.TMatches;

public class TMatchesTestHU25 {
	TMatches myMatch;
	
	@Test
	public void test() {
		TMatches aux;
		this.myMatch = new TMatches("sender", "receiver");
		aux = new TMatches("receiver", "sender");
		
		aux.setUserOne("sender");
		assertEquals(aux.getUserOne(), this.myMatch.getUserOne());
		
		aux.setUserTwo("receiver");
		assertEquals(aux.getUserTwo(), this.myMatch.getUserTwo());
	}

}
