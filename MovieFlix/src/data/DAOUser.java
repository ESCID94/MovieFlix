package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionBBDD;
import exceptions.DAOException;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOUser.
 *
 * @param <T> the generic type
 */
public class DAOUser<T> implements IDAO<T> {

	
	
	/** The mi statement. */
	PreparedStatement miStatement;

	/* (non-Javadoc)
	 * @see data.IDAO#add(java.lang.Object)
	 */
	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub
		/** The connection. */
		ConnectionBBDD connection = new ConnectionBBDD();
		
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

	/* (non-Javadoc)
	 * @see data.IDAO#drop(java.lang.Object)
	 */
	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub
		
		/** The connection. */
		ConnectionBBDD connection = new ConnectionBBDD();
		
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

	/* (non-Javadoc)
	 * @see data.IDAO#alter(java.lang.Object)
	 */
	@Override
	public void update(T t) throws SQLException {
		// TODO Auto-generated method stub
		/** The connection. */
		ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			User u = (User) t;
			
			String nameAux = u.getNameUser();
			
			u.modifyUser(u);
			
			miStatement = connection.getConnection().prepareStatement("UPDATE USERS SET NAMEUSER=?,LASTNAME=? WHERE NAMEUSER=?");
		
			miStatement.setString(1, u.getNameUser());
			miStatement.setString(2, u.getLastName());
			miStatement.setString(3, nameAux);
			System.out.println(miStatement.toString());
			
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


}
