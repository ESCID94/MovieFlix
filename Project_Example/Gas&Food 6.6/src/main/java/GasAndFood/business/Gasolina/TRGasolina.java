package GasAndFood.business.Gasolina;

public class TRGasolina {
	private TGasolina gasolina;
	private float precio;
	private int descuento;
	
	
	public TRGasolina(TGasolina gasolina, float precio, int descuento){
		this.gasolina = gasolina;
		this.precio = precio;
		this.descuento = descuento;
	}


	public TGasolina getGasolina() {
		return gasolina;
	}


	public void setGasolina(TGasolina gasolina) {
		this.gasolina = gasolina;
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
