package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.Host;
import com.business.InterestsEnum;
import com.business.THost;
import com.business.User;

public class THostTest {
private THost myHost;

	@Test
	public void test() {
		ArrayList<InterestsEnum> intereses = new ArrayList<InterestsEnum>();
		intereses.add(InterestsEnum.Int1);
		this.myHost = new THost("Adri", intereses);
		
		THost aux_host = new THost("Pedro", null);
		
		aux_host.setNickname("Adri");
		assertEquals(this.myHost.getNickname(), aux_host.getNickname());
		
		aux_host.setListOfInterests(intereses);
		assertEquals(this.myHost.getListOfInterests(), aux_host.getListOfInterests());
	}

}
