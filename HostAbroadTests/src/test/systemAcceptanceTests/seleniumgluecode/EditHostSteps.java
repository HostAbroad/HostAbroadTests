package systemAcceptanceTests.seleniumgluecode;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import systemAcceptanceTests.pageObject.EditHost;


public class EditHostSteps {
	
	private EditHost userPO = new EditHost();
	
	@Given("^el usuario pulsa en editar en la sección de la información de su perfil como anfitrión$")
	public void el_usuario_pulsa_en_editar_en_la_sección_de_la_información_de_su_perfil_como_anfitrión() {
		userPO.goToPage("http://localhost:8080/HostAbroad/my_profile");
	    userPO.goToInterests();
	}

	@When("^el usuario modifica sus datos$")
	public void el_usuario_modifica_sus_datos() {
	    userPO.selectSomeChecks();
	}

	@When("^pulsa el botón aceptar$")
	public void pulsa_el_botón_aceptar() {
	    userPO.clickSave();
	}

	@Then("^se mostrará que ha realizado los cambios$")
	public void se_mostrará_que_ha_realizado_los_cambios() {
	    assertTrue(userPO.checkSuccess());
	}


}
