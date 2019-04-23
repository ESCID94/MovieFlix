package GasAndFood.Integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;
import GasAndFood.business.Descuento.TipoDescuento;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
import GasAndFood.business.Usuario.TUsuario;
import GasAndFood.integracion.Descuento.DAODescuentoImp;
import GasAndFood.integracion.Establecimiento.DAOEstablecimientoImp;
import GasAndFood.integracion.Usuario.DAOUsuarioImp;

public class DAORelUsuDesEmpTest {

	private DAOEstablecimientoImp daoe = new DAOEstablecimientoImp();
	private DAODescuentoImp daod = new DAODescuentoImp();
	private DAOUsuarioImp daou = new DAOUsuarioImp();
	
	private TEstablecimiento tE1 = new TEstablecimiento("0", "a", 
			"a", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TEstablecimiento tE2 = new TEstablecimiento("1", "b", 
			"b", "1", true, TipoEstablecimiento.ALIMENTACION);
	private TDescuento tD1 = new TDescuento("0", TipoDescuento.D_1, true);
	private TDescuento tD2 = new TDescuento("1", TipoDescuento.D_2, true);
	private TUsuario tU1 = new TUsuario("0", "U1","u1" ,"u_1", "ejemplo@u_1",true);
	private TUsuario tU2 = new TUsuario("1", "U2","u2" ,"u_2", "ejemplo@u_2",true);
	
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
		
		daod.insertar(tD1);
		daou.insertar(tU1);
		daoe.insertar(tE1);
		
		daou.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
		
		List<TRDescuentoEstablecimiento> listUsuario = daou.leerPorUsuario(tU1.getId());
		TRDescuentoEstablecimiento relUsuDesc = listUsuario.get(0);
		
		assertTrue(relUsuDesc.getDescuento().getId().equalsIgnoreCase(tD1.getId())
				&& relUsuDesc.getEstablecimiento().getId().equalsIgnoreCase(tE1.getId()));
		
		daou.borrarRelaciones(tU1.getId(), tD1.getId(), tE1.getId());
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
		
		daod.insertar(tD1);
		daou.insertar(tU1);
		daoe.insertar(tE1);
		
		daou.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
		
		List<TRDescuentoEstablecimiento> lista1 = daou.leerPorUsuario(tU1.getId());
		
		assertEquals(1, lista1.size());

		daou.borrarRelaciones(tU1.getId(), tD1.getId(), tE1.getId());

		List<TRDescuentoEstablecimiento> lista2 = daou.leerPorUsuario(tU1.getId());
		
		
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
			
			daod.insertar(tD1);
			daou.insertar(tU1);
			daoe.insertar(tE1);
			daod.insertar(tD2);
			daoe.insertar(tE2);
			
			daou.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
			daou.añadirRelacion(tU1.getId(), tD2.getId(),tE2.getId());

		
			List<TRDescuentoEstablecimiento> lista1 = daou.leerPorUsuario(tU1.getId());
			
			assertEquals(2, lista1.size());
			
			daou.borrarRelaciones(tU1.getId());
			
			List<TRDescuentoEstablecimiento> lista2 = daou.leerPorUsuario(tU1.getId());

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
			
			daod.insertar(tD1);
			daou.insertar(tU1);
			daoe.insertar(tE1);
			daod.insertar(tD2);
			daoe.insertar(tE2);
			
			daou.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
			daou.añadirRelacion(tU1.getId(), tD2.getId(),tE2.getId());

		
			List<TRDescuentoEstablecimiento> lista1 = daou.leerPorUsuario(tU1.getId());
			
			assertEquals(2, lista1.size());
			
			daod.borrarRelacionesDescUsu(tD1.getId());
			
			List<TRDescuentoEstablecimiento> lista2 = daou.leerPorUsuario(tU1.getId());

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
			
			daod.insertar(tD1);
			daou.insertar(tU1);
			daoe.insertar(tE1);
			daod.insertar(tD2);
			daoe.insertar(tE2);
			
			daou.añadirRelacion(tU1.getId(), tD1.getId(),tE1.getId());
			daou.añadirRelacion(tU1.getId(), tD2.getId(),tE2.getId());

		
			List<TRDescuentoEstablecimiento> lista1 = daou.leerPorUsuario(tU1.getId());
			
			assertEquals(2, lista1.size());
			
			daoe.borrarRelacionesDescUsu(tE2.getId());
			
			List<TRDescuentoEstablecimiento> lista2 = daou.leerPorUsuario(tU1.getId());

			assertEquals(1, lista2.size());

	}
}
