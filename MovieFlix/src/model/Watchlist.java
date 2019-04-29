package model;

import java.util.ArrayList;

/**
 * The class Watchlist
 * @author Lucas
 *
 */

public class Watchlist {
	private int idUser;
	private int idMovie;
	/**
	 * ArrayList de Movie
	 */
	private ArrayList <Movie> movieList = new ArrayList <Movie>();
	/**
	 *  Métodos Watchlist
	 */
	public Watchlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Watchlist(int idUser, ArrayList<Movie> movieList) {
		super();
		this.idUser = idUser;
		this.movieList = movieList;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Watchlist [idUser=" + idUser + ", idMovie=" + idMovie + ", movieList=" + movieList + "]";
	}

	public void createWatchList() {
		// TODO Auto-generated method stub
		
	}

	public void deleteWatchlist() {
		// TODO Auto-generated method stub
		
	}

	public void updateWatchlist(Watchlist t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
