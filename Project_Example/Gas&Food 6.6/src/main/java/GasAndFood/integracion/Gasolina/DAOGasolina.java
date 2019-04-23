package GasAndFood.integracion.Gasolina;

import java.io.IOException;
import java.util.List;

import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TRGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;

public interface DAOGasolina {
	public void insertar(TGasolina tGasolina) throws IOException;
	public TGasolina leerPorId (String id) throws IOException;
	public TGasolina leerPorNombre(String nombre) throws IOException;
	public int modificar(String id, boolean activo, String gasolinaEst, TipoGasolina tipo) throws IOException;
	public List<TGasolina> readAll() throws IOException;
	public String siguienteIdAux() throws IOException;
	public List<TRGasolina> leerPorEstablecimiento(String id) throws IOException;
}
