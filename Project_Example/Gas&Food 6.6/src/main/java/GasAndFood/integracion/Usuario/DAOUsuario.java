package GasAndFood.integracion.Usuario;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;
import GasAndFood.business.Usuario.TUsuario;


public interface DAOUsuario {

	public void insertar(TUsuario TUsuario) throws IOException;
	public TUsuario leerPorId (String id) throws IOException;
	public TUsuario leerPorNombre (String usuario) throws IOException;
	public int modificar(String id, String contrasena, String mail, boolean activo) throws IOException;
	public List<TUsuario> readAll() throws IOException;
	public String siguienteIdAux() throws IOException ;
	public int añadirRelacion(String Id_Usuario, String id_Descuento, String id_Establecimiento) throws IOException; 
	public int borrarRelaciones(String id1, String id2, String id3) throws NumberFormatException, IOException;
	public void borrarRelaciones(String id) throws NumberFormatException, IOException;
	public List<TRDescuentoEstablecimiento> leerPorUsuario(String id) throws IOException;
}
