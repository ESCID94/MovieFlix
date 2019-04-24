package model;

import java.sql.Time;

/**
 * @author Kike
 *
 */
public class User {
	private int idUser;
	private String nameUser;
	private String lastName;
	private String mail;
	private Time birthDate;

	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param idUser
	 * @param nameUser
	 * @param lastName
	 * @param mail
	 * @param birthDate
	 */
	public User(int idUser, String nameUser, String lastName, String mail, Time birthDate) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.lastName = lastName;
		this.mail = mail;
		this.birthDate = birthDate;
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
	public Time getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 */
	public void setBirthDate(Time birthDate) {
		this.birthDate = birthDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", lastName=" + lastName + ", mail=" + mail
				+ ", birthDate=" + birthDate + "]";
	}

}
