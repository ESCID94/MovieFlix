package GasAndFood.business;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

import GasAndFood.business.Usuario.SAUsuario;
import GasAndFood.business.Usuario.SAUsuarioImp;
import GasAndFood.business.Usuario.TUsuario;
import GasAndFood.integracion.Usuario.DAOUsuarioImp;

public class SAUsuarioTest {

	private TUsuario tE = new TUsuario("6", "nombre", "contra",
			"nick", "ejemplo@r", true);


	@Test
	public void testActualizarUsuarioSinDarDeAlta() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		int ret = sae.actualizarUsuario("-1", "", "", false );
		assertEquals(ret, 0);
	}
	
	@Test
	public void testActualizarUsuarioDadoDeAlta() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		sae.darDeAlta(tE);
		int ret = sae.actualizarUsuario(sae.leerNombre("nombre").getId(),"nuevacontra",sae.leerNombre("nombre").getEmail(), false );
		assertEquals(ret, 1);
	}

	/**
	 * Caso en el que el Usuario existe y esta activo
	 * */
	@Test
	public void testDarDeBaja1() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		TUsuario tE = new TUsuario("2", "nombre2", "contra2", "nick2", "ejemplo@r2", true);
		sae.darDeAlta(tE);
		sae.actualizarUsuario(sae.leerNombre("nombre2").getId(),"nuevacontra2",sae.leerNombre("nombre2").getEmail(),  true);
		int ret = sae.darDeBaja(sae.leerNombre("nombre2").getId());
		assertEquals(ret, 1);
	}

	/**
	 * Caso en el que el Usuario no existe
	 * */
	@Test
	public void testDarDeBaja0() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		int ret = sae.darDeBaja("-1");
		assertEquals(ret, 0);
	}

	/**
	 * Caso en el que el Usuario existe y no esta activo
	 * */
	@Test
	public void testDarDeBaja2() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		tE = new TUsuario("3", "nombre3", "contra3","nick3", "ejemplo@r3", true);
		sae.darDeAlta(tE);
		sae.actualizarUsuario(sae.leerNombre("nombre3").getId(),"nuevacontra3",sae.leerNombre("nombre3").getEmail(),  false);
		int ret = sae.darDeBaja(sae.leerNombre("nombre3").getId());
		assertEquals(ret, 2);
	}

	@Test
	public void compruebaSiguienteID() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		List<TUsuario> lte = sae.leerTodo();
		TUsuario te = lte.get(lte.size()-1);
		DAOUsuarioImp daoe = new DAOUsuarioImp();
		assertEquals(Integer.parseInt(te.getId()) + 1, Integer.parseInt(daoe.siguienteIdAux()));
	}

	@Test
	public void insertaLee() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		tE = new TUsuario("4", "nombre4", "contra4", "nick4", "ejemplo@r4", true);
		
		sae.darDeAlta(tE);
		TUsuario tEstabAux = sae.leerNombre("nombre4");
		
		assertTrue(tEstabAux.getNombre().equals(tE.getNombre())
				&& tEstabAux.getContrasena().equals(tE.getContrasena())
				&& tEstabAux.getUsuario().equals(tE.getUsuario())
				&& tEstabAux.getEmail().equals(tE.getEmail())
				&& tEstabAux.getActivo() == true);
	}
}
