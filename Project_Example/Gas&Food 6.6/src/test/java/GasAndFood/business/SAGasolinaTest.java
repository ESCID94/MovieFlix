package GasAndFood.business;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Gasolina.SAGasolinaImp;
import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;


public class SAGasolinaTest {
	
	private TGasolina tE = new TGasolina("0", "nombre", true, TipoGasolina.GASOLINA);
	
	
	@Test
	public void testActualizarGasolinaSinDarDeAlta() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		int ret = sae.actualizarGasolina("-1", TipoGasolina.BIOGASOLINA, "nombre", false );
		assertEquals(ret, 0);
	}
	
	@Test
	public void testActualizarGasolinaDadoDeAlta() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		sae.darDeAlta(tE);
		int ret = sae.actualizarGasolina(sae.leerNombre("nombre").getId(), TipoGasolina.BIOGASOLINA, tE.getNombre(), false );
		assertEquals(ret, 1);
	}
	

	/**
	 * Caso en el que la gasolina existe y esta activo
	 * */
	@Test
	public void testDarDeBaja1() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		tE = new TGasolina("1", "nombre1", true, TipoGasolina.BIOGASOLINA);
		sae.darDeAlta(tE);
		sae.actualizarGasolina(sae.leerNombre("nombre1").getId(), TipoGasolina.DIESEL, tE.getNombre(), tE.getActivo());
		int ret = sae.darDeBaja(sae.leerNombre("nombre1").getId());
		assertEquals(ret, 1);
	}
	
	
	/**
	 * Caso en el que la gasolina no existe
	 * */
	@Test
	public void testDarDeBaja0() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		int ret = sae.darDeBaja("-1");
		assertEquals(ret, 0);
	}

	/**
	 * Caso en el que el alimento existe y no esta activo
	 * */
	@Test
	public void testDarDeBaja2() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		tE = new TGasolina("2", "nombre2", true, TipoGasolina.DIESEL);
		sae.darDeAlta(tE);
		sae.actualizarGasolina(sae.leerNombre("nombre2").getId(), TipoGasolina.GASOLINA, tE.getNombre(),false);
		int ret = sae.darDeBaja(sae.leerNombre("nombre2").getId());
		assertEquals(ret, 2);
	}
	
	@Test
	public void insertaLee() throws IOException {
		SAGasolina sae = new SAGasolinaImp();
		tE = new TGasolina("3", "nombre3", true, TipoGasolina.GASOLINA);
		sae.darDeAlta(tE);
		TGasolina tEstabAux = sae.leerNombre("nombre3");
		
		assertTrue(tEstabAux.getNombre().equals(tE.getNombre())
				&& tEstabAux.getId().equals(sae.leerNombre("nombre3").getId())
				&& tEstabAux.getTipo().equals(tE.getTipo())
				&& tEstabAux.getActivo() == true);
	}
	
}
