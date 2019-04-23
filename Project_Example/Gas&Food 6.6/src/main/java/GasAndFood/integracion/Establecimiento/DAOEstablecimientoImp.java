package GasAndFood.integracion.Establecimiento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TREstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;




public class DAOEstablecimientoImp  implements DAOEstablecimiento{

	//id nombre dir cp activo tipo
	//0  1      2    3   4     5
	/**
	 * Metodo que introduce el establecimiento ,que se pasa como parametro , dentro del fichero "Establecimientos.txt".
	 * Comprueba que el archivo exista y si existe escribe cada dato del establecimiento dentro del fichero.
	 */
	public void insertar(TEstablecimiento TEstablecimiento) throws IOException {
		File archivo = new File("Establecimientos.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		String activo = "0"; 
		 
		if(archivo.exists()) {
		
			writer.write(TEstablecimiento.getId());
			writer.write(" ");
			writer.write(TEstablecimiento.getNombre());
			writer.write(" ");
			writer.write(TEstablecimiento.getDireccion());
			writer.write(" ");
			writer.write(TEstablecimiento.getCP());
			writer.write(" ");
			if(TEstablecimiento.getActivo()) activo = "1";
			writer.write(activo);
			writer.write(" ");
			writer.write(TEstablecimiento.getTipo().toString());
			writer.newLine();
		} 
		writer.close();
	}
	
	private void insertar(String idEst, String idProd, float precio, int descuento, String tipo) throws IOException {
		File archivo;
		
		if(tipo.equalsIgnoreCase("alimento"))  archivo = new File("RelEstProd.txt");
		else if(tipo.equalsIgnoreCase("gasolina"))  archivo = new File("RelEstGas.txt");
		else return;
		
		BufferedWriter writer;
		if(!archivo.exists()) 	archivo.createNewFile();

		writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		 
		if(archivo.exists()) {
		
			writer.write(idEst);
			writer.write(" ");
			writer.write(idProd);
			writer.write(" ");
			writer.write(Float.toString(precio));
			writer.write(" ");
			writer.write( Integer.toString(descuento));
			writer.newLine();
		} 
		writer.close();
	}
	
	/**
	 * Metodo que comprueba cual es el ultimo ID del fichero y que calcula el siguiente ID a partir de este.
	 * Lo devuelve como un String para escribirlo directamente.
	 * @return El siguiente ID de tipo string.
	 * @throws IOException 
	 */
	public String siguienteIdAux() throws IOException{
		 String idFinal = " ";
		 String linea;
		 String estabArray[];
		 
		 File est =new File("Establecimientos.txt");
		 if(!est.exists()) 	est.createNewFile();
	     
	     Scanner sc = new Scanner(est); 
	     
	     while(sc.hasNext()) {
	           //para quedarnos con el idFinal, los lee todos y al salir se queda con el ultimo id.
	    	 linea = sc.nextLine();
	    	 estabArray = linea.split(" ");
	    	 idFinal = estabArray[0];	
	     }
	    sc.close();
	    if(idFinal.equalsIgnoreCase(" ")) return "0";
	    else{
	    	   	int id = Integer.parseInt(idFinal) + 1;
	    	   	return Integer.toString(id);
	       	}
	}
	
	
	/**
	 * lee los establecimientos del archivo hasta encontrar el que coincida con los parametros de entrada: <id>
	 * @param establecimiento
	 * @param estabArray
	 * @param encontrado
	 * @param actAux
	 * @param act
	 * @param sc
	 * @return
	 * @throws IOException 
	 */		
	
	public TEstablecimiento leerPorId(String id) throws IOException {
		
		File archivo = new File("Establecimientos.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		
		String establecimiento;
		String estabArray[];
		TEstablecimiento tEstab  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el id del establecimento recibido por parametro coincide con el del archivo*/
			if(estabArray[0].equalsIgnoreCase(""+id)){
				
				encontrado = true;
				
				if(estabArray[4].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2], estabArray[3], act,
						TipoEstablecimiento.stringToEnum(estabArray[5]));
			}
			
			
		}
		
		sc.close();
		return  tEstab;
	}
	
	/**
	 * lee los establecimientos del archivo hasta encontrar el que coincida con los parametros de entrada: <nombre> <dir>
	 * @param establecimiento
	 * @param estabArray
	 * @param encontrado
	 * @param actAux
	 * @param act
	 * @param sc
	 * @return
	 * @throws IOException 
	 */
	
