package GasAndFood.business.Alimento;

import java.io.IOException;
import java.util.List;

public interface SAAlimento {

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
	public abstract int darDeAlta(TAlimento tAlim) throws IOException;

	/**
	 * Actualizamos un tEstablecimiento comprobando que ya exista y sobreescribiendo el anterior
	 * no se modifica el id.
	 * @param tE
	 * @param nombre
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	public abstract int actualizarAlimento(String id, TipoAlimento ta,
			boolean act) throws IOException;

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

	public abstract List<TAlimento> leerTodo() throws IOException;

	public abstract TAlimento leerID(String id) throws IOException;

	public abstract TAlimento leerNombre(String nombre) throws IOException;

	public abstract List<TRAlimento> leerPorEstablecimiento(String id)
			throws IOException;

}