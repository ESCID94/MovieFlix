package model;

public enum Genre {
	POLICIACA(1), 
	ROMANTICA(2), 
	AVENTURAS(3), 
	COMEDIA(4), 
	ANIMACION(5), 
	THRILLER(6);

	private final int ordinal; 
	
	private Genre(int ordinal) {
		this.ordinal = ordinal;
	}

	public int getOrdinal() {
		return ordinal;		
	}
	
	public static int exists(String nombre) {
		boolean encontrado = false;
		int num = -1;
		
		for(Genre g: Genre.values()) {
			if (g.toString().toUpperCase().contentEquals(nombre.toUpperCase())) {
				encontrado = true;
				num = g.getOrdinal();
			}
			
		}
		
		
		
		return num;
	}
	
	public static Genre whichGenre(int ordinal) {
		boolean encontrado = false;
		Genre genre = null;
		
		for (Genre g: Genre.values()) {
			if (g.ordinal == ordinal) {
				genre = g;
				encontrado = true;
			}
		}
		
		return genre;
		
	}
	
}
