package model;

/**
 * The Class Catalog
 * @author Lucas
 */

public class Catalog {
	// public int idUser; (Ya es publico, no se necesita importar)
	public int idSubscription =0;
	private String idGenre;
	
	
	
	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Catalog(int idSubscription, String idGenre, String catalogName) {
		super();
		this.idSubscription = idSubscription;
		this.idGenre = idGenre;
		
	}


	public int getIdSubscription() {
		return idSubscription;
	}


	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}


	public String getIdGenre() {
		return idGenre;
	}


	public void setIdGenre(String idGenre) {
		this.idGenre = idGenre;
	}




	@Override
	public String toString() {
		return "Catalog [idSubscription=" + idSubscription + ", idGenre=" + idGenre + "]";
	}
	
	

}
