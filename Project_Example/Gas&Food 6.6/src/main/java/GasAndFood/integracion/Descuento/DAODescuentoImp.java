package GasAndFood.integracion.Descuento;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TipoDescuento;

public class DAODescuentoImp implements DAODescuento{
	
	/**
	 * Metodo que inserta un descuento en el fichero de descuentos " Descuentos.txt ".
	 * @param tDescuento, variable de tipo TDescuento , que contiene el descuento que queremos insertar.
	 */
	public void insertar(TDescuento tDescuento) throws IOException {
		File archivo = new File("Descuentos.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		BufferedWriter bufferDescuentos = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		String activo = "0"; 
		 
		if(archivo.exists()) {
			bufferDescuentos.write(tDescuento.getId());
			bufferDescuentos.write(" ");
			if(tDescuento.getActivo()) {activo = "1";}
			bufferDescuentos.write(activo);
			bufferDescuentos.write(" ");
			bufferDescuentos.write(tDescuento.getTipo().toString());
			bufferDescuentos.newLine();
			bufferDescuentos.close();
		} 
		bufferDescuentos.close();
	}
	
	/**
	 * Metodo busca un descuento por id, y lo devuelve.
	 * @param id, variable de tipo String que contiene el id del descuento que queremos buscar.
	 * @return tDes, variable de tipo tDescuento , que contiene el descuento o devuelve un null si no ha sido encontrado.
	 * @throws IOException 
	 */
	public TDescuento leerPorId(String id_descuento) throws IOException {
		File archivo = new File("Descuentos.txt");
		if(!archivo.exists()) archivo.createNewFile();
		Scanner sc = new Scanner(archivo);   
		
		String descuento;
		String descuentos[];
		TDescuento tDes  = null;
		boolean encontrado = false, activo;
		
		while(sc.hasNext() && !encontrado){
			
			descuento = sc.nextLine();
			descuento = descuento.trim();
			descuentos = descuento.split(" ");
			//si el id del leerPorID recibido por parametro coincide con el del archivo
			if(descuentos[0].equalsIgnoreCase(""+id_descuento)){
				encontrado = true;
				
				if(descuentos[1].equalsIgnoreCase("1")) 
					activo = true; // si el elemento uno del array descuentos tiene el valor de 1, entonces el descuento esta activo.
				else 
					activo = false; // en caso contrario false.
				tDes = new TDescuento(descuentos[0],TipoDescuento.stringToEnum(descuentos[2]),activo);
			}
			
		}
		
		sc.close();
		return tDes;
	}
	
	
	/**
	 * Metodo que modifica un descuento del fichero de descuentos. 
	 * Si el descuento no existe , entonces se carga en la lista de descuentos.
	 * @param id , variable de tipo String que contiene el identificador del descuento.
	 * @param activo, variable booleana , que indica si un descuento esta activo o no.
	 * @param tipo, variable de tipo enumerado que contiene el descuento a a aplicar.
	 * @return 0 , si el descuento se ha cargado por primera vez, 1 , si solo se ha modificado.
	 */
	public int modificar(String id, boolean activo, TipoDescuento tipo) throws IOException {
        
        int ret = 0;
        String descuentos[];
                      
        File archivo = new File("Descuentos.txt");                      
        if(!archivo.exists())        archivo.createNewFile();
        StringBuffer inputBuffer = new StringBuffer();
        String line;
        BufferedReader file = new BufferedReader(new FileReader("Descuentos.txt"));
       
        while ((line = file.readLine()) != null) {
                       descuentos = line.split(" ");
                       if(descuentos[0].equalsIgnoreCase(id)){
                                     String act = "0";
                                     TDescuento tDes = new TDescuento(id,tipo,activo);
                                     if(tDes.getActivo()) {act = "1";}
                                     line = tDes.getId() + " " + act + " " + tDes.getTipo().toString();
                                     ret = 1;
                       }
                       inputBuffer.append(line);
                       inputBuffer.append(System.getProperty("line.separator"));
        }
       
        String inputStr = inputBuffer.toString();
        file.close();


        FileOutputStream fileOut = new FileOutputStream("Descuentos.txt");
        fileOut.write(inputStr.getBytes());
        fileOut.close();

        return ret;
	}
	
	/**
	 * Metodo que devuelve una lista con todos los descuentos ,estando activos o no.
	 * @return la lista de descuentos.
	 * @throws IOException 
	 */
	public List<TDescuento> readAll() throws IOException {
		List<TDescuento> descuentos = new ArrayList<TDescuento>();
		
		String descuento;
		String descuentitos[];
		TDescuento tDes  = null;
		boolean act;
		
		File archivo = new File("Descuentos.txt");
		if(!archivo.exists()) archivo.createNewFile();
		
		Scanner sc = new Scanner(archivo);
		
		while(sc.hasNext()){
			
			descuento = sc.nextLine();
			descuento = descuento.trim();
			descuentitos = descuento.split(" ");
			
			if(descuentitos[1].equalsIgnoreCase("1")) 
				act = true;/**si esta activo creo el @boolean a <true>*/
			else 
				act = false;/**si no creo @boolean a <false>*/
			
			tDes = new TDescuento(descuentitos[0],TipoDescuento.stringToEnum(descuentitos[2]),act);
			descuentos.add(tDes);
		}
		sc.close();
		return descuentos;
	}
	
	// funcion que extrae el ultimo id , para poder generar un nuevo id a partir del ultimo cargado
	//n no seria mas eficiiente empezar a leer por el final y seleccionar le primer id ??
	
	/**
	 * Metodo que devuelve el siguiente valor del  ultimo Id del fichero de descuentos.
	 * @return idNuevo, variable de tipo String que contiene el nuevo id.
	 * @throws IOException 
	 */
	public String siguienteIdAux() throws IOException {
		 String idFinal = " ";
		 String descuento;
		 String descuentos[];
		 
		 File archivo = new File("Descuentos.txt");
			if(!archivo.exists()){
				archivo.createNewFile();
			}
			Scanner sc = new Scanner(archivo);
			
	     while(sc.hasNext()) {
	    	 descuento = sc.nextLine();
	    	 descuentos = descuento.split(" ");
	    	 idFinal = descuentos[0];	
	     }
	    sc.close();
	        
	    if(idFinal.equalsIgnoreCase(" ")) return "0";
	    else{
	    	   	int id = Integer.parseInt(idFinal) + 1;
	    	   	return Integer.toString(id);
	       	}
	}
	@Override
	public void borrarRelacionesDescUsu(String id_descuento) throws IOException {
		String datos;
		String estabArray[];
		
		File archivo = new File("RelUsuDescEstab.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		archivo.renameTo(new File("RelUsuDescEstabAux.txt"));
		File archivoViejo = new File("RelUsuDescEstabAux.txt");			
		Scanner sc = new Scanner(archivoViejo); 
		
		while(sc.hasNext()){
			datos = sc.nextLine();
			datos = datos.trim();
			estabArray = datos.split(" ");
			
			if(!estabArray[1].equalsIgnoreCase(id_descuento)){
				insertar(estabArray[0], estabArray[1], estabArray[2]);/**inserto*/			
			}
		}	
		
		sc.close();
		archivoViejo.delete();
	}

	public void insertar(String idUsuario, String idDescuento, String idEstablecimiento) throws IOException {
		File archivo = new File("RelUsuDescEstab.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		 
		
		if(archivo.exists()) {
			archivo.createNewFile();
		
			writer.write(idUsuario);
			writer.write(" ");
			writer.write(idDescuento);
			writer.write(" ");
			writer.write(idEstablecimiento);
			writer.newLine();
			
		}
		writer.close();
	}
}
