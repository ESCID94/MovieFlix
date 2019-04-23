package GasAndFood.Integracion;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TRAlimento;
import GasAndFood.business.Alimento.TipoAlimento;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TREstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TRGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;
import GasAndFood.integracion.Alimento.DAOAlimentoImp;
import GasAndFood.integracion.Establecimiento.DAOEstablecimientoImp;
import GasAndFood.integracion.Gasolina.DAOGasolinaImp;

public class RelacionesEstabProdTest {
	
	private DAOEstablecimientoImp daoe = new DAOEstablecimientoImp();
	private DAOAlimentoImp daoa = new DAOAlimentoImp();
	private DAOGasolinaImp daog = new DAOGasolinaImp();
	
	private TEstablecimiento tE1 = new TEstablecimiento("0", "a", 
			"a", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TEstablecimiento tE2 = new TEstablecimiento("1", "b", 
			"b", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TEstablecimiento tE3 = new TEstablecimiento("2", "c", 
					"c", "1", true, TipoEstablecimiento.ALIMENTACION);
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
	}

	@Test
	public void insertarLeerEstabAlim() throws IOException {
		
		daoe.insertar(tE1);
		daoa.insertar(tA1);
		daoe.añadirRelacion(tE1.getId(), tA1.getId(), 200, 50, "Alimento");
		
		List<TREstablecimiento> l = daoe.leerPorProducto(tA1.getId(), "Alimento");
		TREstablecimiento r = l.get(0);
		
		assertTrue(r.getEstablecimiento().getId().equalsIgnoreCase(tE1.getId())
				&& r.getPrecio() == 200 && r.getDescuento() == 50);
		
		daoe.borrarRelacionesProducto(tE1.getId(), tA1.getId(), "Alimento");
	}

	@Test
	public void insertarLeerEstabGas() throws IOException {
		
		daoe.insertar(tE1);
		daog.insertar(tG1);
		daoe.añadirRelacion(tE1.getId(), tG1.getId(), 200, 50, "Gasolina");
		
		List<TREstablecimiento> l = daoe.leerPorProducto(tG1.getId(), "gasolina");
		TREstablecimiento r = l.get(0);
		
		assertTrue(r.getEstablecimiento().getId().equalsIgnoreCase(tE1.getId())
				&& r.getPrecio() == 200 && r.getDescuento() == 50);
		
		daoe.borrarRelacionesProducto(tE1.getId(), tG1.getId(), "gasolina");
	}
	
	@Test
	public void insertarLeerAlim() throws IOException {
		
		
		daoe.insertar(tE2);
		daoa.insertar(tA2);
		daoe.añadirRelacion(tE2.getId(), tA2.getId(), 200, 50, "alimento");
		
		List<TRAlimento> l = daoa.leerPorEstablecimiento(tE2.getId());
		TRAlimento r = l.get(0);
		
		assertTrue(r.getAlimento().getId().equalsIgnoreCase(tA2.getId())
				&& r.getPrecio() == 200 && r.getDescuento() == 50);
		
		//daoe.borrarRelaciones(tE2.getId(), tA2.getId());
	}
	
	@Test
	public void insertarLeerGas() throws IOException {
		
		
		daoe.insertar(tE2);
		daog.insertar(tG2);
		daoe.añadirRelacion(tE2.getId(), tG2.getId(), 200, 50, "gasolina");
		
		List<TRGasolina> l = daog.leerPorEstablecimiento(tE2.getId());
		TRGasolina r = l.get(0);
		
		
		assertTrue(r.getGasolina().getId().equalsIgnoreCase(tG2.getId())
				&& r.getPrecio() == 200 && r.getDescuento() == 50);
		
		//daoe.borrarRelaciones(tE2.getId(), tA2.getId());
	}

	@Test
	public void insertarBorrarRelacionAlim() throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Alimento.txt");
		archivo3.delete();
		
		
		daoe.insertar(tE2);
		daoa.insertar(tA2);
		daoe.añadirRelacion(tE2.getId(), tA2.getId(), 200, 50, "alimento");
		
		List<TRAlimento> l1 = daoa.leerPorEstablecimiento(tE2.getId());
		
		assertEquals(1, l1.size());
		
		daoe.borrarRelacionesProducto(tE2.getId(), tA2.getId(), "alimento");

		List<TRAlimento> l2 = daoa.leerPorEstablecimiento(tE2.getId());
		
		
		assertEquals(0, l2.size());
	}
	
