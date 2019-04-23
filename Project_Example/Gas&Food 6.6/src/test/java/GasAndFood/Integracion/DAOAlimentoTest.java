package GasAndFood.Integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Alimento.SAAlimentoImp;
import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TipoAlimento;
import GasAndFood.integracion.Alimento.DAOAlimentoImp;


public class DAOAlimentoTest {
	private DAOAlimentoImp dao = new DAOAlimentoImp();

	private TAlimento tE = new TAlimento("99", "nombre", true, TipoAlimento.VERDURAS);
	
	
	@Test
	public void ini() throws IOException{
		File archivo = new File("Alimento.txt");
		archivo.delete();
	}
	
	/**
	 * Caso en el que no hay alimentos
	 * */

	@Test
	public void compruebaSiguienteIDVacio() throws IOException {
		
		assertEquals(dao.siguienteIdAux(), "0");
	}
	

	/**
	 * Caso en el que hay alimentos
	 * */

	@Test
	public void compruebaSiguienteID() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		dao.insertar(tE);
		List<TAlimento> lte = sae.leerTodo();
		TAlimento te = lte.get(lte.size()-1);
		DAOAlimentoImp daoe = new DAOAlimentoImp();
		assertEquals(Integer.parseInt(te.getId()) + 1, Integer.parseInt(daoe.siguienteIdAux()));
	}
	
	@Test
	public void insertarLeerId() throws IOException{
		
		TAlimento te = new TAlimento("1", "nombre1", true, TipoAlimento.VERDURAS);
		dao.insertar(te);
		TAlimento tEstabAux = dao.leerPorId("1");
		assertTrue(tEstabAux.getNombre().equals(te.getNombre())
				&& tEstabAux.getId().equals(te.getId())
				&& tEstabAux.getTipo().equals(te.getTipo())
				&& tEstabAux.getActivo() == te.getActivo());
	}
	@Test
	public void insertarLeerNombre() throws IOException{
		
		TAlimento te = new TAlimento("2", "nombre2", true, TipoAlimento.VERDURAS);
		dao.insertar(te);
		TAlimento tEstabAux = dao.leerPorNombre("nombre2");
		assertTrue(tEstabAux.getNombre().equals(te.getNombre())
				&& tEstabAux.getId().equals(te.getId())
				&& tEstabAux.getTipo().equals(te.getTipo())
				&& tEstabAux.getActivo() == te.getActivo());
	}
	
	
	@Test
	public void modificar1() throws IOException{
		TAlimento te = new TAlimento("3", "nombre3", true, TipoAlimento.VERDURAS);
		dao.insertar(te);
		int ret = dao.modificar("3", false, TipoAlimento.A_FRESCOS);
		assertEquals(1, ret);
	}
	
	@Test
	public void modificar2() throws IOException{
		int ret = dao.modificar("-1", false, TipoAlimento.A_FRESCOS);
		assertEquals(0, ret);
	}
	
}
