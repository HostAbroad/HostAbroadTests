package integrationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.business.enums.SearchEnum;
import com.business.transfers.TUser;
import com.presentation.commands.CommandEnum;
import com.presentation.commands.Pair;
import com.presentation.controller.Controller;
import com.presentation.controller.ControllerImp;

public class ControllerImpTestHU1HU2 {
	private ControllerImp controlador;
	
	@Test
	public void test() {
		this.controlador = (ControllerImp) Controller.getInstance();
		
		Pair<Integer, Object>  pair, command_pair;
		SearchEnum seuser1;
		seuser1 = SearchEnum.isTraveler;
		ArrayList<SearchEnum> lista_enumerados =  new ArrayList<SearchEnum>();
		lista_enumerados.add(seuser1);
		
		TUser user1;
		user1 = new TUser("Adri", "Adrian", "adri@gmail.com", "1234", 5, "usuario viajero", false, true);
		ArrayList<TUser> lista = new ArrayList<TUser>();
		lista.add(user1);
		
		command_pair = this.controlador.action(CommandEnum.Commands.CommandSearch, lista_enumerados);
		pair = new Pair(1, lista);
		
		ArrayList<TUser> lista_usuarios = (ArrayList<TUser>) command_pair.getRight();
		
		for(int i = 0; i < lista_usuarios.size(); i++) {
			assertEquals(lista_usuarios.get(i).getNickname(), lista.get(i).getNickname());
			assertEquals(lista_usuarios.get(i).getFullName(), lista.get(i).getFullName());
			assertEquals(lista_usuarios.get(i).getPassword(), lista.get(i).getPassword().toString());
			assertEquals(lista_usuarios.get(i).getRating(), lista.get(i).getRating(), 2);
			assertEquals(lista_usuarios.get(i).getDescription(), lista.get(i).getDescription());
			assertEquals(lista_usuarios.get(i).getHost(), lista.get(i).getHost());
			assertEquals(lista_usuarios.get(i).getTraveler(), lista.get(i).getTraveler());
			assertEquals(lista_usuarios.get(i).getEmail(), lista.get(i).getEmail());
		}
		assertEquals(command_pair.getLeft(), pair.getLeft());
		
	}

}
