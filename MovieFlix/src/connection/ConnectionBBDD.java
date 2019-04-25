package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionBBDD.
 */
public class ConnectionBBDD {

	/** The connection. */
	private Connection connection = null;
	
	/** The url. */

	private String url = "jdbc:mysql://10.90.36.110:3306/movieflix?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	
	/** The user. */
	private String user = "root"; 
	
	/** The password. */
	private String password = "root";
	
	

	/**
	 * Instantiates a new connection BBDD.
	 */
	public ConnectionBBDD() {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			this.connection = createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates a new connection BBDD.
	 *
	 * @param connection the connection
	 * @param url the url
	 * @param user the user
	 * @param password the password
	 * @throws SQLException the SQL exception
	 */
	public ConnectionBBDD(Connection connection, String url, String user, String password) throws SQLException {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		
		try {
			this.connection = createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates the connection.
	 *
	 * @return the connection
	 * @throws SQLException the SQL exception
	 */
	private Connection createConnection() throws SQLException {
		return this.connection = DriverManager.getConnection(this.url, this.user, this.password);
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Sets the connection.
	 *
	 * @param connection the new connection
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConnectionBBDD [connection=" + connection + ", url=" + url + ", user=" + user + ", password=" + password
				+ "]";
	}
	
	


}
