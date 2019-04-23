package GasAndFood.business;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.SAEstablecimientoImp;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.integracion.Establecimiento.DAOEstablecimientoImp;

public class SAEstablecimientoTest {
	
	
	private TEstablecimiento tE = new TEstablecimiento("6", "hiberx", "jepeto", "23756", true, TipoEstablecimiento.ALIMENTACION);
	
	@Test
	public void testActualizarEstablecimientoSinDarDeAlta() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		int ret = sae.actualizarEstablecimiento("-1", TipoEstablecimiento.GASOLINERA, false);
		assertEquals(ret, 0);
	}

	
	@Test
	public void testActualizarEstablecimientoDadoDeAlta() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		sae.darDeAlta(tE);
		int ret = sae.actualizarEstablecimiento(sae.leerNombre("hiberx", "jepeto").getId(), TipoEstablecimiento.GASOLINERA, false );
		assertEquals(ret, 1);
	}
	
	/**
	 * Caso en el que el establecimiento existe y esta activo
	 * */
	@Test
	public void testDarDeBaja1() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		TEstablecimiento tE = new TEstablecimiento("7", "hiberrrrrr", "jepeta", "23456", false, TipoEstablecimiento.GASOLINERA);
		sae.darDeAlta(tE);
		sae.actualizarEstablecimiento(sae.leerNombre("hiberrrrrr", "jepeta").getId(), TipoEstablecimiento.GASOLINERA, true);
		int ret = sae.darDeBaja(sae.leerNombre("hiberrrrrr", "jepeta").getId());
		assertTrue(ret == 1);
	}

	/**
	 * Caso en el que el establecimiento no existe
	 * */
	@Test
	public void testDarDeBaja0() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		int ret = sae.darDeBaja("-1");
		assertTrue(ret == 0);
	}

	/**
	 * Caso en el que el establecimiento existe y no esta activo
	 * */
	@Test
	public void testDarDeBaja2() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		TEstablecimiento tE = new TEstablecimiento("8", "hibex", "jepio", "65432", false, TipoEstablecimiento.GASOLINERA);
		sae.darDeAlta(tE);
		sae.actualizarEstablecimiento(sae.leerNombre("hibex", "jepio").getId(), TipoEstablecimiento.GASOLINERA, false);
		int ret = sae.darDeBaja(sae.leerNombre("hibex", "jepio").getId());
		assertTrue(ret == 2);
	}

	/*private String id = "55";
	private String nombre = "nombre";
	private String direccion = "direccion";
	private int CP = 33333;
	private boolean activo = false;
	private String tipo = "G";

	private TEstablecimiento test = new TEstablecimiento(id, nombre, direccion,
			CP, activo, tipo);*/

	@Test
	public void compruebaSiguienteID() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		List<TEstablecimiento> lte = sae.leerTodo();
		TEstablecimiento te = lte.get(lte.size()-1);
		DAOEstablecimientoImp daoe = new DAOEstablecimientoImp();
		assertEquals(Integer.parseInt(te.getId()) + 1,
				Integer.parseInt(daoe.siguienteIdAux()));
	}

	@Test
	public void insertaLee() throws IOException {
		SAEstablecimiento sae = new SAEstablecimientoImp();
		
		tE = new TEstablecimiento("1", "establecimiento", "coso", "98745", true, TipoEstablecimiento.ALIMENTACION);
			sae.darDeAlta(tE);
		TEstablecimiento tEstabAux = sae.leerNombre("establecimiento", "coso");
		
		assertTrue((
				tEstabAux.getNombre().equals(tE.getNombre())
				&& tEstabAux.getDireccion().equals(tE.getDireccion())
				&& tEstabAux.getCP().equals(tE.getCP())
				&& tEstabAux.getActivo() == true
				&& tEstabAux.getTipo().equals(tE.getTipo())));
	}

}
