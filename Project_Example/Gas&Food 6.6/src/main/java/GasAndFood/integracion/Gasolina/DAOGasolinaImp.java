package GasAndFood.integracion.Gasolina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TRGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;

public class DAOGasolinaImp implements DAOGasolina {

	@Override
	public void insertar(TGasolina tGasolina) throws IOException {
		File archivo = new File("Gasolina.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		String activo = "0"; 
		 
		if(archivo.exists()) {
		
			writer.write(tGasolina.getId());
			writer.write(" ");
			writer.write(tGasolina.getNombre());
			writer.write(" ");
			if(tGasolina.getActivo()) activo = "1";
			writer.write(activo);
			writer.write(" ");
			writer.write(tGasolina.getTipo().toString());
			writer.newLine();
		} 
		writer.close();
		
	}

	@Override
	public TGasolina leerPorId(String id) throws IOException {
		File archivo = new File("Gasolina.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		String gasolina;
		String gasArray[];
		TGasolina tGas  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			gasolina = sc.nextLine();
			
			gasArray = gasolina.split(" ");
			/**si el id del establecimento recibido por parametro coincide con el del archivo*/
			if(gasArray[0].equalsIgnoreCase(""+id)){
				
				encontrado = true;
				
				if(gasArray[2].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tGas = new TGasolina(gasArray[0], gasArray[1], act, TipoGasolina.stringToEnum(gasArray[3]));
				//parseo de string a enum alimArray[3].
			}
			
		}
		
		sc.close();
		return  tGas;
	}

	@Override
	public TGasolina leerPorNombre(String nombre) throws IOException {
		File archivo = new File("Gasolina.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		String gasolina;
		String gasArray[];
		TGasolina tGas  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			gasolina = sc.nextLine();
			
			gasArray = gasolina.split(" ");
			/**si el id del establecimento recibido por parametro coincide con el del archivo*/
			if(gasArray[1].equalsIgnoreCase(""+nombre)){
				
				encontrado = true;
				
				if(gasArray[2].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tGas = new TGasolina(gasArray[0], gasArray[1], act, TipoGasolina.stringToEnum(gasArray[3]));
				//parseo de string a enum alimArray[3].
			}
			
		}
		
		sc.close();
		return  tGas;
	}

	@Override
	public int modificar(String id, boolean activo,String nombreGas,TipoGasolina tipo)throws IOException {
		String datos;
		String gasArray[];
		int ret = 0;
		int actAux;
		boolean act;
		
		File archivo = new File("Gasolina.txt");
		archivo.renameTo(new File("GasolinaAux.txt"));
		File archivoViejo = new File("GasolinaAux.txt");			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			
			datos = sc.nextLine();
			
			gasArray = datos.split(" ");
			
			if(gasArray[0].equalsIgnoreCase(id)){
				/**si encuentro el establecimiento a modificar -> modifico*/
				TGasolina tGas = new TGasolina(id, nombreGas, activo, tipo);
				insertar(tGas);/**inserto*/
				ret = 1;/**nos indica que se ha modificado el archivo*/
				
			}else {
				/**si no -> no modifico*/
				actAux = Integer.parseInt(gasArray[2]);
				if(actAux == 1) act = true;/**activo o no el establecimiento*/
				else act = false;
				TGasolina tGas = new TGasolina(gasArray[0], gasArray[1], act, TipoGasolina.stringToEnum(gasArray[3]));
				insertar(tGas);/**inserto*/
			}
		}	
		
		sc.close();
		archivoViejo.delete();
		return ret;
	}

	@Override
	public List<TGasolina> readAll() throws IOException {
		List<TGasolina> gasolinas = new ArrayList<TGasolina>();
		
		String gasolina;
		String gasArray[];
		TGasolina tGas  = null;
		boolean act;
		
		File archivo = new File("Gasolina.txt");
		if(!archivo.exists()) archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		while(sc.hasNext()){
			
			gasolina = sc.nextLine();
			
			gasArray = gasolina.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(gasArray[2].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
			else act = false;/**si no creo @boolean a <false>*/
			
			tGas = new TGasolina(gasArray[0], gasArray[1], act, TipoGasolina.stringToEnum(gasArray[3]));
			gasolinas.add(tGas);
		}

		
		sc.close();
		return  gasolinas;
	}

	@Override
	public String siguienteIdAux() throws IOException {
		String idFinal = " ";
		String linea;
		String gasArray[];
	     
		File archivo = new File("Gasolina.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);	     
	    while(sc.hasNext()) {
	           //para quedarnos con el idFinal, los lee todos y al salir se queda con el ultimo id.
	    	 linea = sc.nextLine();
	    	 gasArray = linea.split(" ");
	    	 idFinal = gasArray[0];	
	     }
	    sc.close();
	        
	    if(idFinal.equalsIgnoreCase(" ")) return "0";
	    else{
	    	   	int id = Integer.parseInt(idFinal) + 1;
	    	   	return Integer.toString(id);
	       	}
		
	}

	@Override
	public List<TRGasolina> leerPorEstablecimiento(String idEst) throws IOException {
		File archivo = new File("RelEstGas.txt");
		if(!archivo.exists()) 	archivo.createNewFile();
		Scanner sc = new Scanner(archivo);
		
		String establecimiento;
		String estabArray[];
		TGasolina tGas = null;
		TRGasolina tRGas = null;
		List<TRGasolina> aMostrar = new ArrayList<TRGasolina>();
		
		while(sc.hasNext()){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(estabArray[0].equalsIgnoreCase(idEst)){
				tGas = leerPorId(estabArray[1]);			
				tRGas = new TRGasolina(tGas, Float.parseFloat(estabArray[2]), Integer.parseInt(estabArray[3]));
				aMostrar.add(tRGas);
			}
		}
		
		sc.close();
		return  aMostrar;
	}
}
