package systemAcceptanceTests.seleniumgluecode;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.business.businessObjects.UserHA;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import systemAcceptanceTests.pageObject.FindUser;

public class FindUserHostSteps {
	
	private FindUser userPO = new FindUser();
	
	@Before("@SearchHostFirst")
	public void clearDataBaseAndCreateANewHostBeforeSecond() {
		DataBaseHelper.clearDataBase("HOST");
		//DataBaseHelper.clearDataBase("TRAVELER");
		DataBaseHelper.clearDataBase("USERHA");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(new UserHA("Test",2.0,"Test description",true, true));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	@After("@SearchHostFirst")
	public void clearDataBaseAfterFirst(){
		DataBaseHelper.clearDataBase("USER");
	}
	
	@Before("@SearchHostSecond")
	public void clearDataBaseBeforSecond() {
		DataBaseHelper.clearDataBase("USER");
	}
	
	@Given("^el usuario navega hasta la pagina de search$")
	public void el_usuario_navega_hasta_la_pagina_de_search() throws Throwable {
	    this.userPO.goToPage("http://localhost:8080/HostAbroad/search");
	}

	@When("^el usuario selecciona como tipo de usuario anfitrión$")
	public void el_usuario_selecciona_como_tipo_de_usuario_anfitrión() throws Throwable {
	    this.userPO.findSelectHostCheckBoxAndClickIt();
	}

	@When("^pulsa el botón de buscar$")
	public void pulsa_el_botón_de_buscar() throws Throwable {
	    this.userPO.clickApply();
	}

	@Then("^el usuario podrá ver un listado con los anfitriones$")
	public void el_usuario_podrá_ver_un_listado_con_los_anfitriones() throws Throwable {
		assertTrue(this.userPO.checkSearchHost());
	}
	
	@Then("^mostrará mensaje indicando que no hay ningún anfitrión registrado\\.$")
	public void mostrará_mensaje_indicando_que_no_hay_ningún_anfitrión_registrado() throws Throwable {
	    assertTrue(this.userPO.checkEmptyResults());
	}
}
