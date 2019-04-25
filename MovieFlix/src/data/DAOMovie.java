package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



import connection.ConnectionBBDD;


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
	}

	@Override
	public void drop(T t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(T t) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void listOfMovies(T t) {
		
		try {
		myStatement = connection.getConnection().prepareStatement("SELECT name,date,idGenre,numWatchers from movies");
		result = myStatement.executeQuery();
		 while(result.next()) {
			 System.out.println(result.getString("name"));
			 System.out.println(":");
			 System.out.println(result.getInt("date"));
			 System.out.println(":");
			 System.out.println("idGenre");
			 System.out.println(":");
			 System.out.println("numWatchers");
		}
	
     }catch (SQLException ex) {
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
}
