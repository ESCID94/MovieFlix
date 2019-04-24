package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionBBDD;
import model.User;

public class DAOUsuario<T> implements IDAO<T>{

	ConnectionBBDD connection = new ConnectionBBDD();
	PreparedStatement miStatement;
	
	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub	
	User u = (User) t; 
	
	miStatement = connection.getConnection().prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?)");
	miStatement.setInt(1, u.getIdUser());
	miStatement.setString(2, u.getNameUser());
	miStatement.setString(3, u.getLastName());
	miStatement.setString(4, u.getMail());
	miStatement.setInt(5, u.getBirthYear());
		
	}

	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alter(T t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	


}
