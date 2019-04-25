package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionBBDD;
import model.Catalog;

/**
 * The Class DAOCatalog.
 * 
 * 
 * @author Lucas
 *
 * @param <T> the generic type.
 */
public class DAOCatalog <T> implements IDAO <T> {
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
ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			Catalog cat = (Catalog) t;
			//Hace falta el idUser para esta sentencia:
			myStatement = connection.getConnection().prepareStatement("INSERT INTO CATALOG VALUES(?,?,?)");
			myStatement.setInt(2, cat.getIdSubscription());
			myStatement.setString(3, cat.getIdGenre());
			
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
ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			Catalog cat = (Catalog) t;

			myStatement = connection.getConnection().prepareStatement("DELETE FROM catalog WHERE idSubscription=? AND idGenre=?");
			myStatement.setInt(2, cat.getIdSubscription());
			myStatement.setString(3, cat.getIdGenre());
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
			Catalog cat = (Catalog) t;
			
			//String idAux = cat.getIdGenre(); Aun no esta hecho.
			
			//cat.modifyIdGenre(cat); Aun no está hecha la funcion modifyIdGenre
			
			myStatement = connection.getConnection().prepareStatement("UPDATE CATALOG SET idSubscription=? WHERE idGenre=?");
			myStatement.setInt(2, cat.getIdSubscription());
			myStatement.setString(3, cat.getIdGenre());
			myStatement.executeUpdate();
			
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
