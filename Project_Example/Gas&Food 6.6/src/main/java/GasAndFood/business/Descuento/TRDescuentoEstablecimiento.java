package GasAndFood.business.Descuento;

import GasAndFood.business.Establecimiento.TEstablecimiento;

public class TRDescuentoEstablecimiento {
	private TDescuento descuento;
	private TEstablecimiento establecimiento;
	
	public TRDescuentoEstablecimiento(TDescuento descuento, TEstablecimiento establecimiento){
		this.descuento = descuento;
		this.establecimiento = establecimiento;
	}


	public TDescuento getDescuento() {
		return descuento;
	}

	public TEstablecimiento getEstablecimiento() {
		return establecimiento;
	}
	

	public void setDescuento(TDescuento descuento) {
		this.descuento = descuento;
	}

	public void setEstablecimiento(TEstablecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}
	
}
