package GasAndFood.Integracion;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.SAEstablecimientoImp;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.integracion.Establecimiento.DAOEstablecimientoImp;

public class DAOEstablecimientoImpTest {

	private DAOEstablecimientoImp dao = new DAOEstablecimientoImp();

	private TEstablecimiento tE = new TEstablecimiento("6", "repsol", "lope", "28280", true, TipoEstablecimiento.GASOLINERA);

	@Test
	public void ini() throws IOException{
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
	}
	@Test
	public void compruebaSiguienteIDVacio() throws IOException {
		
		assertEquals(dao.siguienteIdAux(), "0");
	}

	@Test
	public void compruebaSiguienteID() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		dao.insertar(tE);
		List<TEstablecimiento> lte = sae.leerTodo();
		TEstablecimiento te = lte.get(lte.size()-1);
		DAOEstablecimientoImp daoe = new DAOEstablecimientoImp();
		assertEquals(Integer.parseInt(te.getId()) + 1, Integer.parseInt(daoe.siguienteIdAux()));
	}

	@Test
	public void insertarLeerId() throws IOException {
		TEstablecimiento te = new TEstablecimiento("1", "nombre1", "lope2", "28281", true, TipoEstablecimiento.GASOLINERA);
		dao.insertar(te);
		TEstablecimiento tEstabAux = dao.leerPorId("1");
		assertTrue(tEstabAux.getNombre().equals(te.getNombre())
				&& tEstabAux.getId().equals(te.getId())
				&& tEstabAux.getTipo().equals(te.getTipo())
				&& tEstabAux.getActivo() == te.getActivo());

	}
	
	@Test
	public void insertarLeerNombre() throws IOException{
		
		TEstablecimiento te = new TEstablecimiento("2", "nombre2", "lope3", "28282", true, TipoEstablecimiento.GASOLINERA);
		dao.insertar(te);
		TEstablecimiento tEstabAux = dao.leerPorNombre("nombre2", "lope3");
		assertTrue(tEstabAux.getNombre().equals(te.getNombre())
				&& tEstabAux.getId().equals(te.getId())
				&& tEstabAux.getTipo().equals(te.getTipo())
				&& tEstabAux.getActivo() == te.getActivo());
	}
	
	
	@Test
	public void modificar1() throws IOException{
		TEstablecimiento te = new TEstablecimiento("3", "nombre3", "lope4", "28283", true, TipoEstablecimiento.GASOLINERA);
		dao.insertar(te);
		int ret = dao.modificar("3", false, TipoEstablecimiento.ALIMENTACION);
		assertEquals(1, ret);
	}
	
	@Test
	public void modificar2() throws IOException{
		int ret = dao.modificar("-1", false,TipoEstablecimiento.ALIMENTACION);
		assertEquals(0, ret);
	}
	
	
	
}
