package data;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionBBDD;
import model.Movie;
import utilities.ReadData;
import utilities.ReadFile;

/**
 * The Class DAOMovie.
 * 
 * 
 * @author Lucas
 *
 * @param <T> the generic type.
 */
public class DAOMovie<T> implements IDAO<T> {
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
			Movie m = (Movie) t;
			myStatement = connection.getConnection().prepareStatement("INSERT INTO movies VALUES(?,?,?,?,0)");
			myStatement.setInt(1, m.getIdMovie());
			myStatement.setString(2, m.getName());
			myStatement.setInt(3, m.getDate());
			myStatement.setInt(4, m.getGenre().getOrdinal());
			System.out.println(myStatement.toString());
			myStatement.executeUpdate();
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOMovie.class.getName());
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
				Logger lgr = Logger.getLogger(DAOMovie.class.getName());
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
			Movie m = (Movie) t;

			myStatement = connection.getConnection().prepareStatement("DELETE FROM movies WHERE name=?");
			myStatement.setString(1, m.getName());
			myStatement.executeUpdate();
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOMovie.class.getName());
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
				Logger lgr = Logger.getLogger(DAOMovie.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}

	@Override
	public void update(T t) throws SQLException {
		// TODO Auto-generated method stub
		/** The connection. */
		ConnectionBBDD connection = new ConnectionBBDD();
		
		try {
			Movie m = (Movie) t;
			
			String nameAux = m.getName();
			
			m.modifyUser(m);;
			
			myStatement = connection.getConnection().prepareStatement("UPDATE MOVIES SET name=?,date=?,idGenre=? WHERE NAME=?");
		
			myStatement.setString(1, m.getName());
			myStatement.setInt(2, m.getDate());
			myStatement.setInt(3, m.getGenre().getOrdinal());
			myStatement.setString(4, nameAux);
			System.out.println(myStatement.toString());
			
			myStatement.executeUpdate();
			
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DAOMovie.class.getName());
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
				Logger lgr = Logger.getLogger(DAOMovie.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}

	public void listOfMovies(T t) {

		try {
			myStatement = connection.getConnection()
					.prepareStatement("SELECT name,date,idGenre,numWatchers from movies");
			result = myStatement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("name"));
				System.out.println(":");
				System.out.println(result.getInt("date"));
				System.out.println(":");
				System.out.println("idGenre");
				System.out.println(":");
				System.out.println("numWatchers");
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DAOMovie.class.getName());
			lgr.log(Level.INFO, "------- Epic Fail");
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {

			try {
				if (result != null) {
					result.close();
				}
				if (myStatement != null) {
					myStatement.close();
				}
				if (connection != null) {
					connection.getConnection().close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(DAOMovie.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}

	
	public void addMoviesBBDD(File file) throws SQLException{
		
		if (ReadData.leerString("Introduce si el fichero es por categorias de (nombre) o (numero))").equals("nombre")){
			ReadFile.extractMoviesByCat(file);
		} 
		else ReadFile.extractMoviesByNumCat(file);
		
		
	}
	public void movieMoreViews() {
		
	}
}
