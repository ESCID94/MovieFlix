package data;

import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDAO.
 *
 * @param <T> the generic type
 */
public interface IDAO <T> {

	/**
	 * Adds the.
	 *
	 * @param t the t
	 * @throws SQLException the SQL exception
	 */
	public void add(T t) throws SQLException;
	
	/**
	 * Drop.
	 *
	 * @param t the t
	 * @throws SQLException the SQL exception
	 */
	public void drop(T t) throws SQLException;
	
	/**
	 * Alter.
	 *
	 * @param t the t
	 * @throws SQLException the SQL exception
	 */
	public void alter(T t) throws SQLException;
}
