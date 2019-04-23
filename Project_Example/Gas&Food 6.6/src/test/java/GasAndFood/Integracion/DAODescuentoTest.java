package GasAndFood.Integracion;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TipoDescuento;
import GasAndFood.integracion.Descuento.DAODescuento;
import GasAndFood.integracion.Descuento.DAODescuentoImp;

public class DAODescuentoTest {
	private DAODescuento dao = new DAODescuentoImp();
	
	
	@Test
	public void ini() throws IOException{
		File archivo = new File("Descuentos.txt");
		archivo.delete();
	}
	
	@Test
	public void compruebaSiguienteIDVacio() throws IOException {
		assertEquals(dao.siguienteIdAux(),"0");
		/**NO PUDIMOS CAMBIARLO Y ARREGLARLO*/
	}
	
	/**
	 * Funcion que compruba si el metodo insertar y el metodo leerPorTd se ejecutan correctamente. Para ello introducimos un descuento en el archivo 
	 * de descuentos y luego lo buscamos con la funcion leerPorId , comprobando que se haya guardado correctamente.
	 * @throws IOException
	 */
	@Test
	public void insertarLeerPorIdTest() throws IOException{
		TDescuento desc = new TDescuento("1",TipoDescuento.D_1, true);
		dao.insertar(desc);
		TDescuento tDescAux = dao.leerPorId("1");
		assertTrue(tDescAux.getId().equals(desc.getId())
				&& tDescAux.getTipo().equals(desc.getTipo())
				&& tDescAux.getActivo() == desc.getActivo());
	}
	
	/**
	 * Metodo que comprueba si la funcion modificar se ejecuta correctamente. Para ello realizamos dos comprobaciones. 
	 * Si introducimos descuento nuevo , la funcion debe devolvernos un 0.
	 * En caso de que el descuento ya exist y solo lo queramos actualizar ,nos devolvera un 1.
	 * @throws IOException..
	 */
	@Test
	public void modificar1() throws IOException{
		
		// compruebo si el descuento ya existe -- 0, se ha insertado uno nuevo , 1 se ha modificado uno que ya existe.
		TDescuento desc = new TDescuento("1",TipoDescuento.D_1,true);
		dao.insertar(desc);
		assertEquals(dao.modificar("1", true, TipoDescuento.D_2), 1); 
		
	}
	
	@Test 
	public void modificar2() throws IOException{
		TDescuento desc = new TDescuento("1",TipoDescuento.D_1,true);
		dao.insertar(desc);
		assertEquals(dao.modificar("2", true, TipoDescuento.D_2),0);
	}
	
	
	/**
	 * Metodo que comprueba si la funcion siguienteIDAux nos devuelve siguiente ultimo valor de los ID almacenados
	 * @throws IOException, que puede surgir a la hora de realizar la tranformacion de String a Integer, o al abrir un fichero inexistente
	 */
	@Test
	public void compruebaSiguienteIDAuxTest() throws IOException {
		TDescuento desc = new TDescuento("3",TipoDescuento.D_3,true);
		dao.insertar(desc);
		assertEquals(1 + Integer.parseInt(desc.getId()),Integer.parseInt(dao.siguienteIdAux()));
	}
	
}
