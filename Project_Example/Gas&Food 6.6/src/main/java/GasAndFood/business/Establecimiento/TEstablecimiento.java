package GasAndFood.business.Establecimiento;


public class TEstablecimiento {
	private String id;
	private String nombre;
	private TipoEstablecimiento tipo;
	private String direccion;
	private String CP;
	private boolean activo;
	
	public TEstablecimiento(){
		this.id = "";
		this.nombre = "";
		this.tipo = null;
		this.direccion = "";
		this.CP = "0";
		this.activo = false;
	}
	public TEstablecimiento(String id, String nombre, String direccion, String CP, boolean activo, TipoEstablecimiento tipo){
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.direccion = direccion;
		this.CP = CP;
		this.activo = activo;
	}

	
	public String getId(){
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoEstablecimiento getTipo() {
		return tipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCP() {
		return CP;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(TipoEstablecimiento tipo) {
		this.tipo = tipo;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCP(String cp) {
		this.CP = cp;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
