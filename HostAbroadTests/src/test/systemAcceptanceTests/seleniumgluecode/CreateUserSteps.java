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
import systemAcceptanceTests.pageObject.FindUser;

public class CreateUserSteps {
	
	private CreateUser userPO = new CreateUser();
	
	
	@Before("@FirstCreateUser")
	public void clearDataBaseAfterFirst(){
		DataBaseHelper.clearDataBase();
	}
	
	@Before("@SecondCreateUser")
	public void clearDataBaseBeforSecond() {
		DataBaseHelper.clearDataBase();
	}
	
	@Before("@ThirdCreateUser")
	public void clearDataBaseBeforThird() {
		DataBaseHelper.clearDataBase();
	}
	
	
	@Given("^el usuario navega hasta la pagina principal$")
	public void el_usuario_navega_hasta_la_pagina_principal() throws Throwable {
		userPO.goToPage("http://localhost:8080/HostAbroad/register");
	}

	@When("^el usuario no registrado pulse en registrar$")
	public void el_usuario_no_registrado_pulse_en_registrar() throws Throwable {
		userPO.goToPage("http://localhost:8080/HostAbroad/register");
	}

	@When("^rellena los campos nombre, apodo, email y contraseña correctamente$")
	public void rellena_los_campos_nombre_apodo_email_y_contraseña_correctamente() throws Throwable {
	    userPO.fillFormProperly();
	}

	@When("^pulsa aceptar$")
	public void pulsa_aceptar() throws Throwable {
	    userPO.clickSave();
	}

	@Then("^se registrará el nuevo usuario$")
	public void se_registrará_el_nuevo_usuario() throws Throwable {
	    assertTrue(userPO.checkUserCreated());
	}

	@When("^pulsa rechazar$")
	public void CreateUser() throws Throwable {
	    userPO.clickReset();
	}

	@Then("^se anularán los cambios$")
	public void se_anularán_los_cambios() throws Throwable {
		assertTrue(userPO.checkEmptyFields());
	}

	@When("^rellena los campos nombre, apodo, email y contraseña erroneamente$")
	public void rellena_los_campos_nombre_apodo_email_y_contraseña_erroneamente() throws Throwable {
	    userPO.fillFormIncorrectly();
	}

	@Then("^se mostrará un mensaje de error indicando que debe rellenar todos los campos$")
	public void se_mostrará_un_mensaje_de_error_indicando_que_debe_rellenar_todos_los_campos(){
	    userPO.checkIncorrectFields();
	}
	
}
