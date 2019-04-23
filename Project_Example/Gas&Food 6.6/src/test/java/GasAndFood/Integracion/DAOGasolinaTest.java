package GasAndFood.Integracion;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Gasolina.SAGasolinaImp;
import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;
import GasAndFood.integracion.Gasolina.DAOGasolinaImp;

public class DAOGasolinaTest {
	private DAOGasolinaImp dao = new DAOGasolinaImp();

	private TGasolina tE = new TGasolina("0", "nombre", true, TipoGasolina.GASOLINA);
	
	/**
	 * Caso en el que no hay gasolinas
	 * */
	@Test
	public void ini() throws IOException{
		File archivo = new File("Gasolina.txt");
		archivo.delete();
	}
	
	@Test
	public void compruebaSiguienteIDVacio() throws IOException {
		
		assertEquals(dao.siguienteIdAux(), "0");
	}
	
	/**
	 * Caso en el que hay gasolinas
	 * */

	@Test
	public void compruebaSiguienteID() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		dao.insertar(tE);
		List<TGasolina> lte = sae.leerTodo();
		TGasolina te = lte.get(lte.size()-1);
		DAOGasolinaImp daoe = new DAOGasolinaImp();
		assertEquals(Integer.parseInt(te.getId()) + 1, Integer.parseInt(daoe.siguienteIdAux()));
	}

	
	@Test
	public void insertarLeerId() throws IOException{
		
		TGasolina te = new TGasolina("1", "nombre1", true, TipoGasolina.BIOGASOLINA);
		dao.insertar(te);
		TGasolina tEstabAux = dao.leerPorId("1");
		assertTrue(tEstabAux.getNombre().equals(te.getNombre())
				&& tEstabAux.getId().equals(te.getId())
				&& tEstabAux.getTipo().equals(te.getTipo())
				&& tEstabAux.getActivo() == te.getActivo());
	}
	
	@Test
	public void insertarLeerNombre() throws IOException{
		
		TGasolina te = new TGasolina("2", "nombre2", true, TipoGasolina.DIESEL);
		dao.insertar(te);
		TGasolina tEstabAux = dao.leerPorNombre("nombre2");
		assertTrue(tEstabAux.getNombre().equals(te.getNombre())
				&& tEstabAux.getId().equals(te.getId())
				&& tEstabAux.getTipo().equals(te.getTipo())
				&& tEstabAux.getActivo() == te.getActivo());
	}
	
	@Test
	public void modificar1() throws IOException{
		TGasolina te = new TGasolina("3", "nombre3", true, TipoGasolina.GASOLINA);
		dao.insertar(te);
		int ret = dao.modificar("3", false, "nombre3", TipoGasolina.DIESEL);
		assertEquals(1, ret);
	}
	
	@Test
	public void modificar2() throws IOException{
		int ret = dao.modificar("-1", false, "lolalia", TipoGasolina.BIOGASOLINA);
		assertEquals(0, ret);
	}
}
