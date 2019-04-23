package GasAndFood.Integracion;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Usuario.SAUsuario;
import GasAndFood.business.Usuario.SAUsuarioImp;
import GasAndFood.business.Usuario.TUsuario;
import GasAndFood.integracion.Usuario.DAOUsuarioImp;

public class DAOUsuarioImpTest {

	private DAOUsuarioImp DAOE = new DAOUsuarioImp();

	private TUsuario test = new TUsuario("6", "nombre2", "contra2",
			"nick2", "ejemplo@r2", true);

	@Test
	public void ini() throws IOException{
		File archivo = new File("Usuarios.txt");
		archivo.delete();
	}
	
	@Test
	public void compruebaSiguienteIDVacio() throws IOException {
		
		assertEquals(DAOE.siguienteIdAux(), "0");
	}
	
	@Test
	public void compruebaSiguienteID() throws IOException {
		SAUsuario sae = new SAUsuarioImp();
		DAOE.insertar(test);
		List<TUsuario> lte = sae.leerTodo();
		TUsuario te = lte.get(lte.size()-1);
		DAOUsuarioImp daoe = new DAOUsuarioImp();
		assertEquals(Integer.parseInt(te.getId()) + 1, Integer.parseInt(daoe.siguienteIdAux()));
	}

	@Test
	public void insertarLeerId() throws IOException {
		TUsuario test = new TUsuario("3", "nombre3", "contra3","nick3", "ejemplo@r3", true);
		DAOE.insertar(test);
		TUsuario tEstabAux = DAOE.leerPorId("3");
		assertTrue(tEstabAux.getNombre().equals(test.getNombre())
				&& tEstabAux.getContrasena().equals(test.getContrasena())
				&& tEstabAux.getUsuario().equals(test.getUsuario())
				&& tEstabAux.getEmail().equals(test.getEmail())
				&& tEstabAux.getActivo() == test.getActivo());
	}
	
	@Test
	public void insertarLeerNombre() throws IOException{
		
		TUsuario test = new TUsuario("4", "nombre4", "contra4","nick4", "ejemplo@r4", true);
		DAOE.insertar(test);
		TUsuario tEstabAux = DAOE.leerPorNombre("nombre4");
		assertTrue(tEstabAux.getNombre().equals(test.getNombre())
				&& tEstabAux.getContrasena().equals(test.getContrasena())
				&& tEstabAux.getUsuario().equals(test.getUsuario())
				&& tEstabAux.getEmail().equals(test.getEmail())
				&& tEstabAux.getActivo() == test.getActivo());
	}
	
	
	@Test
	public void modificar1() throws IOException{
		TUsuario test = new TUsuario("5", "nombre5", "contra5","nick5", "ejemplo@r5", true);
		DAOE.insertar(test);
		int ret = DAOE.modificar("5", "nuevacontra5", test.getEmail(), false);
		assertEquals(1, ret);
	}
	
	@Test
	public void modificar2() throws IOException{
		int ret = DAOE.modificar("-1", "nuevacontra", "hj", false);
		assertEquals(0, ret);
	}
	

}
