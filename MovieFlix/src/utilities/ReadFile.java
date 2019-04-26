package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DAOMovie;
import model.Genre;
import model.Movie;

public class ReadFile {

	public static <T> ArrayList extractMoviesByCat(File file) throws SQLException{
		
		
		
		ArrayList lista = new ArrayList();
		
		
		 try
	     {
			 
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		

	     String fileRead = br.readLine();   
	     int counter = 0;
	     
	            while (fileRead != null)
	            {	
	            	
	            	
	                String[] tokenize = fileRead.split(",");
	                
	                String tempName = new String();
	       
	                
	                if (counter == 0) {
	                	tempName = tokenize[0].substring(1);}
	                
	                else tempName = tokenize[0];
	            	
	                String tempDate = tokenize[1];
	                String tempGenre = tokenize[2];
	                
	                Movie tempMovie = 	new Movie(tempName, Integer.parseInt(tempDate),Genre.whichGenre(Genre.exists(tempGenre)),0);

	                DAOMovie<T> dao = new DAOMovie<T>();
	                lista.add(tempMovie);
	                dao.add((T) tempMovie);
	                
	                fileRead = br.readLine();
	                counter++;
	            }


	            br.close();
	        }


	        catch (FileNotFoundException fnfe)
	        {
	            System.out.println("file not found");
	        }

	        catch (IOException ioe)
	        {
	            ioe.printStackTrace();
	        }


	        for (int i=0; i<lista.size();i++)
	        {
	            System.out.println(lista.get(i));
	            System.out.println();
	        }

		
		return null;		
		
	}
	
public static <T> ArrayList extractMoviesByNumCat(File file) throws SQLException{
		
		
		
		ArrayList lista = new ArrayList();
		
		
		 try
	     {
			 
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		

	     String fileRead = br.readLine();   
	     int counter = 0;
	     
	            while (fileRead != null)
	            {	
	            	
	            	
	                String[] tokenize = fileRead.split(",");
	                
	                String tempName = new String();
	       
	                
	                if (counter == 0) {
	                	tempName = tokenize[0].substring(1);}
	                
	                else tempName = tokenize[0];
	            	
	                String tempDate = tokenize[1];
	                String tempGenre = tokenize[2];
	                
	                Movie tempMovie = 	new Movie(tempName, Integer.parseInt(tempDate),Genre.whichGenre(Integer.parseInt(tempGenre)),0);

	                DAOMovie<T> dao = new DAOMovie<T>();
	                lista.add(tempMovie);
	                dao.add((T) tempMovie);
	                
	                fileRead = br.readLine();
	                counter++;
	            }


	            br.close();
	        }


	        catch (FileNotFoundException fnfe)
	        {
	            System.out.println("file not found");
	        }

	        catch (IOException ioe)
	        {
	            ioe.printStackTrace();
	        }


	        for (int i=0; i<lista.size();i++)
	        {
	            System.out.println(lista.get(i));
	            System.out.println();
	        }

		
		return null;		
		
	}
	
}
