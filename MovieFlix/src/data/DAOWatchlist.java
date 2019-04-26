package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionBBDD;
import model.Movie;
import model.Watchlist;
import utilities.ReadData;

/**
 * The Class DAO Watchlist
 * @author Lucas
 *
 */

public class DAOWatchlist <T> implements IDAO<T> {
	/**
	 *  The result
	 */
	ResultSet result;
	/**
	 * The connection
	 */
	ConnectionBBDD connection = new ConnectionBBDD();
	/**
	 * The myStatement
	 */
	PreparedStatement myStatement;
	@Override
	public void add(T t) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * The Connection
		 */
		ConnectionBBDD connection = new ConnectionBBDD();
		Movie m = new Movie();
		try {
			Watchlist w = (Watchlist) t;
			myStatement = connection.getConnection().prepareStatement("INSERT INTO watchlist VALUES (?,?)");
			myStatement.setInt(1, w.getIdUser());
			myStatement.setInt(2, w.getIdMovie());
			System.out.println(myStatement.toString());
			myStatement.executeUpdate();
			DAOMovie.topRated();
			
		}catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOWatchlist.class.getName());
			lgr.log(Level.SEVERE,e.getMessage(), e );
		} finally {
			try {
				if (myStatement != null) {
					myStatement.close();
				}
				if (connection != null) {
					connection.getConnection().close();
				}
			}catch (SQLException e) {
				Logger lgr = Logger.getLogger(DAOWatchlist.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}
	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			Watchlist w = (Watchlist) t;
			
			myStatement = connection.getConnection().prepareStatement("DELETE FROM watchlist WHERE IdUser=?, AND IdMovie=?");
			
			myStatement.setInt(1, w.getIdUser());
			myStatement.setInt(2, w.getIdMovie());
			myStatement.executeUpdate();
		}catch(SQLException e) {
			Logger lgr = Logger.getLogger(DAOWatchlist.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		}finally {
			try {
				if (myStatement != null) {
					myStatement.close();
				}
				if (connection != null) {
					connection.getConnection().close();
				}
			}catch (SQLException e) {
				Logger lgr= Logger.getLogger(DAOWatchlist.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(),e);
			}
		}
	}
	@Override
	public void update(T t) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionBBDD connectionBBDD = new ConnectionBBDD();
		try {
			Watchlist w = (Watchlist) t;
			
			//w.modifyWatchlist(w); no existe el metodo aun
			
			myStatement.setInt(1, w.getIdUser());
			myStatement.setInt(2, w.getIdMovie());
			System.out.println(myStatement.toString());
			myStatement.executeUpdate();
			
		}catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOWatchlist.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(),e);
		}finally {
			try {
				if (myStatement != null) {
					myStatement.close();
				}
				if (connection != null) {
					connectionBBDD.getConnection().close();
				}
			}catch(SQLException e) {
				Logger lgr = Logger.getLogger(DAOWatchlist.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(),e);
			}
		}
	}
	
	
	
}
