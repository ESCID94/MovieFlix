package GasAndFood.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Alimento.SAAlimentoImp;
import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TipoAlimento;

public class SAAlimentoTest {
	private TAlimento tE = new TAlimento("6", "nombre", true, TipoAlimento.BOLLERIA);
	
	@Test
	public void testActualizarAlimentoSinDarDeAlta() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		int ret = sae.actualizarAlimento("-1", TipoAlimento.DULCES,false );
		assertEquals(ret, 0);
	}
	
	
	@Test
	public void testActualizarAlimentoDadoDeAlta() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		sae.darDeAlta(tE);
		int ret = sae.actualizarAlimento(sae.leerNombre("nombre").getId(), TipoAlimento.DULCES, false );
		assertEquals(ret, 1);
	}
	


	/**
	 * Caso en el que el alimento existe y esta activo
	 * */
	@Test
	public void testDarDeBaja1() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		tE = new TAlimento("7", "nombre1", false, TipoAlimento.BOLLERIA);
		sae.darDeAlta(tE);
		sae.actualizarAlimento(sae.leerNombre("nombre1").getId(), TipoAlimento.DULCES, true);
		int ret = sae.darDeBaja(sae.leerNombre("nombre1").getId());
		assertEquals(ret, 1);
	}

	/**
	 * Caso en el que el alimento no existe
	 * */
	@Test
	public void testDarDeBaja0() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		int ret = sae.darDeBaja("-1");
		assertEquals(ret, 0);
	}

	/**
	 * Caso en el que el alimento existe y no esta activo
	 * */
	@Test
	public void testDarDeBaja2() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		tE = new TAlimento("8", "nombre2", false,
				TipoAlimento.BOLLERIA);
		sae.darDeAlta(tE);
		sae.actualizarAlimento(sae.leerNombre("nombre2").getId(), TipoAlimento.DULCES, false);
		int ret = sae.darDeBaja(sae.leerNombre("nombre2").getId());
		assertEquals(ret, 2);
	}
	

	@Test
	public void insertaLee() throws IOException {
		SAAlimento sae = new SAAlimentoImp();
		tE = new TAlimento("7", "nombre3", false,
				TipoAlimento.BOLLERIA);
		sae.darDeAlta(tE);
		TAlimento tEstabAux = sae.leerNombre("nombre3");
		
		assertTrue(tEstabAux.getNombre().equals(tE.getNombre())
				&& tEstabAux.getId().equals(sae.leerNombre("nombre3").getId())
				&& tEstabAux.getTipo().equals(tE.getTipo())
				&& tEstabAux.getActivo() == true);
	}
}