	public TEstablecimiento leerPorNombre(String nombre, String dir) throws IOException {
		/**accedemos al fichero*/
		File archivo = new File("Establecimientos.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		String  establecimiento;
		String estabArray[];
		TEstablecimiento tEstab  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(estabArray[1].equalsIgnoreCase(nombre) && estabArray[2].equalsIgnoreCase(dir)){
				
				encontrado = true;
				
				if(estabArray[4].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2], estabArray[3], act,
						TipoEstablecimiento.stringToEnum(estabArray[5]));
			}
			
			
		}
		
		sc.close();
		return  tEstab;
	}
	


	public List<TEstablecimiento> readAll() throws IOException{
		
		List<TEstablecimiento> establecimientos = new ArrayList<TEstablecimiento>();
	
		String  establecimiento;
		String estabArray[];
		TEstablecimiento tEstab  = null;
		boolean act;
		
		File archivo = new File("Establecimientos.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		//Falta el throw
		while(sc.hasNext()){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(estabArray[4].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
			else act = false;/**si no creo @boolean a <false>*/
			
			tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2], estabArray[3], act, TipoEstablecimiento.stringToEnum(estabArray[5]));
			establecimientos.add(tEstab);
		}

		
		sc.close();
		return  establecimientos;
	}

	public int modificar(String id, boolean activo, TipoEstablecimiento tipo) throws IOException{
		String datos;
		String estabArray[];
		int ret = 0;
		int actAux;
		boolean act;
		
		
		File archivo =new File("Establecimientos.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		
		
		archivo.renameTo(new File("EstablecimientoAux.txt"));
		File archivoViejo = new File("EstablecimientoAux.txt");	
		
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			
			
			datos = sc.nextLine();
			
			estabArray = datos.split(" ");
			
			if(estabArray[0].equalsIgnoreCase(id)){
				/**si encuentro el establecimiento a modificar -> modifico*/
				TEstablecimiento tEstab = new TEstablecimiento(id, estabArray[1],
						estabArray[2], estabArray[3], activo, tipo);
				insertar(tEstab);/**inserto*/
				ret = 1;/**nos indica que se ha modificado el archivo*/
			}else {
				/**si no -> no modifico*/
				actAux = Integer.parseInt(estabArray[4]);
				if(actAux == 1) act = true;/**activo o no el establecimiento*/
				else act = false;
				TEstablecimiento tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2] , 
						estabArray[3], act, TipoEstablecimiento.stringToEnum(estabArray[5]));
				insertar(tEstab);/**inserto*/
			}
		}	
		
		sc.close();
		archivoViejo.delete();
		return ret;
	}

	@Override
	public List<TREstablecimiento> leerPorProducto(String id, String tipo) throws IOException {// ID Est, ID Prod, Precio, Descuento
		 File archivo;
		
		 List<TREstablecimiento>  aMostrar = new ArrayList<TREstablecimiento>();
		 
		 
		if(tipo.equalsIgnoreCase("alimento"))  {
			archivo = new File("RelEstProd.txt");
			if(!archivo.exists()) 	archivo.createNewFile();
		}
		else if(tipo.equalsIgnoreCase("gasolina")) {
			archivo = new File("RelEstGas.txt");
			if(!archivo.exists()) 	archivo.createNewFile();
		}
		else return aMostrar;
		
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		String  establecimiento;
		String estabArray[];
		TEstablecimiento tEstab = null;
		TREstablecimiento tREstab  = null;
		
		
		
		
		while(sc.hasNext() ){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(estabArray[1].equalsIgnoreCase(id)){
				tEstab = leerPorId(estabArray[0]);			
				tREstab = new TREstablecimiento(tEstab, Float.parseFloat(estabArray[2]), Integer.parseInt(estabArray[3]));
				aMostrar.add(tREstab);
			}
			
			
		}
		
		sc.close();
		return  aMostrar;
		}
	
	
	
	public void borrarRelacionesEstablecimientos(String id) throws NumberFormatException, IOException{
		String datos;
		String estabArray[];
		
		File archivo = new File("RelEstProd.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		archivo.renameTo(new File("RelEstProdAux.txt"));
		File archivoViejo = new File("RelEstProdAux.txt");			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			datos = sc.nextLine();
			
			estabArray = datos.split(" ");
			
			if(!estabArray[0].equalsIgnoreCase(id)){
				insertar(estabArray[0], estabArray[1], Float.parseFloat(estabArray[2]), Integer.parseInt(estabArray[3]), "Alimento");/**inserto*/		
			}
		}	
		
		sc.close();
		archivoViejo.delete();
		
		File archivo1 = new File("RelEstGas.txt");
		if(!archivo1.exists()) 	archivo1.createNewFile();
		archivo1.renameTo(new File("RelEstGasAux.txt"));
		File archivoViejo1 = new File("RelEstGasAux.txt");			
		Scanner sc1 = new Scanner(archivoViejo1);  
		
		while(sc1.hasNext()){
			datos = sc1.nextLine();
			
			estabArray = datos.split(" ");
			
			if(!estabArray[0].equalsIgnoreCase(id)){
				insertar(estabArray[0], estabArray[1], Float.parseFloat(estabArray[2]), Integer.parseInt(estabArray[3]), "Gasolina");/**inserto*/		
			}
		}	
		
		sc1.close();
		archivoViejo1.delete();
	}
	
	public int borrarRelacionesProducto(String id1, String id2, String tipo) throws NumberFormatException, IOException{
		
		File archivo;
		String dirAux;
		 
		 
		if(tipo.equalsIgnoreCase("alimento"))  {
			archivo = new File("RelEstProd.txt");
			if(!archivo.exists()) 	archivo.createNewFile();
			dirAux = "RelEstProdAux.txt";
		}
		else if(tipo.equalsIgnoreCase("gasolina"))  {
			archivo = new File("RelEstGas.txt");
			if(!archivo.exists()) 	archivo.createNewFile();
			dirAux = "RelEstGasAux.txt";
		}
		else return 0;
		
		String datos;
		String estabArray[];
		int n = 0;
		
		archivo.renameTo(new File(dirAux));
		File archivoViejo = new File(dirAux);			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			
			
			datos = sc.nextLine();
			
			estabArray = datos.split(" ");
			
			if(!estabArray[0].equalsIgnoreCase(id1) || !estabArray[1].equalsIgnoreCase(id2)){
				insertar(estabArray[0], estabArray[1], Float.parseFloat(estabArray[2]), Integer.parseInt(estabArray[3]), tipo);/**inserto*/

						
			}
			else {
				n = 1;
			}

		}	
		
		sc.close();
		archivoViejo.delete();
		return n;
	}
	
	
	
	public int añadirRelacion(String id1, String id2, float precio, int descuento, String tipo) throws IOException{
		
		
		
		
		List<TREstablecimiento> list = this.leerPorProducto(id2, tipo);
		boolean encontrado = false;
		int k = 0;
		
		
		while(k < list.size() && !encontrado){
			if(list.get(k).getEstablecimiento().getId().equalsIgnoreCase(id1)) encontrado = true;
			else k++;
		}
		
		if(!encontrado){
			this.insertar(id1, id2, precio, descuento, tipo);
			return 1;
		}
		else return 0;
		
	}
	

	public void borrarRelacionesProducto(String id, String tipo) throws NumberFormatException, IOException{
		String datos;
		String estabArray[];
		
		File archivo;
		String dirAux;
		 
		 
		if(tipo.equalsIgnoreCase("alimento"))  {
			archivo = new File("RelEstProd.txt");
			if(!archivo.exists()) 	archivo.createNewFile();
			dirAux = "RelEstProdAux.txt";
		}
		else if(tipo.equalsIgnoreCase("gasolina"))  {
			archivo = new File("RelEstGas.txt");
			if(!archivo.exists()) 	archivo.createNewFile();
			dirAux = "RelEstGasAux.txt";
		}
		else return;
		
		archivo.renameTo(new File(dirAux));
		File archivoViejo = new File(dirAux);			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			datos = sc.nextLine();
			
			estabArray = datos.split(" ");
			
			if(!estabArray[1].equalsIgnoreCase(id)){
				insertar(estabArray[0], estabArray[1], Float.parseFloat(estabArray[2]), Integer.parseInt(estabArray[3]), tipo);/**inserto*/		
			}
		}	
		
		sc.close();
		archivoViejo.delete();
	}

	@Override
	public void borrarRelacionesDescUsu(String id_establecimiento) throws IOException {
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
			
			if(!estabArray[2].equalsIgnoreCase(id_establecimiento)){
				insertar(estabArray[0], estabArray[1], estabArray[2]);/**inserto*/			
			}
		}	
		
		sc.close();
		archivoViejo.delete();
	}

	public void insertar(String idUsuario, String idDescuento, String idEstablecimiento) throws IOException {
		File archivo = new File("RelUsuDescEstab.txt");
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
	

	
}
