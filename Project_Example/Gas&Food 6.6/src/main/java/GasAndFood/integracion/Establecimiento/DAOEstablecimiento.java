package GasAndFood.integracion.Establecimiento;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TREstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;


public interface DAOEstablecimiento {

	public void insertar(TEstablecimiento TEstablecimiento) throws IOException;
	public TEstablecimiento leerPorId (String id) throws IOException;
	public TEstablecimiento leerPorNombre (String nombre, String dir) throws IOException;
	public int modificar(String id, boolean activo, TipoEstablecimiento tipo) throws IOException;
	//public void actualizaActivo(String id, boolean act) throws IOException;
	public List<TEstablecimiento> readAll() throws IOException;
	public String siguienteIdAux() throws IOException;
	public List<TREstablecimiento> leerPorProducto(String id, String tipo) throws IOException;
	public void borrarRelacionesEstablecimientos(String id) throws NumberFormatException, IOException;//todos los establecimientos
	public int borrarRelacionesProducto(String id1, String id2, String tipo) throws NumberFormatException, IOException;//estblacimiento y producto
	public int añadirRelacion(String id1, String id2, float precio, int descuento, String tipo) throws IOException;
	public void borrarRelacionesProducto(String id, String tipo) throws NumberFormatException, IOException;
	public void borrarRelacionesDescUsu(String id_establecimiento) throws IOException;
}
