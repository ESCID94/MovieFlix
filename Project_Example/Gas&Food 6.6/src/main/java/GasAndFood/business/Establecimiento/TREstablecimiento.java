package GasAndFood.business.Establecimiento;

public class TREstablecimiento {
	
	private TEstablecimiento establecimiento;
	private float precio;
	private int descuento;
	
	
	public TREstablecimiento(TEstablecimiento establecimiento, float precio, int descuento){
		this.descuento = descuento;
		this.establecimiento = establecimiento;
		this.precio = precio;
	}


	public TEstablecimiento getEstablecimiento() {
		return establecimiento;
	}


	public void setEstablecimiento(TEstablecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	
	
	
	
	
	
	
}
