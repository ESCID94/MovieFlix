package GasAndFood.business.Usuario;


public class TUsuario {
	private String id;
	private String nombre;
	private String contrasena;
	private String usuario;
	private String email;
	private boolean activo;
	
	public TUsuario(){
		this.id="";
		this.nombre="";
		this.contrasena="";
		this.usuario="";
		this.email="";
		this.activo = false;
	}

	public TUsuario(String id, String nombre, String contrasena, String usuario, String email, boolean activo){
		this.id=id;
		this.nombre=nombre;
		this.contrasena=contrasena;
		this.usuario=usuario;
		this.email=email;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getActivo () {
		return activo;
	}
	public void setActivo (boolean activo) {
		this.activo = activo;
	}
}
