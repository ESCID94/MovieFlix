package utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionBBDD;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Operations.
 */
public class Operations {
	
	/**
	 * Exists.
	 *
	 * @param id the id
	 * @param tab the tab
	 * @return true, if successful
	 */
	public static boolean exists(int id, String tab) {
		boolean exists = false;
		ConnectionBBDD connection = new ConnectionBBDD();
		PreparedStatement miStatement = null;
		
			
			try {
				
				if(tab.equals("users")) {	
					miStatement = connection.getConnection().prepareStatement("SELECT COUNT(idUser) AS TOTAL FROM users WHERE idUser=?");
					miStatement.setInt(1, id);
				}
				
				else if(tab.equals("peliculas")) {
					miStatement = connection.getConnection().prepareStatement("SELECT COUNT(idPelicula) AS TOTAL FROM users WHERE idPelicula=?");
					miStatement.setInt(1, id);
					
				}
				//Add for all tables with ids
				
				ResultSet result = miStatement.executeQuery();
				
				while(result.next()) {
					int count = result.getInt("TOTAL");
					
				if  (count >= 1) {exists = true;}
				else exists = false;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return exists;

		
	}
}
