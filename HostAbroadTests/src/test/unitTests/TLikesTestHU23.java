package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.business.transfers.TLikes;

public class TLikesTestHU23 {

	@Test
	public void test() {
		TLikes like1, like2;
		like1 = new TLikes("Adri", "Jose");
		like2 = new TLikes("Jose", "Adri");
		
		like2.setUserSender("Adri");
		assertEquals(like1.getUserSender(), like2.getUserSender());
		
		like2.setUserReceiver("Jose");
		assertEquals(like1.getUserReceiver(), like2.getUserReceiver());
	}

}
