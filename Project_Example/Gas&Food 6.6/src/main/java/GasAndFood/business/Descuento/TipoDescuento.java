package GasAndFood.business.Descuento;

public enum TipoDescuento {

	/**
	 * Los descuentos existentes dependen del tipo de alimento y de gasolina en el inventario del establecimiento.
	 */
	D_1("20%"),
	D_2("5Ä"),
	D_3("15%"),
	D_4("10Ä"),
	D_5("2x1");
	
	private final String nombre;
	
	/**
	 * Constructora del tipo enumerado TipoDescuento.
	 * @param nombre, variable que contiene el nombre del descuento
	 */
	private TipoDescuento (String nombre){
		this.nombre = nombre;
	}
	
	/**Metodo que devuelve un String con el nombre del descuento.
	 * @return nombre
	 */
	public String toString(){
		return this.nombre;
	}
	
	/**
	 * Metodo que devuelve el descuento seleccionado , a trav√©s de su nombre. 
	 * @param tipo, es la variable que contiene el nombre del descuento.
	 * @return descuento , si se ha podido encontrar , null en caso contrario.
	 */
	public static TipoDescuento stringToEnum(String tipo){
		boolean encontrado = false;
		int i = 0;
		TipoDescuento[] descuentos = TipoDescuento.values();
		TipoDescuento descuento = null;
		
		while(i < descuentos.length && !encontrado){
			if (descuentos[i].toString().equalsIgnoreCase(tipo)) {
				encontrado = true;
				descuento = descuentos[i];
			}
			else i++;
		}
		return descuento;
	}
}