	@Test
	public void insertarBorrarRelacionGas() throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Gasolina.txt");
		archivo3.delete();
		
		
		daoe.insertar(tE2);
		daog.insertar(tG2);
		daoe.añadirRelacion(tE2.getId(), tG2.getId(), 200, 50, "gasolina");
		
		List<TRGasolina> l1 = daog.leerPorEstablecimiento(tE2.getId());
		
		assertEquals(1, l1.size());
		
		daoe.borrarRelacionesProducto(tE2.getId(), tG2.getId(), "gasolina");

		List<TRGasolina> l2 = daog.leerPorEstablecimiento(tE2.getId());
		
		
		assertEquals(0, l2.size());
	}

	@Test
	public void insertarBorrarTodasRelacionesEstablecimientosAlimentos() throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Alimento.txt");
		archivo3.delete();
		
		daoe.insertar(tE2);
		daoa.insertar(tA1);
		daoa.insertar(tA2);
		daoe.añadirRelacion(tE2.getId(), tA1.getId(), 4, 30, "alimento");
		daoe.añadirRelacion(tE2.getId(), tA2.getId(), 200, 50, "alimento");
		
		List<TRAlimento> l1 = daoa.leerPorEstablecimiento(tE2.getId());
		
		assertEquals(2, l1.size());
		
		daoe.borrarRelacionesEstablecimientos(tE2.getId());

		List<TRAlimento> l2 = daoa.leerPorEstablecimiento(tE2.getId());
		
		
		assertEquals(0, l2.size());
	}
	
	@Test
	public void insertarBorrarTodasRelacionesEstablecimientosGasolinas() throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstGas.txt");
		archivo1.delete();
		
		File archivo3 = new File("Gasolinas.txt");
		archivo3.delete();
		
		daoe.insertar(tE2);
		daog.insertar(tG1);
		daog.insertar(tG2);
		daoe.añadirRelacion(tE2.getId(), tG1.getId(), 4, 30, "gasolina");
		daoe.añadirRelacion(tE2.getId(), tG2.getId(), 200, 50, "gasolina");
		
		List<TRGasolina> l1 = daog.leerPorEstablecimiento(tE2.getId());
		
		assertEquals(2, l1.size());
		
		daoe.borrarRelacionesEstablecimientos(tE2.getId());

		List<TRGasolina> l2 = daog.leerPorEstablecimiento(tE2.getId());
		
		
		assertEquals(0, l2.size());
	}

	@Test
	public void insertarBorrarTodasRelacionesAlimentos() throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Alimento.txt");
		archivo3.delete();
		
		daoe.insertar(tE1);
		daoe.insertar(tE2);
		daoa.insertar(tA1);
		
		daoe.añadirRelacion(tE1.getId(), tA1.getId(), 4, 30, "alimento");
		daoe.añadirRelacion(tE2.getId(), tA1.getId(), 200, 50, "alimento");
		
		List<TREstablecimiento> l1 = daoe.leerPorProducto(tA1.getId(), "alimento");
		
		assertEquals(2, l1.size());
		
		daoe.borrarRelacionesProducto(tA1.getId(), "alimento");

		List<TREstablecimiento> l2 = daoe.leerPorProducto(tA1.getId(), "alimento");
		
		
		assertEquals(0, l2.size());
	}

	@Test
	public void insertarBorrarTodasRelacionesGasolinas() throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		archivo.delete();
		
		File archivo1 = new File("RelEstProd.txt");
		archivo1.delete();
		
		File archivo3 = new File("Gasolina.txt");
		archivo3.delete();
		
		daoe.insertar(tE1);
		daoe.insertar(tE2);
		daog.insertar(tG1);
		
		daoe.añadirRelacion(tE1.getId(), tG1.getId(), 4, 30, "gasolina");
		daoe.añadirRelacion(tE2.getId(), tG1.getId(), 200, 50, "gasolina");
		
		List<TREstablecimiento> l1 = daoe.leerPorProducto(tG1.getId(), "gasolina");
		
		assertEquals(2, l1.size());
		
		daoe.borrarRelacionesProducto(tG1.getId(), "gasolina");

		List<TREstablecimiento> l2 = daoe.leerPorProducto(tG1.getId(), "gasolina");
		
		
		assertEquals(0, l2.size());
	}
	

}
