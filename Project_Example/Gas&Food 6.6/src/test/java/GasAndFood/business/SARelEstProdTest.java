package GasAndFood.business;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Alimento.SAAlimentoImp;
import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TRAlimento;
import GasAndFood.business.Alimento.TipoAlimento;
import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.SAEstablecimientoImp;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TREstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Gasolina.SAGasolinaImp;
import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TRGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;

public class SARelEstProdTest {
	SAEstablecimiento sae = new SAEstablecimientoImp();
	SAAlimento saa = new SAAlimentoImp();
	SAGasolina sag = new SAGasolinaImp();
	

	private TEstablecimiento tE1 = new TEstablecimiento("0", "a", 
			"a", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TEstablecimiento tE2 = new TEstablecimiento("1", "b", 
			"b", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TAlimento tA1 = new TAlimento("0", "j", true, TipoAlimento.VERDURAS);
	private TAlimento tA2 = new TAlimento("1", "k", true, TipoAlimento.DULCES);
	private TGasolina tG1 = new TGasolina("0", "j", true, TipoGasolina.DIESEL);
	private TGasolina tG2 = new TGasolina("1", "k", true, TipoGasolina.BIOGASOLINA);

	@Test
	public void ini() throws IOException{
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo2 = new File("RelEstGas.txt");
		archivo2.delete();
	}
	
	@Test
	public void insertaLeerAlim() throws NumberFormatException, IOException{
		sae.darDeAlta(tE1);
		saa.darDeAlta(tA1);
		
		sae.añadirRelacionAlimento(tE1.getId(), tA1.getId(), 200, 50);
		
		List<TREstablecimiento> listAlims = sae.leerPorAlimento(tA1.getId());
		TREstablecimiento relEstAlim = listAlims.get(0);
		
		assertTrue(relEstAlim.getEstablecimiento().getId().equalsIgnoreCase(tE1.getId())
				&& relEstAlim.getPrecio() == 200 && relEstAlim.getDescuento() == 50);
		
		sae.borrarRelacionesAlimentos(tE1.getId(), tA1.getId());
	}
	
	@Test
	public void insertaLeerGas() throws NumberFormatException, IOException{
		sae.darDeAlta(tE1);
		sag.darDeAlta(tG1);
		
		sae.añadirRelacionGasolina(tE1.getId(), tG1.getId(), 200, 50);
		
		List<TREstablecimiento> listGas = sae.leerPorGasolina(tG1.getId());
		TREstablecimiento relEstGas = listGas.get(0);
		
		assertTrue(relEstGas.getEstablecimiento().getId().equalsIgnoreCase(tE1.getId())
				&& relEstGas.getPrecio() == 200 && relEstGas.getDescuento() == 50);
		
		sae.borrarRelacionesGasolinas(tE1.getId(), tG1.getId());
	}
	
	@Test
	public void insertarBorrarRelacionAlim() throws IOException {
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Alimento.txt");
		archivo3.delete();
		
		sae.darDeAlta(tE2);
		saa.darDeAlta(tA2);
		sae.añadirRelacionAlimento(tE2.getId(), tA2.getId(), 200, 50);
		
		List<TRAlimento> l1 = saa.leerPorEstablecimiento(tE2.getId());
		
		assertEquals(1, l1.size());
		
		sae.borrarRelacionesAlimentos(tE2.getId(), tA2.getId());

		List<TRAlimento> l2 = saa.leerPorEstablecimiento(tE2.getId());
		
		
		assertEquals(0, l2.size());
	}
	
	@Test
	public void insertarBorrarRelacionGas() throws IOException {
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstGas.txt");
		archivo1.delete();
		
		File archivo3 = new File("Gasolina.txt");
		archivo3.delete();
		
		sae.darDeAlta(tE2);
		sag.darDeAlta(tG2);
		sae.añadirRelacionGasolina(tE2.getId(), tG2.getId(), 200, 50);
		
		List<TRGasolina> l1 = sag.leerPorEstablecimiento(tE2.getId());
		
		assertEquals(1, l1.size());
		
		sae.borrarRelacionesGasolinas(tE2.getId(), tG2.getId());

		List<TRGasolina> l2 = sag.leerPorEstablecimiento(tE2.getId());
		
		
		assertEquals(0, l2.size());
	}
	
	@Test
	public void insertarYDarDeBajaEstablecimiento() throws IOException {
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Alimento.txt");
		archivo3.delete();
		
		File archivo4 = new File("Gasolina.txt");
		archivo4.delete();
		
		sae.darDeAlta(tE1);
		saa.darDeAlta(tA1);
		saa.darDeAlta(tA2);
		sag.darDeAlta(tG1);
		sag.darDeAlta(tG2);

		sae.añadirRelacionAlimento(tE1.getId(), tA1.getId(), 200, 50);
		sae.añadirRelacionAlimento(tE1.getId(), tA2.getId(), 5, 50);
		sae.añadirRelacionGasolina(tE1.getId(), tG1.getId(), 200, 50);
		sae.añadirRelacionGasolina(tE1.getId(), tG2.getId(), 5, 50);

		
		List<TRAlimento> l1 = saa.leerPorEstablecimiento(tE1.getId());
		List<TRGasolina> l2 = sag.leerPorEstablecimiento(tE1.getId());
		
		assertEquals(4, l1.size() + l2.size() );
		
		sae.darDeBaja(tE1.getId());

		List<TRAlimento> l3 = saa.leerPorEstablecimiento(tE1.getId());
		List<TRGasolina> l4 = sag.leerPorEstablecimiento(tE1.getId());
		
		
		assertEquals(0, l4.size() + l3.size());
	}
	
	@Test
	public void insertarYDarDeBajaGasolina() throws IOException {
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstGas.txt");
		archivo1.delete();
		
		File archivo3 = new File("Gasolina.txt");
		archivo3.delete();
		
		sae.darDeAlta(tE1);
		sae.darDeAlta(tE2);
		sag.darDeAlta(tG1);

		sae.añadirRelacionGasolina(tE1.getId(), tG1.getId(), 200, 50);
		sae.añadirRelacionGasolina(tE2.getId(), tG1.getId(), 5, 50);

		
		List<TREstablecimiento> l1 = sae.leerPorGasolina(tG1.getId());
		
		assertEquals(2, l1.size());
		
		sag.darDeBaja(tG1.getId());

		List<TREstablecimiento> l2 = sae.leerPorGasolina(tG1.getId());
		
		
		assertEquals(0, l2.size());
	}
	
	@Test
	public void insertarYDarDeBajaAlimento() throws IOException {
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Alimento.txt");
		archivo3.delete();
		
		sae.darDeAlta(tE1);
		sae.darDeAlta(tE2);
		saa.darDeAlta(tA1);

		sae.añadirRelacionAlimento(tE1.getId(), tA1.getId(), 200, 50);
		sae.añadirRelacionAlimento(tE2.getId(), tA1.getId(), 5, 50);

		
		List<TREstablecimiento> l1 = sae.leerPorAlimento(tA1.getId());
		
		assertEquals(2, l1.size());
		
		saa.darDeBaja(tA1.getId());

		List<TREstablecimiento> l2 = sae.leerPorAlimento(tA1.getId());
		
		
		assertEquals(0, l2.size());
	}
	
}
