package integrationTests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;
import com.business.TUser;
import com.business.User;
import com.presentation.commands.*;
import com.presentation.commands.CommandEnum.Commands;

public class ControllerImpTest {
	private ControllerImp controlador;

	@Test
	public void actionTest() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object> pair, command_pair;
		TUser original = new TUser("Adri", "Adrian", "adri@gmail.com", "adri1", 5, "pruebas para login", false, true);
		TUser returned;
		
		/*
		//Para crear un nuevo host manualmente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostAbroad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(yo);
		tr.commit();
		
		em.close();
		emf.close();
		*/
		
		pair = new Pair(1, original);
		//da igual lo que pases como transfer ya que esta funcion no lo utiliza
		command_pair = this.controlador.action(Commands.CommandLogin, original);
		returned = (TUser) command_pair.getRight();
		
		assertEquals(pair.getLeft(), command_pair.getLeft());
		
		assertEquals(original.getNickname(), returned.getNickname());
		assertEquals(original.getFullName(), returned.getFullName());
		assertEquals(original.getEmail(), returned.getEmail());
		assertEquals(original.getPassword(), returned.getPassword());
		assertEquals(original.getRating(), returned.getRating(), 2);
		assertEquals(original.getDescription(), returned.getDescription());
		assertEquals(original.getHost(), returned.getHost());
		assertEquals(original.getTraveler(), returned.getTraveler());
	}
	
}
