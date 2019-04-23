package GasAndFood.integracion.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TRDescuentoEstablecimiento;
import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Usuario.TUsuario;
import GasAndFood.integracion.Descuento.DAODescuento;
import GasAndFood.integracion.Establecimiento.DAOEstablecimiento;
import GasAndFood.integracion.Factorias.FactoriaIntegracion;

public class DAOUsuarioImp implements DAOUsuario {

	@Override
	public void insertar (TUsuario TUsuario) throws IOException {
		File archivo = new File("Usuarios.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
		String activo = "0";

		if (archivo.exists()) {
			writer.write(TUsuario.getId());
			writer.write(" ");
			writer.write(TUsuario.getNombre());
			writer.write(" ");
			writer.write(TUsuario.getContrasena());
			writer.write(" ");
			writer.write(TUsuario.getUsuario());
			writer.write(" ");
			writer.write(TUsuario.getEmail());
			writer.write(" ");
			if (TUsuario.getActivo()) activo = "1";
			writer.write(activo);
			writer.newLine();
		}
		writer.close();
	}

	@Override
	public TUsuario leerPorId (String id) throws IOException {
		File archivo = new File("Usuarios.txt");
		if(!archivo.exists()) archivo.createNewFile();
		
		Scanner sc = new Scanner(archivo);
		String usuario;
		String usuarioArray[];
		TUsuario TUsu = null;
		boolean encontrado = false, act;

		while (sc.hasNext() && !encontrado) {
			usuario = sc.nextLine();
			usuarioArray = usuario.split(" ");
			if (usuarioArray[0].equalsIgnoreCase(""+id)) {
				encontrado = true;
				if(usuarioArray[5].equalsIgnoreCase("1")) act = true;
				else act = false;
				TUsu = new TUsuario(usuarioArray[0], usuarioArray[1], usuarioArray[2], usuarioArray[3], usuarioArray[4], act);
			}
		}
		sc.close();
		return TUsu;
	}

	@Override
	public TUsuario leerPorNombre (String usuario) throws IOException {
		File archivo = new File("Usuarios.txt");
		if(!archivo.exists()) archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		String nick;
		String usuArray[];
		TUsuario TUsu = null;
		boolean encontrado = false, act;

		while (sc.hasNext() && !encontrado) {
			nick = sc.nextLine();
			usuArray = nick.split(" ");
			if (usuArray[1].equalsIgnoreCase(""+usuario)) {
				encontrado = true;
				act = usuArray[5].equalsIgnoreCase("1");
				TUsu = new TUsuario(usuArray[0], usuArray[1], usuArray[2], usuArray[3], usuArray[4], act);
			}
		}
		sc.close();
		return TUsu;
	}

	@Override
	public int modificar (String id, String contrasena, String mail, boolean activo) throws IOException {
		String datos;
		String usuarioArray[];
		int ret = 0, actAux;
		boolean act;
		File archivo = new File("Usuarios.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		archivo.renameTo(new File("UsuariosAux.txt"));
		File archivoViejo = new File("UsuariosAux.txt");
		Scanner sc = new Scanner(archivoViejo);

		while (sc.hasNext()) {
			datos = sc.nextLine();
			usuarioArray = datos.split(" ");
			if (usuarioArray[0].equalsIgnoreCase(id)) {
				TUsuario TUsu = new TUsuario(id, usuarioArray[1], contrasena, usuarioArray[3], mail, activo);
				insertar(TUsu);
				ret = 1;
			}
			else {
				actAux = Integer.parseInt(usuarioArray[5]);
				act = actAux == 1;
				TUsuario TUsu = new TUsuario( usuarioArray[0], usuarioArray[1], usuarioArray[2], usuarioArray[3], usuarioArray[4], act);
				insertar(TUsu);
			}
		}
		sc.close();
		archivoViejo.delete();
		return ret;
	}

	@Override
	public List<TUsuario> readAll () throws IOException {
		List<TUsuario> usuarios = new ArrayList<TUsuario>();
		String usuario;
		String usuArray[];
		TUsuario TUsu = null;
		boolean act;
		File archivo = new File("Usuarios.txt");
		if(!archivo.exists()) archivo.createNewFile();
		Scanner sc = new Scanner(archivo);

			while (sc.hasNext()) {
				usuario = sc.nextLine();
				usuArray = usuario.split(" ");
				act = usuArray[5].equalsIgnoreCase("1");
				TUsu = new TUsuario(usuArray[0], usuArray[1], usuArray[2], usuArray[3], usuArray[4], act);
				usuarios.add(TUsu);
			}
			sc.close();

		return usuarios;
	}

	@Override
	public String siguienteIdAux () throws IOException {
		String idFinal = " ";
		String linea;
		String usuArray[];
		
		File archivo = new File("Usuarios.txt");
		if(!archivo.exists()){
			archivo.createNewFile();
		}
		Scanner sc = new Scanner(archivo);

		while (sc.hasNext()) {

			linea = sc.nextLine();
			linea = linea.trim();
			usuArray = linea.split(" ");
			idFinal = usuArray[0];
		}
		sc.close();

		if(idFinal.equalsIgnoreCase(" ")) return "0";
	    else{
	    	   	int id = Integer.parseInt(idFinal) + 1;
	    	   	return Integer.toString(id);
	       	}
	}
	public void insertar(String idUsuario, String idDescuento, String idEstablecimiento) throws IOException {
		File archivo = new File("RelUsuDescEstab.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		 
		
		if(!archivo.exists()) {
			archivo.createNewFile();
		} 
			writer.write(idUsuario);
			writer.write(" ");
			writer.write(idDescuento);
			writer.write(" ");
			writer.write(idEstablecimiento);
			writer.newLine();
			writer.close();
		
	}
	@Override
	/**
	 * Se encarga de buscar las relaciones que tiene un usuario
	 * @param string id
	 * @return List<TRDescuentoEstablecimiento> 
	 */
	
	public List<TRDescuentoEstablecimiento> leerPorUsuario(String id) throws IOException {
		File archivo = new File("RelUsuDescEstab.txt");
		if(!archivo.exists()) archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		String linea;
		String lineaArray[];
		TDescuento tdescuento = null;
		TEstablecimiento testablecimiento = null;
		TRDescuentoEstablecimiento tDescEstab = null;
		List<TRDescuentoEstablecimiento> lista = new ArrayList<TRDescuentoEstablecimiento>();
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		
		DAODescuento desc = fact.getDAODescuento();
		
		DAOEstablecimiento estab = fact.getDAOEstablecimiento();
		
		
		while(sc.hasNext() ){
			//LEO LA SIGUIENTE LINEA
			linea = sc.nextLine();
			linea = linea.trim();
			lineaArray = linea.split(" ");
			/**COMPRUEBO QUE SEA IGUAL QUE EL <String id>  QUE BUSCAMOS*/
			if(lineaArray[0].equalsIgnoreCase(id)){
				
				tdescuento = desc.leerPorId(lineaArray[1]);/**buscamos <tdescuento>*/

				testablecimiento = estab.leerPorId(lineaArray[2]);/**buscamos <testablecimiento>*/
				
				/**solo si lo que estamos buscando es distinto de <null> o mejor dicho existen, lo a añadimos*/
				if(tdescuento != null && testablecimiento != null){
					tDescEstab = new TRDescuentoEstablecimiento(tdescuento, testablecimiento);
					if(!lista.contains(tDescEstab)){
						lista.add(tDescEstab);
					}
					
				}
				
			}
			
		}
		
	sc.close();
		return lista;
	}

	@Override
	/**
	 * @parama id
	 * Se encarga de borrar las relaciones del id
	 */
	public void borrarRelaciones(String id_usuario) throws NumberFormatException, IOException{
		String linea;
		String estabArray[];
		
		File archivo = new File("RelUsuDescEstab.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		archivo.renameTo(new File("RelUsuDescEstabAux.txt"));
		File archivoViejo = new File("RelUsuDescEstabAux.txt");			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			linea = sc.nextLine();
			linea = linea.trim();
			estabArray = linea.split(" ");
			
			if(!estabArray[0].equalsIgnoreCase(id_usuario)){
				insertar(estabArray[0], estabArray[1], estabArray[2]);/**inserto*/		
			}
		}	
		
		sc.close();
		archivoViejo.delete();
	}



	@Override
	public int borrarRelaciones(String id_usuario, String id_descuento, String id_establecimiento) throws NumberFormatException, IOException {
		String linea;
		String estabArray[];
		int n = 0;
		
		File archivo = new File("RelUsuDescEstab.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		archivo.renameTo(new File("RelUsuDescEstabAux.txt"));
		File archivoViejo = new File("RelUsuDescEstabAux.txt");			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			linea = sc.nextLine();
			linea = linea.trim();
			estabArray = linea.split(" ");
			
			//si no son iguales los inserta
			if(!estabArray[0].equalsIgnoreCase(id_usuario) || !estabArray[1].equalsIgnoreCase(id_descuento) || !estabArray[2].equalsIgnoreCase(id_establecimiento)){
				insertar(estabArray[0], estabArray[1], estabArray[2]);/**inserto*/		
			}
			else{
				n = 1;
			} 
		}	
		
		sc.close();
		archivoViejo.delete();
		return n;
	}

	@Override
	public int añadirRelacion(String Id_Usuario, String id_Descuento, String id_Establecimiento) throws IOException {
		List<TRDescuentoEstablecimiento> lista = this.leerPorUsuario(Id_Usuario);
		
		boolean encontrado = false;
		int k = 0;
		while(k < lista.size()){
			if(lista.get(k).getDescuento().getId().equalsIgnoreCase(id_Descuento) || 
					lista.get(k).getEstablecimiento().getId().equalsIgnoreCase(id_Establecimiento)) encontrado = true;
			else k++;
		}
		
		if(!encontrado){
			this.insertar(Id_Usuario, id_Descuento, id_Establecimiento);
			return 1;
		}
		return 0;
	
	}
}
