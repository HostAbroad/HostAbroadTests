package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TRating;

public class TRatingTestHU34 {
	private TRating myRate;
	
	@Test
	public void test() {
		this.myRate = new TRating("Adri", "Jose", 4);
		TRating aux = new TRating("Jose", "Adri", 3);
		
		aux.setUserSender("Adri");
		assertEquals(aux.getUserSender(), this.myRate.getUserSender());
		
		aux.setUserReceiver("Jose");
		assertEquals(aux.getUserReceiver(), this.myRate.getUserReceiver());
		
		aux.setRate(4);
		assertEquals(aux.getRate(), this.myRate.getRate());
	}

}
