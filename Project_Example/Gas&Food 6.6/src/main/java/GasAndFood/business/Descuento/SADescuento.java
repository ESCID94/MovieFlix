package GasAndFood.business.Descuento;

import java.io.IOException;
import java.util.List;

public interface SADescuento {

	//TODO preguntar como vamos a relacionar los descuentos con los productos.
	/**
	 * Metodo que da de alta un descuento. Recibe un descuento y comprueva  si el descuento existe y si esta activo o no. 
	 * Si el descuento exise y esta activo solo informaremos de ello.
	 * Si existe pero esta descativado, procedemos a activarlo.
	 * Si no existe , se registrar en el fichero , se le asignara una id ( un valor mas que la actual) y se pondra en activo.
	 * @param tDescuento , es el descuento que recibimos, para poder darlo de alta , activarlo etc..
	 * @return 0: si se ha creado y esta activado ; 1: si esta activado; 2: Error, ya ha sido activado anteriormente.
	 * @throws IOException: Excepcion lanzada en caso de que no se pueda leer de fichero.
	 */
	public abstract int darDeAlta(TDescuento tDesc) throws IOException;

	/**
	 * Metodo  que modifica el estado del descuento para darlo de baja.
	 * @param id , identificador del descuento.
	 * @return un int, segun se haya resuelto. 0 , no existe el descuento; 1 descuento desactivado, 2 descueno inactivo.
	 * @throws IOException
	 */
	public abstract int darDeBaja(String id) throws IOException;

	/**
	 * Metodo que actualiza el descuento de la lista de descuentos.
	 * @param id, int que contiene el identificador de descuento.
	 * @param Des, variable de tipo enum , que contiene los descuentos.
	 * @param act, variable booleana que indica si el descuento sera activado o no.
	 * @return un int,  0 si no ha habido modificacion, n en caso actualizar.
	 * @throws IOException
	 */
	public abstract int actualizarDescuento(String id, TipoDescuento Des,
			boolean act) throws IOException;

	/**
	 * Metodo que se encarga de extraer todos los descuentos del archivo de descuentos y los carga en una lista de descuentos.
	 * @return la lista de los descuentos si ha tenido exito, null en caso contrario.
	 * @throws IOException 
	 */
	public abstract List<TDescuento> leerTodo() throws IOException;

	/**
	 * Metodo que recibe un TrasferObeject con un Id, para poder buscar un descuento 
	 * @param tDesc,variable de ti TDescuento que contiene el ID del descuento que queremos obtener.
	 * @return un TDecuento si ha sido encontrado , null en caso contrario.
	 * @throws IOException 
	 */
	public abstract TDescuento leerID(String idDe)
			throws IOException;

}