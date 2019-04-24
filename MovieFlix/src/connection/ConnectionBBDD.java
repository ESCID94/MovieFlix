package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionBBDD {

	private Connection connection = null;
	private String url = "jdbc:mysql://10.90.36.110:3306/movieflix";
	private String user = "root"; 
	private String password = "root";
	
	public ConnectionBBDD() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConnectionBBDD(Connection connection, String url, String user, String password) throws SQLException {
		super();
		this.connection = DriverManager.getConnection(url, user, password);;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ConnectionBBDD [connection=" + connection + ", url=" + url + ", user=" + user + ", password=" + password
				+ "]";
	}
	
	


}
