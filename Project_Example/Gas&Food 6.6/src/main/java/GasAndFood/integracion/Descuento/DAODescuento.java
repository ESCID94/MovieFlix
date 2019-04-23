package GasAndFood.integracion.Descuento;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TipoDescuento;

public interface DAODescuento {
	public void insertar(TDescuento tDescuento) throws IOException;
	public TDescuento leerPorId (String id) throws  IOException;
	public int modificar(String id, boolean activo, TipoDescuento tipo) throws IOException;
	public List<TDescuento> readAll() throws IOException;
	public String siguienteIdAux() throws  IOException;
	void borrarRelacionesDescUsu(String id_descuento) throws IOException;
}
