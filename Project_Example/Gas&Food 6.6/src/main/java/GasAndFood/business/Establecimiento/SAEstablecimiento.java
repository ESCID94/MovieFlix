package GasAndFood.business.Establecimiento;

import java.io.IOException;
import java.util.List;

public interface SAEstablecimiento {

	/**
	 * Metodo que da de alta un establecimiento. Se le pasa como parametro un TEstablecimiento, primero se comprueba si ya
	 * existe el establecimiento que queremos dar de alta. Si no existe ya, se cambia a ACTIVO el nuevo establecimiento y se le
	 * proporciona el siguiente ID. Despues se inserta en el fichero.
	 * 
	 * En el caso de que ya exista en el fichero, solo se comprobara si ya esta ACTIVO, si no lo esta lo actualiza.
	 * @param tE: Nuevo objeto del establecimiento a dar de alta.
	 * @return 0: si se ha creado y esta activado.
	 * 1: si esta activado.
	 * 2: Error, ya ha sido activado anteriormente.
	 * @throws IOException: Excepcion lanzada en caso de que no se pueda leer de fichero.
	 */
	public abstract int darDeAlta(TEstablecimiento tE) throws IOException;

	/**
	 * Actualizamos un tEstablecimiento comprobando que ya exista y sobreescribiendo el anterior
	 * no se modifica el id.
	 * @param tE
	 * @param nombre
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	public abstract int actualizarEstablecimiento(String id,
			TipoEstablecimiento di, boolean act) throws IOException;

	/**
	 * Metodo que realiza las mismas acciones que el metodo anterior darDeAlta(), la unica diferencia es que en 
	 * este caso cambia el boolean activo a FALSE. Desactiva el establecimiento.
	 * @param tE: Establecimiento a dar de baja.
	 * @return 0: si se ha creado y esta activado.
	 * 1: si esta activado.
	 * 2: Error, ya ha sido activado anteriormente.
	 * @throws IOException
	 */
	public abstract int darDeBaja(String id) throws IOException;

	public abstract List<TEstablecimiento> leerTodo() throws IOException;

	public abstract TEstablecimiento leerID(String id)
			throws IOException;

	public abstract TEstablecimiento leerNombre(String nombre, String direccion)
			throws IOException;

	public List<TREstablecimiento> leerPorAlimento(String id) throws IOException;
	
	public List<TREstablecimiento> leerPorGasolina(String id) throws IOException;

	
	public int borrarRelacionesAlimentos(String id1, String id2) throws NumberFormatException, IOException;
	
	public int borrarRelacionesGasolinas(String id1, String id2) throws NumberFormatException, IOException;

	public abstract int añadirRelacionAlimento(String id1, String id2, float precio,
			int descuento) throws IOException;
	
	public abstract int añadirRelacionGasolina(String id1, String id2, float precio,
			int descuento) throws IOException;

}