package GasAndFood.business.Establecimiento;

public enum TipoEstablecimiento {
	GASOLINERA ("GASOLINERA"),
	ALIMENTACION("ALIMENTACION");
	
	private final String nombre; 
	
	private TipoEstablecimiento(String nombre){
		this.nombre = nombre;
	}
	
	public String toString(){
		return this.nombre;
	}
	
	public static TipoEstablecimiento stringToEnum(String tipo){
		boolean encontrado = false;
		int i = 0;
		TipoEstablecimiento[] establecimientos =  TipoEstablecimiento.values();
		TipoEstablecimiento establecimiento = null;
		
		while(i < establecimientos.length && !encontrado){
			if (establecimientos[i].toString().equalsIgnoreCase(tipo)) {
				encontrado = true;
				establecimiento = establecimientos[i];
			}
			else i++;
		}
		return establecimiento;
	}
}
