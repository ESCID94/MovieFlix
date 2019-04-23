package GasAndFood.integracion.Factorias;

import GasAndFood.integracion.Alimento.DAOAlimento;
import GasAndFood.integracion.Alimento.DAOAlimentoImp;
import GasAndFood.integracion.Descuento.DAODescuento;
import GasAndFood.integracion.Descuento.DAODescuentoImp;
import GasAndFood.integracion.Establecimiento.DAOEstablecimiento;
import GasAndFood.integracion.Establecimiento.DAOEstablecimientoImp;
import GasAndFood.integracion.Gasolina.DAOGasolina;
import GasAndFood.integracion.Gasolina.DAOGasolinaImp;
import GasAndFood.integracion.Usuario.DAOUsuario;
import GasAndFood.integracion.Usuario.DAOUsuarioImp;

public class FactoriaIntegracionFicheros extends FactoriaIntegracion {

	@Override
	public DAOEstablecimiento getDAOEstablecimiento() {
		return new DAOEstablecimientoImp();
	}

	@Override
	public DAOUsuario getDAOUsuario() {
		return new DAOUsuarioImp();
	}

	@Override
	public DAOGasolina getDAOGasolina() {
		return new DAOGasolinaImp();
	}

	@Override
	public DAOAlimento getDAOAlimento() {
		return new DAOAlimentoImp();
	}

	@Override
	public DAODescuento getDAODescuento() {
		return new DAODescuentoImp();
	}

}
