package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionBBDD;
import model.Subscription;
import model.TypeCatalog;
import model.User;
import utilities.ReadData;

public class DAOSubscription<T> implements IDAO<T> {
	
	/**
	 * The result
	 */
	ResultSet result;
	/**
	 * The connection.
	 */
	ConnectionBBDD connection = new ConnectionBBDD();
	/**
	 * The my Statement.
	 */
	PreparedStatement myStatement;
	
	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub
		/** The connection. */
		ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			Subscription s = (Subscription) t;
			myStatement = connection.getConnection().prepareStatement("INSERT INTO subscription VALUES(?,?,?,?,?)");
			myStatement.setInt(1, s.getIdSubscription());
			myStatement.setInt(2, s.getIdUser());
			myStatement.setInt(3, s.getFee());
			myStatement.setString(4, s.getTypePayment());
			myStatement.setInt(5, s.getType().getOrdinal());
			myStatement.executeUpdate();
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOUser.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (myStatement != null) {
					myStatement.close();
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
		/** The connection. */
		ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			User u = (User) t;
			

			myStatement = connection.getConnection().prepareStatement("DELETE subscription FROM subscription inner join users on subscription.idUser = users.idUser where users.nameUser = ? and users.lastName = ?");
			myStatement.setString(1, u.getNameUser());
			myStatement.setString(2, u.getLastName());
			System.out.println(myStatement);
			myStatement.executeUpdate();	
			
			
			
		}catch(SQLException e){
			Logger lgr = Logger.getLogger(DAOUser.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		}finally {
			try {
				if (myStatement != null) {
					myStatement.close();
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
	public void update(T t) throws SQLException {
		// TODO Auto-generated method stub
ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			
			User u = (User) t;
			String su=( ReadData.leerString("Introduce la nueva suscripcion (BASIC, EXTRA, PREMIUM"));
			
			
			myStatement = connection.getConnection().prepareStatement("UPDATE subscription,users SET typeCatalog=? WHERE users.nameUser=? and users.lastName=?");
		
			myStatement.setString(1,su);			
			myStatement.setString(2, u.getNameUser());		
			myStatement.setString(3, u.getLastName());
			
			System.out.println(myStatement.toString());
			
			myStatement.executeUpdate();
			
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOUser.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				if (myStatement != null) {
					myStatement.close();
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
	
}
