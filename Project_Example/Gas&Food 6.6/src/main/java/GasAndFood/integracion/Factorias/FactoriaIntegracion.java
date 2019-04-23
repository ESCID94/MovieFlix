package GasAndFood.integracion.Factorias;

import GasAndFood.integracion.Alimento.DAOAlimento;
import GasAndFood.integracion.Descuento.DAODescuento;
import GasAndFood.integracion.Establecimiento.DAOEstablecimiento;
import GasAndFood.integracion.Gasolina.DAOGasolina;
import GasAndFood.integracion.Usuario.DAOUsuario;

public abstract class FactoriaIntegracion {
	private static FactoriaIntegracion factoria;
	
	public static FactoriaIntegracion getInstance(){
		if(factoria == null) factoria = new FactoriaIntegracionFicheros();
			return factoria;
	}
	
	public abstract DAOEstablecimiento getDAOEstablecimiento();
	public abstract DAOUsuario getDAOUsuario();
	public abstract DAOGasolina getDAOGasolina();
	public abstract DAOAlimento  getDAOAlimento();
	public abstract DAODescuento getDAODescuento();

}
