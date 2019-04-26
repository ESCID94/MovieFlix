package model;

import utilities.ReadData;
import utilities.Operations;

/**
 * The Class Movie
 * @author Lucas
 */

public class Movie {
	public int idMovie=0;
	private String name;
	private int date;
	public Genre genre;
	public int numWatchers=0;
	
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
		this.createRandomIdMovie();
	}


	public Movie(String name, int date, int numWatchers) {
		super();
		this.name = name;
		this.date = date;
		this.numWatchers = numWatchers;
		this.createRandomIdMovie();
	}




	public Movie(String name, int date, Genre genre, int numWatchers) {
		super();
		this.name = name;
		this.date = date;
		this.genre = genre;
		this.numWatchers = numWatchers;
		this.createRandomIdMovie();
	}


	/**
	 * Creates the random id.
	 */
	public void createRandomIdMovie() {
		// TODO Auto-generated method stub
		
		while (Operations.exists(this.idMovie, "movies")) this.idMovie = (int) (Math.random() * 1000 + 1);
		
	}
	
	

	public int getIdMovie() {
		return idMovie;
	}


	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}



	public int getNumWatchers() {
		return numWatchers;
	}


	public void setNumWatchers(int numWatchers) {
		this.numWatchers = numWatchers;
	}


	
	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return "Movie [idMovie=" + idMovie + ", name=" + name + ", date=" + date + ", genre=" + genre + ", numWatchers="
				+ numWatchers + "]";
	}


	/**
	 * Creates the movie.
	 */
	public void createMovie() {
		
		if (!Operations.exists(this.idMovie, "movies")) {

			this.setName(ReadData.leerString("Introduce el nombre de la película:"));
			this.setDate(ReadData.leerInt("Introduce el año de la película"));
			int genre = Genre.exists(ReadData.leerString("Introduce el nombre de la categoria:"));
			//Meter excepcion GenreException
			if (genre == -1) {
				System.out.println("Categoria erronea");
			}
			else this.setGenre(Genre.whichGenre(genre));
			
		} else {
			System.out.println("Movie" + this.idMovie + " ya existe");
		}
	}

}
