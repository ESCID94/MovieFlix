package model;

import utilities.LecturaDatos;
import utilities.Operations;

public class Subscription {
	
	public int idSubscription=0; 
	public int idUser;
	public int fee;
	public String typePayment;
	public TypeCatalog type; 
	
	
	public Subscription () {
		super();
		this.createRandomIdSubscription();
	}
	
	public Subscription(int idSubscription, int idUser, int fee, String typePayment, TypeCatalog type) {
		super();
		this.idSubscription = idSubscription;
		this.idUser = idUser;
		this.fee = fee;
		this.typePayment = typePayment;
		this.type = type;
	}
	
	/**
	 * Creates the random id.
	 */
	public void createRandomIdSubscription() {
		// TODO Auto-generated method stub
		this.idSubscription = (int) (Math.random() * 1000 + 1);
	}

	public int getIdSubscription() {
		return idSubscription;
	}

	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	public TypeCatalog getType() {
		return type;
	}

	public void setType(TypeCatalog type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Subscription [idSubscription=" + idSubscription + ", idUser=" + idUser + ", fee=" + fee
				+ ", typePayment=" + typePayment + ", type=" + type + "]";
	}

	
	/**
	 * Creates the subscription.
	 */
	public void createSubscription() {
		
		if (!Operations.exists(this.idSubscription, "subscription")) {

			this.setIdUser(LecturaDatos.leerInt("Introduce el id de usuario: "));
			this.setFee(LecturaDatos.leerInt("Introduce el fee: "));
			this.setTypePayment(LecturaDatos.leerString("Introduce el tipo de pago: "));
			int type = TypeCatalog.exists(LecturaDatos.leerString("Introduce el tipo de catálogo: "));
			//Meter excepcion TypeCatalogException
			if (type == -1) {
				System.out.println("Tipo de catálogo erróneo ");
			}
			
			else this.setType(TypeCatalog.whichTypeCatalog(type));
			
		} else {
			System.out.println("Subscription" + this.idSubscription + " ya existe");
		}
	
		
	}
	
	

}
