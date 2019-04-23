package GasAndFood.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Descuento.SADescuento;
import GasAndFood.business.Descuento.SADescuentoImp;
import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;
import GasAndFood.business.Descuento.TipoDescuento;
import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.SAEstablecimientoImp;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.business.Usuario.SAUsuario;
import GasAndFood.business.Usuario.SAUsuarioImp;
import GasAndFood.business.Usuario.TUsuario;


public class SARelDescUsuEstTest {
	SAEstablecimiento sae = new SAEstablecimientoImp();
	SADescuento sad = new SADescuentoImp();
	SAUsuario sau = new SAUsuarioImp();
	

	private TEstablecimiento tE1 = new TEstablecimiento("0", "a", 
			"a", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TEstablecimiento tE2 = new TEstablecimiento("1", "b", 
			"b", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TDescuento tD1 = new TDescuento("0", TipoDescuento.D_1, true);
	private TDescuento tD2 = new TDescuento("1", TipoDescuento.D_2, true);
	private TUsuario tU1 = new TUsuario("0", "U1","u1" ,"u_1", "ejemplo@u_1",true);
	private TUsuario tU2 = new TUsuario("1", "U2","u2" ,"u_2", "ejemplo@u_2",true);

	
	/**
	 * inicializacion de los txt a utilizar
	 * */
	@Test
	public void ini() throws IOException{
		File archivo = new File("Usuario.txt");
		archivo.delete();
		
		File archivo1 = new File("RelUsuDes.txt");
		archivo1.delete();
		
		File archivo2 = new File("Establecimiento.txt");
		archivo2.delete();
		
		File archivo3 = new File("Descuento.txt");
		archivo3.delete();
	}
	
	@Test
	public void insertarRelacion() throws NumberFormatException, IOException{
		
		sad.darDeAlta(tD1);
		sau.darDeAlta(tU1);
		sae.darDeAlta(tE1);
		
		sau.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
		
		List<TRDescuentoEstablecimiento> listUsuario = sau.leerPorUsuario(tU1.getId());
		TRDescuentoEstablecimiento relUsuDesc = listUsuario.get(0);
		
		assertTrue(relUsuDesc.getDescuento().getId().equalsIgnoreCase(tD1.getId())
				&& relUsuDesc.getEstablecimiento().getId().equalsIgnoreCase(tE1.getId()));
		
		sau.borrarRelaciones(tU1.getId(), tD1.getId(), tE1.getId());
	}
	
	@Test
	public void insertarBorrarRelacionUsuario() throws IOException {
		File archivo = new File("Usuario.txt");
		archivo.delete();
		
		File archivo1 = new File("RelUsuDes.txt");
		archivo1.delete();
		
		File archivo2 = new File("Establecimiento.txt");
		archivo2.delete();
		
		File archivo3 = new File("Descuento.txt");
		archivo3.delete();
		
		sad.darDeAlta(tD2);
		sau.darDeAlta(tU2);
		sae.darDeAlta(tE2);

		
		sau.añadirRelacion(tU2.getId(), tD2.getId(),tE2.getId());
		
		List<TRDescuentoEstablecimiento> lista1 = sau.leerPorUsuario(tU2.getId());
		
		assertEquals(1, lista1.size());

		sau.borrarRelaciones(tU2.getId(), tD2.getId(), tE2.getId());

		List<TRDescuentoEstablecimiento> lista2 = sau.leerPorUsuario(tU2.getId());
		
		
		assertEquals(0, lista2.size());
	}
	
	@Test
	public void insertarYDarDeBajaUSuario() throws IOException {
			File archivo = new File("Usuario.txt");
			archivo.delete();
			
			File archivo1 = new File("RelUsuDes.txt");
			archivo1.delete();
			
			File archivo2 = new File("Establecimiento.txt");
			archivo2.delete();
			
			File archivo3 = new File("Descuento.txt");
			archivo3.delete();
		
			
			sau.darDeAlta(tU1);
			sad.darDeAlta(tD1);
			sad.darDeAlta(tD2);
			sae.darDeAlta(tE1);
			sae.darDeAlta(tE2);
			
			sau.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
			sau.añadirRelacion(tU1.getId(), tD2.getId(),tE2.getId());

		
			List<TRDescuentoEstablecimiento> lista1 = sau.leerPorUsuario(tU1.getId());
			
			assertEquals(2, lista1.size());
			
			sau.darDeBaja(tU1.getId());
			
			List<TRDescuentoEstablecimiento> lista2 = sau.leerPorUsuario(tU1.getId());

			assertEquals(0, lista2.size());

	}
	@Test
	public void insertarYDarDeBajaDescuento() throws IOException {
			File archivo = new File("Usuario.txt");
			archivo.delete();
			
			File archivo1 = new File("RelUsuDes.txt");
			archivo1.delete();
			
			File archivo2 = new File("Establecimiento.txt");
			archivo2.delete();
			
			File archivo3 = new File("Descuento.txt");
			archivo3.delete();
		
			
			sau.darDeAlta(tU2);
			sad.darDeAlta(tD1);
			sad.darDeAlta(tD2);
			sae.darDeAlta(tE1);
			sae.darDeAlta(tE2);
			
			sau.añadirRelacion(tU2.getId(), tD1.getId(),tE1.getId());
			sau.añadirRelacion(tU2.getId(), tD2.getId(),tE2.getId());

		
			List<TRDescuentoEstablecimiento> lista1 = sau.leerPorUsuario(tU2.getId());
			
			assertEquals(2, lista1.size());
			
			sad.darDeBaja(tD2.getId());
			
			List<TRDescuentoEstablecimiento> lista2 = sau.leerPorUsuario(tU2.getId());

			assertEquals(1, lista2.size());

	}
	@Test
	public void insertarYDarDeBajaEstablecimiento() throws IOException {
			File archivo = new File("Usuario.txt");
			archivo.delete();
			
			File archivo1 = new File("RelUsuDes.txt");
			archivo1.delete();
			
			File archivo2 = new File("Establecimiento.txt");
			archivo2.delete();
			
			File archivo3 = new File("Descuento.txt");
			archivo3.delete();
		
			
			sau.darDeAlta(tU2);
			sad.darDeAlta(tD1);
			sad.darDeAlta(tD2);
			sae.darDeAlta(tE1);
			sae.darDeAlta(tE2);
			
			sau.añadirRelacion(tU2.getId(), tD1.getId(),tE1.getId());
			sau.añadirRelacion(tU2.getId(), tD2.getId(),tE2.getId());

		
			List<TRDescuentoEstablecimiento> lista1 = sau.leerPorUsuario(tU2.getId());
			
			assertEquals(2, lista1.size());
			
			sae.darDeBaja(tE2.getId());
			
			List<TRDescuentoEstablecimiento> lista2 = sau.leerPorUsuario(tU2.getId());

			assertEquals(1, lista2.size());

	}
}
