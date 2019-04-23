package GasAndFood.business.Alimento;

public class TRAlimento {
	private TAlimento alimento;
	private float precio;
	private int descuento;
	
	
	public TRAlimento(TAlimento alimento, float precio, int descuento){
		this.alimento = alimento;
		this.precio = precio;
		this.descuento = descuento;
	}


	public TAlimento getAlimento() {
		return alimento;
	}


	public void setalimento(TAlimento alimento) {
		this.alimento = alimento;
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
