package GasAndFood.business.Usuario;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;

public interface SAUsuario {

	public abstract int darDeAlta(TUsuario tU) throws IOException;

	public abstract int actualizarUsuario(String id, String contrasena, String mail,
			boolean act) throws IOException;

	public abstract int darDeBaja(String id) throws IOException;

	public abstract List<TUsuario> leerTodo() throws IOException;

	public abstract TUsuario leerID(String id) throws IOException;

	public abstract TUsuario leerNombre(String nombre) throws IOException;

	public abstract int añadirRelacion(String id1, String id2,String id3) throws IOException;
	
	public abstract int borrarRelaciones(String id1, String id2, String id3) throws NumberFormatException, IOException;
	public abstract List<TRDescuentoEstablecimiento> leerPorUsuario(String id) throws IOException;
}