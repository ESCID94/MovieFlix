package GasAndFood.integracion.Alimento;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TRAlimento;
import GasAndFood.business.Alimento.TipoAlimento;

public interface DAOAlimento {
	public void insertar(TAlimento tAlimento) throws IOException;
	public TAlimento leerPorId (String id) throws IOException;
	public TAlimento leerPorNombre(String nombre) throws IOException;
	public int modificar(String id, boolean activo, TipoAlimento tipo) throws IOException;
	public List<TAlimento> readAll() throws IOException;
	public String siguienteIdAux() throws IOException;
	public List<TRAlimento> leerPorEstablecimiento(String id) throws IOException;
	
}
