package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionBBDD;
import model.User;

public class DAOUser<T> implements IDAO<T> {

	ConnectionBBDD connection = new ConnectionBBDD();
	PreparedStatement miStatement;

	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub
		try {
			User u = (User) t;
			miStatement = connection.getConnection().prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?)");
			miStatement.setInt(1, u.getIdUser());
			miStatement.setString(2, u.getNameUser());
			miStatement.setString(3, u.getLastName());
			miStatement.setString(4, u.getMail());
			miStatement.setInt(5, u.getBirthYear());
			miStatement.executeUpdate();
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOUser.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (miStatement != null) {
					miStatement.close();
				}
				if (connection != null) {
					connection.getConnection().close();
				}
			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DAOUser.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}

	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub
		try {
			User u = (User) t;
			miStatement = connection.getConnection().prepareStatement("DELETE FROM USERS WHERE IDUSER=?");
			
			
			
			
			
		}catch(SQLException e){
			Logger lgr = Logger.getLogger(DAOUser.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		}finally {
			try {
				if (miStatement != null) {
					miStatement.close();
				}
				if (connection != null) {
					connection.getConnection().close();
				}
			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DAOUser.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}

	@Override
	public void alter(T t) throws SQLException {
		// TODO Auto-generated method stub

	}


}
