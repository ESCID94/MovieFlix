package GasAndFood.business.Descuento;


public class TDescuento {
		private String id;
		private TipoDescuento tipo;
		private boolean activo;
		
		
		public TDescuento (){
			this.id = "";
			this.tipo = null;
			this.activo = false;
		}
		
		public TDescuento(String id, TipoDescuento tipo, boolean activo){
			this.id = id;
			this.tipo = tipo;
			this.activo = activo;
		}
		
		/**
		 * Metodo que devuelve la id de un descuento.
		 * @return id.
		 */
		public String getId() {
			return id;
		}
		
		/**
		 * Metodo que asigna la id de un descuento.
		 * @param id,variable de tipo String que contiene la Id que vamos a asignar.
		 */
		public void setId(String id) {
			this.id = id;
		}
		
		/**
		 * Metodo que devuelve el tipo de Descuento.
		 * @return tipo, varibale que contiene el descuento.
		 */
		public TipoDescuento getTipo() {
			return tipo;
		}
		
		/**
		 * Metodo que asigna el tipo de descuento de un producto.
		 * @param tipo, variable que contiene el tipo de descuento a aplicar.
		 */
		public void setTipo(TipoDescuento tipo) {
			this.tipo = tipo;
		}
		
		/**
		 * Metodo que informa si un descuento se encuentra activo-
		 * @return true, si el descuento esta activo, false en caso contrario.
		 */
		public boolean getActivo() {
			return activo;
		}
		
		/**
		 * Metodo que activa o desactiva un descuento.
		 * @param activo , parametro booleano para activar un descuento o desactivarlo.
		 */
		public void setActivo(boolean activo) {
			this.activo = activo;
		}
}
