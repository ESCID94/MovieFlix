package GasAndFood.business.Factorias;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Alimento.SAAlimentoImp;
import GasAndFood.business.Descuento.SADescuento;
import GasAndFood.business.Descuento.SADescuentoImp;
import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Establecimiento.SAEstablecimientoImp;
import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Gasolina.SAGasolinaImp;
import GasAndFood.business.Usuario.SAUsuario;
import GasAndFood.business.Usuario.SAUsuarioImp;

public class FactoriaBussinesFicheros extends FactoriaBussines {

	@Override
	public SAEstablecimiento getSAEstablecimiento() {
		return new SAEstablecimientoImp();
	}

	@Override
	public SAAlimento getSAAlimento() {
		return new SAAlimentoImp();
	}

	@Override
	public SADescuento getSADescuento() {
		return new SADescuentoImp();
	}

	@Override
	public SAGasolina getSAGasolina() {
		return new SAGasolinaImp();
	}

	@Override
	public SAUsuario getSAUsuario() {
		return new SAUsuarioImp();
	}

}
