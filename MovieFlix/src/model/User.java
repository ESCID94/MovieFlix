package model;

import java.sql.Time;

import utilities.LecturaDatos;

/**
 * @author Kike
 *
 */
public class User {
	private int idUser=0;
	private String nameUser;
	private String lastName;
	private String mail;
	private int birthYear;
	
	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
		idUser++;
	}

	/**
	 * 
	 * @param idUser
	 * @param nameUser
	 * @param lastName
	 * @param mail
	 * @param birthDate
	 */
	public User(int idUser, String nameUser, String lastName, String mail, int birthYear) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.lastName = lastName;
		this.mail = mail;
		this.birthYear = birthYear;
		idUser++;
		
	}
	
	/**
	 * 
	 * @return an Id of an User
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * 
	 * @param idUser
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return
	 */
	public String getNameUser() {
		return nameUser;
	}

	/**
	 * @param nameUser
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthDate
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", lastName=" + lastName + ", mail=" + mail
				+ ", birthYear=" + birthYear + "]";
	}
	public void createUser() {
		setNameUser(LecturaDatos.leerString("Introduce tu nombre:"));
		setLastName(LecturaDatos.leerString("Introduce tu apellido:"));
		setMail(LecturaDatos.leerString("Introduce tu email:"));
		setBirthYear(LecturaDatos.leerInt("Introduce tu año de nacimiento"));
	}
	public  void viewUser() {
		
	}

}
