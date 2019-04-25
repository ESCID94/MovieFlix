package model;

import java.sql.Time;
import java.util.Random;

import utilities.LecturaDatos;
import utilities.Operations;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 *
 * @author Kike
 */
public class User {

	/** The id user. */
	public int idUser = 0;

	/** The name user. */
	private String nameUser;

	/** The last name. */
	private String lastName;

	/** The mail. */
	private String mail;

	/** The birth year. */
	private int birthYear;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
		createRandomId();
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param idUser    the id user
	 * @param nameUser  the name user
	 * @param lastName  the last name
	 * @param mail      the mail
	 * @param birthYear the birth year
	 */
	public User(int idUser, String nameUser, String lastName, String mail, int birthYear) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.lastName = lastName;
		this.mail = mail;
		this.birthYear = birthYear;
		createRandomId();

	}

	/**
	 * Creates the random id.
	 */
	private void createRandomId() {
		// TODO Auto-generated method stub
		this.idUser = (int) (Math.random() * 1000 + 1);
	}

	/**
	 * Gets the id user.
	 *
	 * @return an Id of an User
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * Sets the id user.
	 *
	 * @param idUser the new id user
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * Gets the name user.
	 *
	 * @return the name user
	 */
	public String getNameUser() {
		return nameUser;
	}

	/**
	 * Sets the name user.
	 *
	 * @param nameUser the new name user
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 *
	 * @param mail the new mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets the birth year.
	 *
	 * @return the birth year
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * Sets the birth year.
	 *
	 * @param birthYear the new birth year
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", lastName=" + lastName + ", mail=" + mail
				+ ", birthYear=" + birthYear + "]";
	}

	/**
	 * Creates the user.
	 */
	public void createUser() {
	
		if (!Operations.exists(this.idUser, "users")) {

			setNameUser(LecturaDatos.leerString("Introduce tu nombre:"));
			setLastName(LecturaDatos.leerString("Introduce tu apellido:"));
			setMail(LecturaDatos.leerString("Introduce tu email:"));
			setBirthYear(LecturaDatos.leerInt("Introduce tu año de nacimiento"));
		} else
			System.out.println("Usuario" + this.idUser + " ya existe");

	}

	public void deleteAccount() {
		try {
			setNameUser(LecturaDatos.leerString("Introduce tu nombre:"));
			setLastName(LecturaDatos.leerString("Introduce tu apellido:"));
		} catch (Exception e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}
	}
	

	/**
	 * View user.
	 */
	public void viewUser() {

	}

}
