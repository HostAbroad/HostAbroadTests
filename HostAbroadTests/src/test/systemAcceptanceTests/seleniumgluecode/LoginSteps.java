package systemAcceptanceTests.seleniumgluecode;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.businessObjects.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import systemAcceptanceTests.pageObject.Login;

public class LoginSteps {
	
	private Login logInPO = new Login();
	
	@Before("@LogInFirst")
	public void clearDataBaseAndCreateANewHostBeforeSecond() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String query = "delete from hostabroad.USERHA";
		em.createNativeQuery(query).executeUpdate();
		em.persist(new UserHA("test", "Test", "test@test.com", 1));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	@After("@LogInFirst")
	public void clearDataBaseAfterFirst(){
		this.clearDataBase();
	}
	
	@Given("^el usuario navega hasta la pagina de login$")
	public void el_usuario_navega_hasta_la_pagina_de_login() throws Throwable {
	    logInPO.goToLogInPage();
	}

	@When("^el usuario rellena los campos de email con \"([^\"]*)\" y contraseña con \"([^\"]*)\"$")
	public void el_usuario_rellena_los_campos_de_email_con_y_contraseña_con(String arg1, String arg2) throws Throwable {
	    logInPO.fillEmail(arg1);
	    logInPO.fillPassword(arg2);
	}

	@When("^pulsa el botón de logear$")
	public void pulsa_el_botón_de_logear() throws Throwable {
	    logInPO.clickLogIn();
	}
	
	@When("^el usuario rellena los campos de email con ([^\"]*) y contraseña con ([^\"]*)$")
	public void el_usuario_rellena_los_campos_de_email_y_contrasena_con_password(String email, String password) {
		logInPO.fillEmail(email);
	    logInPO.fillPassword(password);
	}

	@Then("^el usuario accederá a su página de zona de usuario$")
	public void el_usuario_accederá_a_su_página_de_zona_de_usuario() throws Throwable {
		 assertTrue(this.logInPO.userIsOnOtherPage());
	}
	
	@Then("^el usuario recibe un mensaje de error$")
	public void el_usuario_recibe_un_mensaje_de_error() throws Throwable {
	    assertTrue(this.logInPO.isErrorMessageVisible());
	}
	
	private void clearDataBase() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String query = "delete from hostabroad.USERHA";
		em.createNativeQuery(query).executeUpdate();
		//don't know if it is needed
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
