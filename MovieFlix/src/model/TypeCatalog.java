package model;

public enum TypeCatalog {
	
	BASIC(1), 
	EXTRA(2),
	PREMIUM(3);
	
private final int ordinal; 
	
	private TypeCatalog(int ordinal) {
		this.ordinal = ordinal;
	}

	public int getOrdinal() {
		return ordinal;		
	}
	
	public static int exists(String nombre) {
		boolean encontrado = false;
		int num = -1;
		
		for(TypeCatalog t: TypeCatalog.values()) {
			if (t.toString().toUpperCase().contentEquals(nombre.toUpperCase())) {
				encontrado = true;
				num = t.getOrdinal();
			}
			
		}
		
		return num;
	}
	
	public static TypeCatalog whichTypeCatalog(int ordinal) {
		boolean encontrado = false;
		TypeCatalog type = null;
		
		for (TypeCatalog t: TypeCatalog.values()) {
			if (t.ordinal == ordinal) {
				type = t;
				encontrado = true;
			}
		}
		
		return type;
		
	}

	
}
