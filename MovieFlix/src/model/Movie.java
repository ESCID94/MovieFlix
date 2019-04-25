package model;


/**
 * The Class Movie
 * @author Lucas
 */

public class Movie {
	public int idMovie=0;
	private String name;
	private int date;
	public int idGenre=0;
	public int numWatchers=0;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(int idMovie, String name, int date, int idGenre, int numWatchers) {
		super();
		this.idMovie = idMovie;
		this.name = name;
		this.date = date;
		this.idGenre = idGenre;
		this.numWatchers = numWatchers;
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


	public int getIdGenre() {
		return idGenre;
	}


	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}


	public int getNumWatchers() {
		return numWatchers;
	}


	public void setNumWatchers(int numWatchers) {
		this.numWatchers = numWatchers;
	}


	@Override
	public String toString() {
		return "Movie [idMovie=" + idMovie + ", name=" + name + ", date=" + date + ", idGenre=" + idGenre
				+ ", numWatchers=" + numWatchers + "]";
	}

	
}
