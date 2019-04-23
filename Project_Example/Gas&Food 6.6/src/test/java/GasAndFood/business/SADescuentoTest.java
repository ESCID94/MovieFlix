package GasAndFood.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import GasAndFood.business.Descuento.SADescuento;
import GasAndFood.business.Descuento.SADescuentoImp;
import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TipoDescuento;

public class SADescuentoTest {
		
		private TDescuento tE = new TDescuento("6",TipoDescuento.D_1, true);
		
		
		/**
		 * Metodo que comprueba que si un descuento no existe , no se puede actualizar.
		 * Devuelve un  cero , si el descuento no existe.
		 * @throws IOException
		 */
		@Test
		public void testActualizarDescuentoSinDarDeAlta() throws IOException {
			SADescuento des = new SADescuentoImp();
			int ret = des.actualizarDescuento("-1", TipoDescuento.D_2, true);
			assertEquals(ret, 0);
		}
		
		/**
		 * Metodo que comprueba que se actualice un descuento existente.
		 * Devuelve 1 , si el descuento se ha actualizado correctamente.
		 * @throws IOException
		 */
		@Test
		public void testActualizarDescuentoDadoDeAlta() throws IOException {
			SADescuento des = new SADescuentoImp();
			des.darDeAlta(tE);
			int ret = des.actualizarDescuento(tE.getId(), TipoDescuento.D_3, false );
			assertEquals(ret, 1);
		}
		


		/**
		 * Metodo que comprueba si la funcion dar de baja funciona correctamente cunado el descuento existe y esta activo
		 * Devuelve un 1, si se ha podido borrar el descuento.
		 * @throws IOException
		 */
		@Test
		public void testDarDeBaja1() throws IOException {
			SADescuento saDes = new SADescuentoImp();
			tE = new TDescuento("7",TipoDescuento.D_3,true);
			saDes.darDeAlta(tE);
			saDes.actualizarDescuento(tE.getId(), TipoDescuento.D_4, true);
			int ret = saDes.darDeBaja(tE.getId());
			assertEquals(ret, 1);
		}

		/**
		 * Metodo que comprueba el metodo dar debaja cuando descuento no existe
		 * Devuelve un 1, si se ha podido borrar el descuento.
		 */
		@Test
		public void testDarDeBaja0() throws IOException {
			SADescuento saDes = new SADescuentoImp();
			int ret = saDes.darDeBaja("-1");
			assertEquals(ret, 0);
		}

		/**
		 * Metodo que comprueba el metodo dar debaja cuando descuento existe, pero no esta activo
		 * Devuelve un 1, si se ha podido borrar el descuento.
		 * */
		@Test
		public void testDarDeBaja2() throws IOException {
			SADescuento saDes = new SADescuentoImp();
			tE = new TDescuento("8", TipoDescuento.D_3, false);
			saDes.darDeAlta(tE);
			saDes.actualizarDescuento(tE.getId(), TipoDescuento.D_5, false);
			int ret = saDes.darDeBaja(tE.getId());
			assertEquals(ret, 2);
		}
		

		@Test
		public void insertaLee() throws IOException {
			SADescuento saDes = new SADescuentoImp();
			tE = new TDescuento("9", TipoDescuento.D_5, true);
			saDes.darDeAlta(tE);
			TDescuento tDescAux = saDes.leerID(tE.getId());
			
			assertTrue(tDescAux.getId().equals(tE.getId())
					&& tE.getTipo().equals(tE.getTipo())
					&& tE.getActivo() == true);
		}
}
