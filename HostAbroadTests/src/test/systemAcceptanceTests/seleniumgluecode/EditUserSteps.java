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
import systemAcceptanceTests.pageObject.CreateUser;
import systemAcceptanceTests.pageObject.EditPersonalInfo;
import systemAcceptanceTests.pageObject.FindUser;

public class EditUserSteps {
	
	private EditPersonalInfo userPO = new EditPersonalInfo();
	
	
	@Given("^el usuario navega hasta la pagina editar$")
	public void el_usuario_navega_hasta_la_pagina_editar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		userPO.goToPage("http://localhost:8080/HostAbroad/my_profile");
	}

	@When("^rellena los campos nombre completo, usuario, email, género, lenguaje y descripción correctamente$")
	public void rellena_los_campos_nombre_completo_usuario_email_género_lenguaje_y_descripción_correctamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    userPO.fillFormProperly();
	}

	@When("^pulsa guardar$")
	public void pulsa_guardar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		userPO.clickSave();
	}

	@Then("^se guardarán los cambios$")
	public void se_guardarán_los_cambios() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(userPO.checkUserEdited());
	}

	@When("^rellena los campos nombre completo, usuario, email, género, lenguaje y descripción incorrectamente$")
	public void rellena_los_campos_nombre_completo_usuario_email_género_lenguaje_y_descripción_incorrectamente() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		userPO.fillFormIncorrectly();
	}
	
	@Then("^se mostrará mensaje de error$")
	public void se_mostrará_mensaje_de_error() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(userPO.checkIncorrectFields());
	}
	
	
}
