package GasAndFood.business.Factorias;

import GasAndFood.business.Alimento.SAAlimento;
import GasAndFood.business.Descuento.SADescuento;
import GasAndFood.business.Establecimiento.SAEstablecimiento;
import GasAndFood.business.Gasolina.SAGasolina;
import GasAndFood.business.Usuario.SAUsuario;

public abstract class FactoriaBussines {
	private static FactoriaBussines factoria;
	
	public static FactoriaBussines getInstance(){
		if(factoria == null) factoria = new FactoriaBussinesFicheros();
			return factoria;
	}
	
	public abstract SAEstablecimiento getSAEstablecimiento();
	public abstract SAAlimento getSAAlimento();
	public abstract SADescuento getSADescuento();
	public abstract SAGasolina getSAGasolina();
	public abstract SAUsuario getSAUsuario();
}
