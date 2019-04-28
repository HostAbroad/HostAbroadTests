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
import systemAcceptanceTests.pageObject.AddPlace;

public class AddPlaceSteps {
	
	private AddPlace userPO = new AddPlace();
	
	
	@Given("^el usuario navega hasta la pagina crear alojamiento$")
	public void el_usuario_navega_hasta_la_pagina_crear_alojamiento() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		userPO.goToPage("http://localhost:8080/HostAbroad/my_places");
	}

	@When("^rellena los campos descripción, dirección y familia correctamente$")
	public void rellena_los_campos_descripción_dirección_y_familia_correctamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    userPO.fillFormProperly();
	}

	@Then("^se registrará el nuevo alojamiento$")
	public void se_registrará_el_nuevo_alojamiento() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(userPO.checkPlaceAdded());
	}
	
	@When("^pulsa aceptar$")
	public void pulsa_aceptar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    userPO.clickSave();
	}

	@When("^rellena los campos descripción, dirección y familia incorrectamente$")
	public void rellena_los_campos_descripción_dirección_y_familia_incorrectamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    userPO.fillFormIncorrectly();
	}

	@Then("^se mostrará error$")
	public void se_mostrará_error() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(userPO.checkIncorrectFields());
	}
	
}
